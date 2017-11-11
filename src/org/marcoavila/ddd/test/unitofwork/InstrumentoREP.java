package com.procergs.ddd.test.unitofwork;

import java.util.ArrayList;
import java.util.List;

import com.procergs.ddd.repository.AbstractRepository;

public class InstrumentoREP extends AbstractRepository<InstrumentoEN, Long> {

	private long id = 1L;
	
	private List<InstrumentoEN> entities = new ArrayList<>();
	
	
	
	
	
	
	
	
	

	
	@Override
	protected InstrumentoEN addImpl(InstrumentoEN entity) {

		entity.setId(id++);
		
		entities.add(entity);
		
		return entity;
	}
	
	
	
	
	
	
	
	
	
	
	
	


	@Override
	protected InstrumentoEN saveImpl(InstrumentoEN entity) {

		for (int i=0; i<entities.size(); i++)
			if (entities.get(i).equals(entity)) {
				entities.set(i, entity);
				return entity;
			}
		
		return null;		
	}






	
	
	
	
	
	
	
	



	@Override
	protected InstrumentoEN findImpl(Long id) {

		for (InstrumentoEN i : entities)
			if (i.getId().equals(id))
				return i;
		
		return null;		
	}


	
	
	
	
	






	@Override
	protected void removeImpl(InstrumentoEN entity) {

		InstrumentoEN i = findImpl( entity.getId() );
		
		entities.remove(i);
	}














	public List<InstrumentoEN> getEntities() {
		return entities;
	}
	
	
	
	

	
	
	
	
/*
	public static void main(String[] a) {
		
		InstrumentoEN i = new InstrumentoEN();
		
		DomainUtil.lookForAggregateRoots(i);
	}
*/

	
	
	
	
	
	
	
	
}
