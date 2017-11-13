package org.marcoavila.ddd.test.unitofwork;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.marcoavila.ddd.unitofwork.UnitOfWork;
import org.marcoavila.ddd.unitofwork.UnitOfWorkImpl;
import org.marcoavila.ddd.util.Log;

public class TestUnitOfWorkFind {

	
	
	
	
	@Before
	public void setUp() {

		Log.log("Testing UnitOfWork...");	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	@Test
	public void findEntity() {

		//Repositories		
		InstrumentREP instrumentREP = new InstrumentREP(); 

		UnitOfWork uow = new UnitOfWorkImpl(instrumentREP);
		
		//Entities		
		instrumentREP.add( new InstrumentEN() ); // id 1	
		instrumentREP.add( new InstrumentEN() ); // id 2
						
		InstrumentEN instrumentoEN = uow.find( new InstrumentEN(1L) );
			
		Assert.assertEquals(new Long(1L), instrumentoEN.getId());
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
