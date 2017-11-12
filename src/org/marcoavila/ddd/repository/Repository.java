package org.marcoavila.ddd.repository;

import org.marcoavila.ddd.Entity;

/**
 * 
 * @author Marco Avila
 */
public interface Repository <EN extends Entity<ID>, ID> {
	
	public RepReturn<EN> add(EN entity);

	public RepReturn<EN> find(ID id);
	
	public RepReturn<EN> save(EN entity);
	
	public RepReturn<EN> remove(EN entity);
	
}
