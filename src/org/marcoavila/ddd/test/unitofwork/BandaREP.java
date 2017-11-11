package com.procergs.ddd.test.unitofwork;

import java.util.ArrayList;
import java.util.List;

import com.procergs.ddd.repository.AbstractRepository;

public class BandaREP extends AbstractRepository<BandaEN, Long> {

	private long id = 1L;
	
	private List<BandaEN> entities = new ArrayList<>();

	
	
	
	
	
	
	
	
	@Override
	protected BandaEN addImpl(BandaEN entity) {

		entity.setId(id++);
		
		entities.add(entity);
		
		return entity;
	}







	
	
	
	
	
	


	@Override
	protected BandaEN saveImpl(BandaEN entity) {

		for (int i=0; i<entities.size(); i++)
			if (entities.get(i).equals(entity)) {
				entities.set(i, entity);
				return entity;
			}
		
		return null;		
	}






	
	
	
	
	
	
	
	



	@Override
	protected BandaEN findImpl(Long id) {

		for (BandaEN i : entities)
			if (i.getId().equals(id))
				return i;
		
		return null;		
	}


	
	
	
	
	
	
	
	
	






	@Override
	protected void removeImpl(BandaEN entity) {

		BandaEN i = findImpl( entity.getId() );
		
		entities.remove(i);
	}








	
	
	
	






	public List<BandaEN> getEntities() {
		return entities;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
