package org.marcoavila.ddd.unitofwork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.marcoavila.ddd.Entity;
import org.marcoavila.ddd.repository.RepReturn;
import org.marcoavila.ddd.repository.Repository;
import org.marcoavila.ddd.util.DomainUtil;
import org.marcoavila.ddd.util.ReflectionUtil;

/**
 * 
 * @author Marco Avila
 */
public class UnitOfWorkImpl implements UnitOfWork {

	private List<ObservedAggregateRoot> roots = new ArrayList<>();

	private List< Repository<Entity<?>,?> > repositories = new ArrayList<>();
	
	
	
	
	
	
		

	@SuppressWarnings("unchecked")
	public UnitOfWorkImpl(Repository<?,?>... reps) {
		
		for (Repository<?,?> r : reps)
			repositories.add( (Repository<Entity<?>,?>)r );
	}
	
	



	
	
	




	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <EN extends Entity<?>> EN find(EN persistedEntity) {

		if (!DomainUtil.aggregateRoot(persistedEntity))
			throw new IllegalArgumentException(MSG_ATTEMPT_FIND_NOT_ROOT);
		
		if (!DomainUtil.hasId(persistedEntity))
			throw new IllegalArgumentException(MSG_ATTEMPT_FIND_NO_ID);

		//Already in memory
		ObservedAggregateRoot root = findAggregateRoot(persistedEntity);
				
		if (root != null)
			return (EN)root.entity();	
						
		//Find in repository
		Repository repository = repositoryFor(persistedEntity);
		
		RepReturn<?> r = repository.find( persistedEntity.getId() );
			
		if (r.success())
			add( r.getEntity() );
		else
			setMessage( r.message() );  
				
		return (EN)r.getEntity();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void add(Entity<?> entity) {
		
		if (DomainUtil.hasId(entity) &&
			findAggregateRoot(entity) != null)
			return;
		
		if (!DomainUtil.aggregateRoot(entity))
			throw new IllegalArgumentException(MSG_ATTEMPT_ADD);
		
		addRoot(entity);
		
		lookForNestedAggregateRoots();	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public  <EN extends Entity<?>> void addAll(List<EN> entities) {
		for (EN e : entities)
			add(e);		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	@Override
	public void remove(Entity<?> persistedEntity) {

		if (!DomainUtil.hasId(persistedEntity))
			throw new IllegalArgumentException(MSG_ATTEMPT_REMOVE);
		
		ObservedAggregateRoot aggRoot = findAggregateRoot(persistedEntity);
		
		if (aggRoot == null)
			aggRoot = addRoot(persistedEntity);
		
		aggRoot.markToRemove();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//-------------------------------------------------------------------------------------------------	
	
	
	
	
	
	
	
	

	@Override
	public boolean commit() {

		lookForNestedAggregateRoots();		
		
		if (!checkCreation())
			return false;

		if (!checkUpdate())
			return false;
	
		if (!checkDelete())
			return false;
		
		clear();
						
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	





	




	private boolean checkCreation() {
		
		List<ObservedAggregateRoot> rootsToCreate = rootsToCreate();
		
		//Order by each other references
		orderByReferences(rootsToCreate);
			
		//Create
		for (ObservedAggregateRoot aggRoot : rootsToCreate) {

				Repository<Entity<?>,?> repository = repositoryFor( aggRoot.entity() );
				
				RepReturn<?> r = repository.add( aggRoot.entity() );
				
				if (r.failure()) 
					return returnFalseWithMessage( r.message() );
				
				aggRoot.markCreated();

				addMessage( "CREATED: " + entityLog(r.getEntity()));
			}
				
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	private boolean checkUpdate() {
		
		for (ObservedAggregateRoot aggRoot : roots)		
			
			if (aggRoot.changed() && 
			   !aggRoot.isCreated() &&				 
			   !aggRoot.isMarkedToRemove()) {

				Repository<Entity<?>,?> repository = repositoryFor( aggRoot.entity() );
				
				RepReturn<?> r = repository.save( aggRoot.entity() );
				
				if (r.failure()) 
					return returnFalseWithMessage( r.message() );
				
				addMessage( "UPDATED: " + entityLog(r.getEntity()));
			}
				
		return true;
	}
	
	
	


	
	
	
	
	
	
	
	
	
	
	

	
	private boolean checkDelete() {

		for (ObservedAggregateRoot aggRoot : roots)	
			
			if (aggRoot.isMarkedToRemove()) {
				
				Repository<Entity<?>,?> repository = repositoryFor( aggRoot.entity() );
				
				RepReturn<?> r = repository.remove( aggRoot.entity() );
				
				if (r.failure()) 
					return returnFalseWithMessage( r.message() );
				
				addMessage( "REMOVED: " + entityLog( aggRoot.entity() ));
			}
						
		return true;
	}
	
	
	

	
	


	
	
	
	
	
	
	
	

	
	
//-------------------------------------------------------------------------------------------------	
		
		
	
	
	
	
	
	
	

	private List<ObservedAggregateRoot> rootsToCreate() {
		
		List<ObservedAggregateRoot> noIdRoots = new ArrayList<>();
		
		for (ObservedAggregateRoot aggRoot : roots)		
			if (aggRoot.noId())
				noIdRoots.add(aggRoot);
						
		return noIdRoots;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	private void orderByReferences(List<ObservedAggregateRoot> roots) {
		
		Collections.sort(roots, new Comparator<ObservedAggregateRoot>() {
			@Override
			public int compare(ObservedAggregateRoot root1, ObservedAggregateRoot root2) {				
				return DomainUtil.referencedNewEntity(root1.entity(), root2.entity()) ? 1 : -1;
			}			
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	private void lookForNestedAggregateRoots() {
		
		for (int i=0; i<roots.size(); i++) {
			
			List<Entity<?>> newRoots = DomainUtil.lookForAggregateRoots( roots.get(i).entity() );
			
			for (Entity<?> e : newRoots) {	
				
				ObservedAggregateRoot oar = findAggregateRoot(e);
				
				if (oar == null)				
					roots.add( new ObservedAggregateRoot(e) );				
			}
		}
	}

	
	
	
	


	
	
	
	
	
	
		

	private ObservedAggregateRoot findAggregateRoot(Entity<?> persistedEntity) {

		for (ObservedAggregateRoot aggRoot : roots)	
			if (DomainUtil.hasId( aggRoot.entity() ) &&
				aggRoot.entity().equals(persistedEntity))
				return aggRoot;
		
		return null;
	}
	
	
	
	
	
	
	
	

	
	
	
	

	
	
	
	private ObservedAggregateRoot addRoot(Entity<?> entity) {
		
		ObservedAggregateRoot root = new ObservedAggregateRoot(entity);
		
		roots.add(root);
		
		return root;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	private void clear() {

		roots = new ArrayList<>();
	}
	
	
	
	

	
	
	
	
	
	
//-------------------------------------------------------------------------------------------------	
			
			
		
		
		
		
	
	
	
	


	private Repository<Entity<?>,?> repositoryFor(Entity<?> entity) {
				
		for (Repository<Entity<?>,?> r : repositories) {
			
			Class<?> repEntity = ReflectionUtil.parameterizedType( r.getClass() );
			
			if (repEntity.equals( entity.getClass() ))
				return r;
		}
		
		throw new IllegalStateException(MSG_NO_ENTITY + entity.getClass().getName());
	}
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	private String message = "";

	@Override
	public String message() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void addMessage(String message) {
		this.message += message + "\n";
	}

	private boolean returnFalseWithMessage(String message) {
		setMessage(message);
		return false;
	}

	private String entityLog(Entity<?> entity) {
		return entity.getClass().getSimpleName() + " (id " + entity.getId() + ")";
	}

		
	private static final String MSG_ATTEMPT_FIND_NOT_ROOT = "Attempt to FIND a non AGGREGATE ROOT!";
	
	private static final String MSG_ATTEMPT_FIND_NO_ID    = "Attempt to FIND an Entity without id!";

	private static final String MSG_ATTEMPT_ADD    = "Attempt to ADD a non AGGREGATE ROOT to the Unit of Work!";

	private static final String MSG_ATTEMPT_REMOVE = "Attempt to REMOVE an Entity without id!";

	private static final String MSG_NO_ENTITY      = "No repository for this Entity! ";

}



/*@Override
@SuppressWarnings("unchecked")
public void addRepository(Repository<?,?> repository) {		
	repositories.add( (Repository<Entity<?>,?>)repository) ;
}
*/
