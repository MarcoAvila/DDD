package org.marcoavila.ddd.test.unitofwork;

import java.util.ArrayList;
import java.util.List;

import org.marcoavila.ddd.repository.AbstractRepository;

public class BandREP extends AbstractRepository<BandEN, Long> {

	private long id = 1L;
	
	private List<BandEN> entities = new ArrayList<>();

	
	
	
	
	
	
	
	
	@Override
	protected BandEN addImpl(BandEN entity) {

		entity.setId(id++);
		
		entities.add(entity);
		
		return entity;
	}







	
	
	
	
	
	


	@Override
	protected BandEN saveImpl(BandEN entity) {

		for (int i=0; i<entities.size(); i++)
			if (entities.get(i).equals(entity)) {
				entities.set(i, entity);
				return entity;
			}
		
		return null;		
	}






	
	
	
	
	
	
	
	



	@Override
	protected BandEN findImpl(Long id) {

		for (BandEN i : entities)
			if (i.getId().equals(id))
				return i;
		
		return null;		
	}


	
	
	
	
	
	
	
	
	






	@Override
	protected void removeImpl(BandEN entity) {

		BandEN i = findImpl( entity.getId() );
		
		entities.remove(i);
	}








	
	
	
	






	public List<BandEN> getEntities() {
		return entities;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
