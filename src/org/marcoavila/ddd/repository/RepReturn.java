package org.marcoavila.ddd.repository;

import java.io.Serializable;
import java.util.List;

import org.marcoavila.ddd.Entity;
import org.marcoavila.ddd.util.DomainUtil;

/**
 * 
 * @author Marco Avila
 */

public class RepReturn<EN extends Entity<?>> implements Serializable {

    private static final long serialVersionUID = 1L;
    
	private final boolean success;
	private final String message;
	
	private final EN entity;
	private final List<EN> entities;
	
	private final Object valueObject;
	
	

	
	public RepReturn(boolean success) {
	    this.success = success;
	    this.message = "";
	    this.entity = null;
	    this.entities = null;
	    this.valueObject = null;
    }


	
	
	
	public RepReturn(boolean success, String message) {
	    this.success = success;
	    this.message = message;
	    this.entity = null;
	    this.entities = null;
	    this.valueObject = null;
    }


	
	
	
	public RepReturn(boolean success, EN entity) {
	    this.success = aggregate(entity) ? success : false;
	    this.message = aggregate(entity) ? "" : "Entity is not an AGGREGATE ROOT! " + entity.getClass().getSimpleName();
	    this.entity = entity;
	    this.entities = null;
	    this.valueObject = null;
	}


	
	
	
	
	public RepReturn(boolean success, List<EN> entities) {
	    this.success = aggregate(entities) ? success : false;
	    this.message = aggregate(entities) ? "" : "Entity is not an AGGREGATE ROOT! " + entities.iterator().next().getClass().getSimpleName();
	    this.entity = null;
	    this.entities = entities;
	    this.valueObject = null;
    }
	
		

	
		
	
	public RepReturn(boolean success, Object valueObject) {
	    this.success = success;
	    this.message = "";
	    this.entity = null;
	    this.entities = null;
	    this.valueObject = valueObject;
    }

	
	
	
	
	
	
	
	
    public boolean success() {
	    return success;
    }
	
    public boolean failure() {
	    return !success;
    }
	
    public String message() {
	    return message;
    }
	
    public EN getEntity() {
	    return entity;
    }

	public List<EN> getEntities() {
		return entities;
	}

	public Object getValueObject() {
		return valueObject;
	}

	private boolean aggregate(EN entity) {
		return DomainUtil.aggregateRoot(entity);
	}

	private boolean aggregate(List<EN> entities) {
		for (EN entity : entities)
			if (!aggregate(entity))
				return false;
		return true;
	}
	


}
