package com.procergs.ddd.test.unitofwork;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.procergs.ddd.unitofwork.UnitOfWork;
import com.procergs.ddd.unitofwork.UnitOfWorkImpl;
import com.procergs.ddd.util.Log;

public class TesteUnitOfWorkRemove {

	
	
	
	
	@Before
	public void setUp() {

		Log.log("Testando UoW...");		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
		

	
	@Test
	public void removeEntity() {

		//Repositories		
		InstrumentoREP instrumentoREP = new InstrumentoREP(); 

		UnitOfWork uow = new UnitOfWorkImpl(instrumentoREP);
		
		//Entities		
		instrumentoREP.add( new InstrumentoEN() ); // id 1	
		instrumentoREP.add( new InstrumentoEN() ); // id 2

		Assert.assertEquals(2, instrumentoREP.getEntities().size() );

		InstrumentoEN instrumentoEN = uow.find( new InstrumentoEN(1L) );
					
		uow.remove(instrumentoEN);
		
		uow.commit();
								
		Assert.assertEquals(1, instrumentoREP.getEntities().size() );
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
