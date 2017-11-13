package org.marcoavila.ddd.test.unitofwork;

import java.util.ArrayList;
import java.util.List;

import org.marcoavila.ddd.repository.AbstractRepository;

public class InstrumentREP extends AbstractRepository<InstrumentEN, Long> {

	private long id = 1L;
	
	private List<InstrumentEN> entities = new ArrayList<>();
	
	
	
	
	
	
	
	
	

	
	@Override
	protected InstrumentEN addImpl(InstrumentEN entity) {

		entity.setId(id++);
		
		entities.add(entity);
		
		return entity;
	}
	
	
	
	
	
	
	
	
	
	
	
	


	@Override
	protected InstrumentEN saveImpl(InstrumentEN entity) {

		for (int i=0; i<entities.size(); i++)
			if (entities.get(i).equals(entity)) {
				entities.set(i, entity);
				return entity;
			}
		
		return null;		
	}






	
	
	
	
	
	
	
	



	@Override
	protected InstrumentEN findImpl(Long id) {

		for (InstrumentEN i : entities)
			if (i.getId().equals(id))
				return i;
		
		return null;		
	}


	
	
	
	
	






	@Override
	protected void removeImpl(InstrumentEN entity) {

		InstrumentEN i = findImpl( entity.getId() );
		
		entities.remove(i);
	}














	public List<InstrumentEN> getEntities() {
		return entities;
	}
	
	
	
	

	
	
	
	
/*
	public static void main(String[] a) {
		
		InstrumentoEN i = new InstrumentoEN();
		
		DomainUtil.lookForAggregateRoots(i);
	}
*/

	
	
	
	
	
	
	
	
}
