package org.marcoavila.ddd.repository;

import java.util.List;

import org.marcoavila.ddd.Entity;
import org.marcoavila.ddd.InvariantsOwner;
import org.marcoavila.ddd.util.DomainUtil;
import org.marcoavila.ddd.util.ExceptionUtil;

/**
 * 
 * @author Marco Avila
 */

public abstract class AbstractRepository<EN extends Entity<ID>, ID> implements Repository<EN, ID> {

	
	
	
	
	
	
	
	
	
	

	
	
	
	@Override
	public final RepReturn<EN> find(ID id) {
		
		try {
			EN entity = findImpl(id);	
			
			if (entity == null)
				return failure( errorNotFound(id) );

			//Invariants
			if (!entity.checkInvariants()) 		
				return failure( entity.message() );
			
			//AggregateRoot
			if (!DomainUtil.aggregateRoot(entity))
				return failure( errorNotAgg(entity, "FIND") );
			
			return success(entity);
		}
		catch(Exception e) {
			return failure( errorException("findImpl", e) );
		}				
	}
		
	
	
	
	
	
	
	
	protected EN findImpl(ID id) {
		throw new UnsupportedOperationException( errorNotImpl("find") );
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public final RepReturn<EN> add(EN entity) {

		//Invariants
		if (!entity.checkInvariants())
			return failure( entity.message() );

		//AggregateRoot
		if (!DomainUtil.aggregateRoot(entity))
			return failure( errorNotAgg(entity, "ADD") );
		
		try {
			EN addedEntity = addImpl(entity);

			if (addedEntity == null)
				return failure( errorNotAdded(entity) );

			return success(addedEntity);		
		}
		catch(Exception e) {
			return failure( errorException("addImpl", e) );
		}				
	}
		
	
	
		
	
	
	protected EN addImpl(EN entity) {
		throw new UnsupportedOperationException( errorNotImpl("add") );
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

	@Override
	public final RepReturn<EN> save(EN entity) {

		//Invariants
		if (!entity.checkInvariants())
			return failure( entity.message() );

		//AggregateRoot
		if (!DomainUtil.aggregateRoot(entity))
			return failure( errorNotAgg(entity, "SAVE") );

		try {
			EN savedEntity = saveImpl(entity);	

			if (savedEntity == null)
				return failure( errorNotSaved(entity) );	

			return success(savedEntity);	
		}
		catch(Exception e) {
			return failure( errorException("saveImpl", e) );
		}
	}
		
	
	
	
	
	
	
	
	protected EN saveImpl(EN entity) {
		throw new UnsupportedOperationException( errorNotImpl("save") );
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

	@Override
	public final RepReturn<EN> remove(EN entity) {

		//AggregateRoot
		if (!DomainUtil.aggregateRoot(entity))
			return failure( errorNotAgg(entity, "REMOVE") );
		
		try {
			removeImpl(entity);	

			return success();
		}
		catch(Exception e) {
			return failure( errorException("removeImpl", e) );
		}		
	}
		
	
	
	
	
	
	
	
	
	protected void removeImpl(EN entity) {
		throw new UnsupportedOperationException( errorNotImpl("remove") );
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	protected final RepReturn<EN> success() {
		
		return new RepReturn<EN>(true);
	}
			
	

	protected final RepReturn<EN> success(EN entity) {

		if (!entity.checkInvariants())
			return failure( entity.message() );		
		
		return new RepReturn<EN>(true, entity);
	}
	
	
	
	protected final RepReturn<EN> success(Object valueObject) {

		if (valueObject instanceof InvariantsOwner) {
			
			InvariantsOwner io = (InvariantsOwner)valueObject;
			
			if (!io.checkInvariants() )
				return failure( io.message() );		
		}
		
		return new RepReturn<EN>(true, valueObject);
	}

	
	
	protected final RepReturn<EN> success(List<EN> entities) {
		
		for (EN e : entities)
			if (!e.checkInvariants())
				return failure( e.message() );		
		
		return new RepReturn<EN>(true, entities);
	}
	
		
	
	protected final RepReturn<EN> failure(String errorMessage) {
		return new RepReturn<EN>(false, errorMessage);
	}
	
	
	
	
	
	
	
	
	
	

	
	private String errorException(String operation, Exception e) {		
		return "Error in method " + operation + " at " + this.getClass().getSimpleName() + ": " + ExceptionUtil.getMessage(e);
	}

	private String errorNotImpl(String operation) {		
		return "NOT IMPLEMENTED OPERATION (" + operation + ") on " + this.getClass().getSimpleName();
	}
	
	private String errorNotFound(ID id) {		
		return "ENTITY not found! " + this.getClass().getSimpleName() + " id: " + id;
	}
	
	private String errorNotAgg(Entity<ID> entity, String action) {		
		return "Can't " + action + " an ENTITY that is not an AGGREGATE ROOT! " + entity.getClass().getSimpleName();
	}
	
	private String errorNotAdded(Entity<ID> entity) {		
		return "ENTITY not added! " + entity.getClass().getSimpleName();
	}
	
	private String errorNotSaved(Entity<ID> entity) {		
		return "ENTITY not saved! " + this.getClass().getSimpleName() + " id: " + entity.getId();
	}
	
	
	

	
}
