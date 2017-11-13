package org.marcoavila.ddd.test.unitofwork;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.marcoavila.ddd.unitofwork.UnitOfWork;
import org.marcoavila.ddd.unitofwork.UnitOfWorkImpl;
import org.marcoavila.ddd.util.Log;

public class TestUnitOfWork {

	
	
	
	
	@Before
	public void setUp() {

		Log.log("Testing UnitOfWork...");		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
		

	
	@Test
	public void nestedAggregateRoots() {

		//Repositories		
		BandREP bandREP = new BandREP(); 
		InstrumentREP instrumentoREP = new InstrumentREP(); 

		UnitOfWork uow = new UnitOfWorkImpl(bandREP, instrumentoREP);
		
		//Entities		
		BandEN band = new BandEN(1L);
		
		uow.add(band);

		band.addInstrument( new InstrumentEN() );
		band.addInstrument( new InstrumentEN() );
				
		uow.commit();

		Log.log( uow.message() );
										
		Assert.assertEquals(2, instrumentoREP.getEntities().size() );
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
		


	
	@Test
	public void nestedAggregateRoots2Levels() {

		//Repositories		
		FestivalREP festivalREP = new FestivalREP(); 
		BandREP bandREP = new BandREP(); 
		InstrumentREP instrumentREP = new InstrumentREP();

		UnitOfWork uow = new UnitOfWorkImpl(festivalREP, bandREP, instrumentREP);
		
		//Entities		
		FestivalEN festival = new FestivalEN(1L);
				
		BandEN band = new BandEN();
		band = bandREP.add(band).getEntity();
		
		festival.addBand(band);
						
		uow.add(festival);
		
		band.setState(12);
		band.addInstrument( new InstrumentEN() );
		band.addInstrument( new InstrumentEN() );
				
		uow.commit();
		
		Log.log( uow.message() );

		Assert.assertEquals(0, festivalREP.getEntities().size() );
		Assert.assertEquals(1, bandREP.getEntities().size() );
		Assert.assertEquals(2, instrumentREP.getEntities().size() );
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
