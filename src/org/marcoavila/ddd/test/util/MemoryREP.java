package org.marcoavila.ddd.test.util;

import java.util.ArrayList;
import java.util.List;

import com.procergs.ddd.Entity;
import com.procergs.ddd.repository.AbstractRepository;

public abstract class MemoryREP<EN extends Entity<ID>, ID> extends AbstractRepository<EN, ID> {
	
	private List<EN> entities = new ArrayList<>();

	
	
	
	
	
	
	
	
	@Override
	protected EN addImpl(EN entity) {

		entity.setId( generateId() );
		
		entities.add( cloneEntity(entity) );
		
		return entity;
	}



	
	
	
	
	
	protected abstract ID generateId();
	
	protected abstract EN cloneEntity(EN entity);




	
	
	
	
	
	


	@Override
	protected EN saveImpl(EN entity) {

		for (int i=0; i<entities.size(); i++)
			if (entities.get(i).equals(entity)) {
				entities.set(i, cloneEntity(entity));
				return entity;
			}
		
		return null;		
	}






	
	
	
	
	
	
	
	



	@Override
	protected EN findImpl(ID id) {

		for (EN e : entities)
			if (e.getId().equals(id))
				return cloneEntity(e);
		
		return null;		
	}


	
	
	
	
	
	
	
	
	






	@Override
	protected void removeImpl(EN entity) {

		EN i = findImpl( entity.getId() );
		
		entities.remove(i);
	}








	
	
	
	






	public List<EN> getEntities() {
		return entities;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
