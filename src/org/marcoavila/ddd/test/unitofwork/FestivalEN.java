package org.marcoavila.ddd.test.unitofwork;

import java.util.ArrayList;
import java.util.List;

import org.marcoavila.ddd.AbstractEntity;
import org.marcoavila.ddd.AggregateRoot;

@AggregateRoot
public class FestivalEN extends AbstractEntity<Long>{

	private List<BandEN> bands = new ArrayList<>();
	
	private int state = 0;
	
	
	
	
	
	public FestivalEN() {

	}

	public FestivalEN(Long id) {
		setId(id);
	}

	
	
	
	
	
	

	
	
	
	
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
	
	
	
	
	
	
	
	

	public void addBand(BandEN band) {
		bands.add(band);		
	}
	
	public List<BandEN> getBands() {
		return bands;
	}

	public void setBands(List<BandEN> bands) {
		this.bands = bands;
	}

	
	
	
	
	
	
	
	
	
	
	@Override
	public Boolean checkInvariants() {

		return true;
	}
	
	
	
	
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bands == null) ? 0 : bands.hashCode());
		result = prime * result + state;
		return result;
	}

	

}
