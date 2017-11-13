package org.marcoavila.ddd.test.unitofwork;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.marcoavila.ddd.unitofwork.UnitOfWork;
import org.marcoavila.ddd.unitofwork.UnitOfWorkImpl;
import org.marcoavila.ddd.util.Log;

public class TestUnitOfWorkCreateUpdate {

	
	
	
	
	@Before
	public void setUp() {

		Log.log("Testing UnitOfWork...");		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void createEntity() {
			
		//Repositories		
		InstrumentREP instrumentREP = new InstrumentREP(); 
		BandREP bandREP = new BandREP(); 

		UnitOfWork uow = new UnitOfWorkImpl(instrumentREP, bandREP);
				
		//Entities
		InstrumentEN instrumentEN = new InstrumentEN();
		BandEN bandEN = new BandEN(1L);
		
		uow.add(instrumentEN);
		uow.add(bandEN);
		
		instrumentEN.setState(2);
		
		uow.commit();
		
		Assert.assertEquals(1, instrumentREP.getEntities().size());
		Assert.assertEquals(0, bandREP.getEntities().size());
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void updateEntity() {
			
		final int NEW_STATE = 1;
		
		//Repositories		
		InstrumentREP instrumentREP = new InstrumentREP(); 
		
		UnitOfWork uow = new UnitOfWorkImpl(instrumentREP);
				
		//Entities
		InstrumentEN instrumentEN = new InstrumentEN();		
		instrumentREP.add(instrumentEN);
		
		instrumentEN = new InstrumentEN(1L);	
		uow.add(instrumentEN);
		
		instrumentEN.setState(NEW_STATE);
		
		uow.commit();

		Assert.assertEquals(NEW_STATE, instrumentREP.getEntities().get(0).getState());
	}
	 
	
	
	
	
	
	
	
	
	
	
	
	
}
