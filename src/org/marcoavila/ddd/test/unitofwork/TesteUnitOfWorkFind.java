package com.procergs.ddd.test.unitofwork;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.procergs.ddd.unitofwork.UnitOfWork;
import com.procergs.ddd.unitofwork.UnitOfWorkImpl;
import com.procergs.ddd.util.Log;

public class TesteUnitOfWorkFind {

	
	
	
	
	@Before
	public void setUp() {

		Log.log("Testando UoW...");		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	@Test
	public void findEntity() {

		//Repositories		
		InstrumentoREP instrumentoREP = new InstrumentoREP(); 

		UnitOfWork uow = new UnitOfWorkImpl(instrumentoREP);
		
		//Entities		
		instrumentoREP.add( new InstrumentoEN() ); // id 1	
		instrumentoREP.add( new InstrumentoEN() ); // id 2
						
		InstrumentoEN instrumentoEN = uow.find( new InstrumentoEN(1L) );
			
		Assert.assertEquals(new Long(1L), instrumentoEN.getId());
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
