package com.procergs.ddd.test.unitofwork;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.procergs.ddd.unitofwork.UnitOfWork;
import com.procergs.ddd.unitofwork.UnitOfWorkImpl;
import com.procergs.ddd.util.Log;

public class TesteUnitOfWork {

	
	
	
	
	@Before
	public void setUp() {

		Log.log("Testando UoW...");		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
		

	
	@Test
	public void nestedAggregateRoots() {

		//Repositories		
		BandaREP bandaREP = new BandaREP(); 
		InstrumentoREP instrumentoREP = new InstrumentoREP(); 

		UnitOfWork uow = new UnitOfWorkImpl(bandaREP, instrumentoREP);
		
		//Entities		
		BandaEN banda = new BandaEN(1L);
		
		uow.add(banda);

		banda.addInstrumento( new InstrumentoEN() );
		banda.addInstrumento( new InstrumentoEN() );
				
		uow.commit();

		Log.log( uow.message() );
										
		Assert.assertEquals(2, instrumentoREP.getEntities().size() );
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
		


	
	@Test
	public void nestedAggregateRoots2Levels() {

		//Repositories		
		FestivalREP festivalREP = new FestivalREP(); 
		BandaREP bandaREP = new BandaREP(); 
		InstrumentoREP instrumentoREP = new InstrumentoREP();

		UnitOfWork uow = new UnitOfWorkImpl(festivalREP, bandaREP, instrumentoREP);
		
		//Entities		
		FestivalEN festival = new FestivalEN(1L);
				
		BandaEN banda = new BandaEN();
		banda = bandaREP.add(banda).getEntity();
		
		festival.addBanda(banda);
						
		uow.add(festival);
		
		banda.setState(12);
		banda.addInstrumento( new InstrumentoEN() );
		banda.addInstrumento( new InstrumentoEN() );
				
		uow.commit();
		
		Log.log( uow.message() );

		Assert.assertEquals(0, festivalREP.getEntities().size() );
		Assert.assertEquals(1, bandaREP.getEntities().size() );
		Assert.assertEquals(2, instrumentoREP.getEntities().size() );
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
