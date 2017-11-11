package com.procergs.ddd.test.unitofwork;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.procergs.ddd.Entity;
import com.procergs.ddd.unitofwork.UnitOfWork;
import com.procergs.ddd.unitofwork.UnitOfWorkImpl;
import com.procergs.ddd.util.Log;

public class TesteUnitOfWorkAdd {

	
	
	
	
	@Before
	public void setUp() {

		Log.log("Testando UoW...");		
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
	@Test(expected = IllegalArgumentException.class) 
	public void addNonAggregateRoot() {
			
		UnitOfWork uow = new UnitOfWorkImpl();
				
		CordaEN cordaEN = new CordaEN(1L);
		
		uow.add(cordaEN);
	}
	

	
	
	
	
	
	
	
	@Test(expected = IllegalArgumentException.class) 
	public void addNonAggregateRoots() {
			
		UnitOfWork uow = new UnitOfWorkImpl();
				
		CordaEN corda1EN = new CordaEN(1L);
		CordaEN corda2EN = new CordaEN(2L);
		
		uow.addAll(Arrays.asList( new CordaEN[] { corda1EN, corda2EN} ));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Test
	public void addAggregateRoots() {
			
		UnitOfWork uow = new UnitOfWorkImpl();
		
		InstrumentoEN instrumentoEN = new InstrumentoEN(1L);
		BandaEN bandaEN = new BandaEN(1L);
		
		uow.add(instrumentoEN);
		uow.add(bandaEN);

		uow.addAll(Arrays.asList( new Entity<?>[] { instrumentoEN, bandaEN} ));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
