package org.marcoavila.ddd.test.unitofwork;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import org.marcoavila.ddd.Entity;
import org.marcoavila.ddd.unitofwork.UnitOfWork;
import org.marcoavila.ddd.unitofwork.UnitOfWorkImpl;
import org.marcoavila.ddd.util.Log;

public class TestUnitOfWorkAdd {

	
	
	
	
	@Before
	public void setUp() {

		Log.log("Testing UnitOfWork...");		
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
	@Test(expected = IllegalArgumentException.class) 
	public void addNonAggregateRoot() {
			
		UnitOfWork uow = new UnitOfWorkImpl();
				
		StringEN stringEN = new StringEN(1L);
		
		uow.add(stringEN);
	}
	

	
	
	
	
	
	
	
	@Test(expected = IllegalArgumentException.class) 
	public void addNonAggregateRoots() {
			
		UnitOfWork uow = new UnitOfWorkImpl();
				
		StringEN string1EN = new StringEN(1L);
		StringEN string2EN = new StringEN(2L);
		
		uow.addAll(Arrays.asList( new StringEN[] { string1EN, string2EN} ));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Test
	public void addAggregateRoots() {
			
		UnitOfWork uow = new UnitOfWorkImpl();
		
		InstrumentEN instrumentEN = new InstrumentEN(1L);
		BandEN bandEN = new BandEN(1L);
		
		uow.add(instrumentEN);
		uow.add(bandEN);

		uow.addAll(Arrays.asList( new Entity<?>[] { instrumentEN, bandEN} ));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
