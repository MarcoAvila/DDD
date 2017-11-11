package com.procergs.ddd.test.unitofwork;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.procergs.ddd.unitofwork.UnitOfWork;
import com.procergs.ddd.unitofwork.UnitOfWorkImpl;
import com.procergs.ddd.util.Log;

public class TesteUnitOfWorkCreateUpdate {

	
	
	
	
	@Before
	public void setUp() {

		Log.log("Testando UoW...");		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void createEntity() {
			
		//Repositories		
		InstrumentoREP instrumentoREP = new InstrumentoREP(); 
		BandaREP bandaREP = new BandaREP(); 

		UnitOfWork uow = new UnitOfWorkImpl(instrumentoREP, 
											bandaREP);
				
		//Entities
		InstrumentoEN instrumentoEN = new InstrumentoEN();
		BandaEN bandaEN = new BandaEN(1L);
		
		uow.add(instrumentoEN);
		uow.add(bandaEN);
		
		instrumentoEN.setState(2);
		
		uow.commit();
		
		Assert.assertEquals(1, instrumentoREP.getEntities().size());
		Assert.assertEquals(0, bandaREP.getEntities().size());
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void updateEntity() {
			
		final int NEW_STATE = 1;
		
		//Repositories		
		InstrumentoREP instrumentoREP = new InstrumentoREP(); 
		
		UnitOfWork uow = new UnitOfWorkImpl(instrumentoREP);
				
		//Entities
		InstrumentoEN instrumentoEN = new InstrumentoEN();		
		instrumentoREP.add(instrumentoEN);
		
		instrumentoEN = new InstrumentoEN(1L);	
		uow.add(instrumentoEN);
		
		instrumentoEN.setState(NEW_STATE);
		
		uow.commit();

		Assert.assertEquals(NEW_STATE, instrumentoREP.getEntities().get(0).getState());
	}
	 
	
	
	
	
	
	
	
	
	
	
	
	
}
