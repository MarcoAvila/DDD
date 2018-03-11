package org.marcoavila.ddd.facade;

import org.marcoavila.ddd.repository.Repository;
import org.marcoavila.ddd.unitofwork.UnitOfWork;
import org.marcoavila.ddd.unitofwork.UnitOfWorkImpl;

public class AbstractUnitOfWorkFacade extends AbstractFacade {
	
	protected final UnitOfWork unitOfWork;
	



	protected AbstractUnitOfWorkFacade(Repository<?,?>... reps) {
		
		this.unitOfWork = new UnitOfWorkImpl(reps);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
