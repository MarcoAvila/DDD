package org.marcoavila.ddd.test.unitofwork;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.marcoavila.ddd.unitofwork.UnitOfWork;
import org.marcoavila.ddd.unitofwork.UnitOfWorkImpl;
import org.marcoavila.ddd.util.Log;

public class TestUnitOfWorkRemove {

	
	
	
	
	@Before
	public void setUp() {

		Log.log("Testing UnitOfWork...");	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
		

	
	@Test
	public void removeEntity() {

		//Repositories		
		InstrumentREP instrumentREP = new InstrumentREP(); 

		UnitOfWork uow = new UnitOfWorkImpl(instrumentREP);
		
		//Entities		
		instrumentREP.add( new InstrumentEN() ); // id 1	
		instrumentREP.add( new InstrumentEN() ); // id 2

		Assert.assertEquals(2, instrumentREP.getEntities().size() );

		InstrumentEN instrumentoEN = uow.find( new InstrumentEN(1L) );
					
		uow.remove(instrumentoEN);
		
		uow.commit();
								
		Assert.assertEquals(1, instrumentREP.getEntities().size() );
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
