package org.marcoavila.ddd.test.unitofwork;

import org.marcoavila.ddd.AbstractEntity;

public class StringEN extends AbstractEntity<Long>{

	private int state = 0;
		
		
	
	
	public StringEN(Long id) {
		super(id);
	}

	
	
	
	
	
	

	
	
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
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
