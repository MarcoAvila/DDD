package com.procergs.ddd.test.unitofwork;

import java.util.ArrayList;
import java.util.List;

import com.procergs.ddd.AbstractEntity;
import com.procergs.ddd.AggregateRoot;

@AggregateRoot
public class BandaEN extends AbstractEntity<Long>{

	private int state = 0;
		
	private List<InstrumentoEN> instrumentos = new ArrayList<>();
	

	public BandaEN() {

	}

	public BandaEN(Long id) {
		super(id);
	}

	
	
	
	
	
	
	
	

	
	
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public List<InstrumentoEN> getInstrumentos() {
		return instrumentos;
	}

	public void addInstrumento(InstrumentoEN instrumento) {
		instrumentos.add(instrumento);
	}

	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Boolean checkInvariants() {

		return true;
	}
	
	
	




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + state;
		return result;
	}

	
	
	
	

}
