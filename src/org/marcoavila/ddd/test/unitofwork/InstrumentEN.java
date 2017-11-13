package org.marcoavila.ddd.test.unitofwork;

import java.util.ArrayList;
import java.util.List;

import org.marcoavila.ddd.AbstractEntity;
import org.marcoavila.ddd.AggregateRoot;

@AggregateRoot
public class InstrumentEN extends AbstractEntity<Long>{

	private BandEN band;
	
	private int state = 0;
	
	private List<StringEN> strings = new ArrayList<>();

	
	
	
	
	public InstrumentEN() {

	}

	public InstrumentEN(Long id) {
		super(id);
	}
		
	public InstrumentEN(BandEN band) {
		this.band = band;
	}

	
	
	
	
	
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
	
	
	
	
	
	
	
	
	
	public BandEN getBand() {
		return band;
	}

	public List<StringEN> getStrings() {
		return strings;
	}

	@Override
	public Boolean checkInvariants() {

		return true;
	}

	
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((band == null) ? 0 : band.hashCode());
		result = prime * result + state;
		result = prime * result + ((strings == null) ? 0 : strings.hashCode());
		return result;
	}

	
	
	


	

}
