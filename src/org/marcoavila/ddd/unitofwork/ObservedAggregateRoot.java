package org.marcoavila.ddd.unitofwork;

import org.marcoavila.ddd.Entity;
import org.marcoavila.ddd.util.DomainUtil;

/**
 * 
 * @author Marco Avila
 */
public class ObservedAggregateRoot {

	private final Entity<?> entity;
		
	private final int hashCode;
	
	private boolean markedToRemove = false;
	
	private boolean created = false;
	
	
	
	

	public ObservedAggregateRoot(Entity<?> entity) {
		this.entity = entity;
		this.hashCode = entity.hashCode();
	}





	
	
	
	
	
	
	
	public boolean noId() {
		return entity.getId() == null;
	}
		


	public boolean changed() {
		return hashCode != entity.hashCode();
	}
	
	
	
	
	

	
	
	
	


	public void markToRemove() {
		markedToRemove = true;
	}


	public boolean isMarkedToRemove() {
		return markedToRemove;
	}


	
	
	
	
	
	
	
	
	


	public void markCreated() {
		created = true;
	}



	public boolean isCreated() {
		return created;
	}



	
	
	
	
	
	


	
	




	public Entity<?> entity() {
		return entity;
	}












	@Override
	public String toString() {
		return entity.getClass().getSimpleName() +
				(DomainUtil.hasId(entity) ? " [ID " + entity.getId() + "]" : " [NO ID]" )+
				(markedToRemove ? " [MARKED TO REMOVE]" : "") +
				(created ? " [CREATED]" : "") +
				(changed() ? " [CHANGED]" : "");
	}

	
	
	
	
	



}
