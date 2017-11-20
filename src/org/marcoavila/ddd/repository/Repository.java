package org.marcoavila.ddd.repository;

import org.marcoavila.ddd.Entity;

/**
 * Abstraction that represents an Domain Model Repository. 
 *
 * Declare collection like operations. 
 *
 * @author Marco Avila
 */
public interface Repository <EN extends Entity<ID>, ID> {
	
	public RepReturn<EN> add(EN entity);

	public RepReturn<EN> find(ID id);
	
	public RepReturn<EN> save(EN entity);
	
	public RepReturn<EN> remove(EN entity);
	
}
