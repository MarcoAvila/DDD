package com.procergs.ddd.test.unitofwork;

import java.util.ArrayList;
import java.util.List;

import com.procergs.ddd.repository.AbstractRepository;

public class FestivalREP extends AbstractRepository<FestivalEN, Long> {

	private long id = 1L;
	
	private List<FestivalEN> entities = new ArrayList<>();

	
	
	
	
	
	
	
	
	@Override
	protected FestivalEN addImpl(FestivalEN entity) {

		entity.setId(id++);
		
		entities.add(entity);
		
		return entity;
	}







	
	
	
	
	
	


	@Override
	protected FestivalEN saveImpl(FestivalEN entity) {

		for (int i=0; i<entities.size(); i++)
			if (entities.get(i).equals(entity)) {
				entities.set(i, entity);
				return entity;
			}
		
		return null;		
	}






	
	
	
	
	
	
	
	



	@Override
	protected FestivalEN findImpl(Long id) {

		for (FestivalEN i : entities)
			if (i.getId().equals(id))
				return i;
		
		return null;		
	}


	
	
	
	
	
	
	
	
	






	@Override
	protected void removeImpl(FestivalEN entity) {

		FestivalEN i = findImpl( entity.getId() );
		
		entities.remove(i);
	}








	
	
	
	






	public List<FestivalEN> getEntities() {
		return entities;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
