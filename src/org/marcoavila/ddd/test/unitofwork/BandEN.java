package org.marcoavila.ddd.test.unitofwork;

import java.util.ArrayList;
import java.util.List;

import org.marcoavila.ddd.AbstractEntity;
import org.marcoavila.ddd.AggregateRoot;

@AggregateRoot
public class BandEN extends AbstractEntity<Long>{

	private int state = 0;
		
	private List<InstrumentEN> instruments = new ArrayList<>();
	

	public BandEN() {

	}

	public BandEN(Long id) {
		super(id);
	}

	
	
	
	
	
	
	
	

	
	
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	

	
	
	
	
	public void addInstrument(InstrumentEN instrumentEN) {
		instruments.add(instrumentEN);
	}
	
	public List<InstrumentEN> getInstruments() {
		return instruments;
	}

	public void setInstruments(List<InstrumentEN> instruments) {
		this.instruments = instruments;
	}

	
	
	
	
	
	
	
	
	
	
	@Override
	public Boolean checkInvariants() {

		return true;
	}

	
	
	
	
	
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((instruments == null) ? 0 : instruments.hashCode());
		result = prime * result + state;
		return result;
	}

	



	
	
	
	

}
