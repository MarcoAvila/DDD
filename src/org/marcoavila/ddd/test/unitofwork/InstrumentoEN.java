package com.procergs.ddd.test.unitofwork;

import java.util.ArrayList;
import java.util.List;

import com.procergs.ddd.AbstractEntity;
import com.procergs.ddd.AggregateRoot;

@AggregateRoot
public class InstrumentoEN extends AbstractEntity<Long>{

	private BandaEN banda;
	
	private int state = 0;
	
	private List<CordaEN> cordas = new ArrayList<>();

	
	
	
	
	public InstrumentoEN() {

	}

	public InstrumentoEN(Long id) {
		super(id);
	}

	public InstrumentoEN(BandaEN banda) {
		this.banda = banda;
	}
	
	
	
	
	
	
	

	
	
	
	
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public List<CordaEN> getCordas() {
		return cordas;
	}
	
	public BandaEN getBanda() {
		return banda;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Boolean checkInvariants() {

		return true;
	}

	
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cordas == null) ? 0 : cordas.hashCode());
		result = prime * result + state;
		return result;
	}





	

}
