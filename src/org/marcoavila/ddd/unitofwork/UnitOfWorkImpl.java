package org.marcoavila.ddd.unitofwork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.marcoavila.ddd.Entity;
import org.marcoavila.ddd.repository.RepReturn;
import org.marcoavila.ddd.repository.Repository;
import org.marcoavila.ddd.util.DomainUtil;
import org.marcoavila.ddd.util.Log;
import org.marcoavila.ddd.util.ReflectionUtil;

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
		
		if (!doCreation())
			return false;

		if (!doUpdate())
			return false;
	
		if (!doRemove())
			return false;
		
		clear();
						
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	





	




	private boolean doCreation() {
		
		List<ObservedAggregateRoot> roots = entitiesToCreate();
					
		//Create
		for (ObservedAggregateRoot root : roots) {
			
			Repository<Entity<?>,?> repository = repositoryFor( root.entity() );
			
			RepReturn<?> r = repository.add( root.entity() );
			
			if (r.failure()) 
				return returnFalseWithMessage( r.message() );

			root.markCreated();

			if (hasNullCyclicRef(root))
				root.markDirty();
				
			addMessage( "CREATED " + entityLog(r.getEntity()));
		}
				
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	private boolean doUpdate() {

		List<ObservedAggregateRoot> roots = entitiesToUpdate();
		
		for (ObservedAggregateRoot root : roots){

			Repository<Entity<?>,?> repository = repositoryFor( root.entity() );
			
			RepReturn<?> r = repository.save( root.entity() );
			
			if (r.failure()) 
				return returnFalseWithMessage( r.message() );
			
			addMessage( "UPDATED " + entityLog(r.getEntity()));
		}
				
		return true;
	}
	
	
	


	
	
	
	
	
	
	
	
	
	
	

	
	private boolean doRemove() {

		List<ObservedAggregateRoot> roots = entitiesToDelete();
		
		for (ObservedAggregateRoot root : roots) {
				
			Repository<Entity<?>,?> repository = repositoryFor( root.entity() );
			
			RepReturn<?> r = repository.remove( root.entity() );
			
			if (r.failure()) 
				return returnFalseWithMessage( r.message() );
			
			addMessage( "REMOVED " + entityLog( root.entity() ));
		}
						
		return true;
	}
	
	
	

	
	


	
	
	
	
	
	
	
	

	
	
//-------------------------------------------------------------------------------------------------	
		
		
	
	
	
	@Override
	public void printChangesToCommit() {

		Log.printLn("------------------------");	
		Log.printLn("Changes ready to commit:");	
			
		for (ObservedAggregateRoot root : entitiesToCreate())
			Log.printLn("CREATE " + root.toString() );
	
		for (ObservedAggregateRoot root : entitiesToUpdate())
			Log.printLn("UPDATE " +  root.toString() );

		for (ObservedAggregateRoot root : entitiesToDelete())
			Log.printLn("DELETE " + root.toString() );

		Log.printLn("------------------------");
	}
	
	
	
	
	
	
	
	
	
	

	public List<ObservedAggregateRoot> entitiesToCreate() {
		
		List<ObservedAggregateRoot> toCreate = new ArrayList<>();
		
		for (ObservedAggregateRoot root : roots)		
			if (root.noId())
				toCreate.add(root);

		//Order by each other references
		orderByReferences(toCreate);
						
		return toCreate;
	}
	
	
	
	
	
	
	


	
	
	public List<ObservedAggregateRoot> entitiesToUpdate() {
		
		List<ObservedAggregateRoot> toUpdate = new ArrayList<>();
		
		for (ObservedAggregateRoot root : roots)		
			if (root.changed() && 
				root.hasId() &&
				!root.isCreated() &&				 
				!root.isMarkedToRemove())
				toUpdate.add(root);
						
		return toUpdate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

	public List<ObservedAggregateRoot> entitiesToDelete() {
		
		List<ObservedAggregateRoot> toDelete = new ArrayList<>();
		
		for (ObservedAggregateRoot root : roots)		
			if (root.isMarkedToRemove())
				toDelete.add(root);
						
		return toDelete;
	}
	
	
	

	
	
	
	
	
	
	
	

	
	
	
//-------------------------------------------------------------------------------------------------	
			
			
		
	
	
	
	
	
	

	
	
	private boolean hasNullCyclicRef(ObservedAggregateRoot root) {
		
		List<Entity<?>> nested = DomainUtil.lookForAggregateRoots( root.entity() );
		
		for (Entity<?> entity : nested)
			if (DomainUtil.noId(entity)) 
				return true;
						
		return false;
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

		for (ObservedAggregateRoot aggRoot : roots)	{
			
			if (DomainUtil.hasId( aggRoot.entity() )) {
				if (aggRoot.entity().equals(persistedEntity))
					return aggRoot;
			}
			else
				if (aggRoot.entity() == persistedEntity)
					return aggRoot;			
		}
		
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
			
			//Procura também pelo repositório das superclasses
			List<Class<?>> superclasses = ReflectionUtil.hierarchy( entity.getClass() );
						
			for (Class<?> c : superclasses)
    			if (repEntity.equals(c))
    				return r;
    	}
		
		throw new IllegalStateException(MSG_NO_REPOSITORY + entity.getClass().getName());
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

	private static final String MSG_NO_REPOSITORY      = "No repository for this Entity! ";

}



/*@Override
@SuppressWarnings("unchecked")
public void addRepository(Repository<?,?> repository) {		
	repositories.add( (Repository<Entity<?>,?>)repository) ;
}
*/
