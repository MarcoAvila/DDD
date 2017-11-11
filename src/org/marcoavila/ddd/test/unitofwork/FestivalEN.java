package com.procergs.ddd.test.unitofwork;

import java.util.ArrayList;
import java.util.List;

import com.procergs.ddd.AbstractEntity;
import com.procergs.ddd.AggregateRoot;

@AggregateRoot
public class FestivalEN extends AbstractEntity<Long>{

	private List<BandaEN> bandas = new ArrayList<>();
	
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
	
	public List<BandaEN> getBandas() {
		return bandas;
	}
	
	public void addBanda(BandaEN banda) {
		bandas.add(banda);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Boolean checkInvariants() {

		return true;
	}

	
	
	
	
	
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + state;
		return result;
	}


	
	
	
	
	
	

}
