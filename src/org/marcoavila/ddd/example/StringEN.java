package org.marcoavila.ddd.example;

import org.marcoavila.ddd.AbstractEntity;

/**
 * 
 * @author Marco Avila
 */
public class StringEN extends AbstractEntity<Long> {

	private int position;
	
	private StringStageVO stage;
	
	
	
	
	

	public StringEN(int position) {
		this.position = position;
		this.stage = StringStageVO.NEW;
	}

	public StringEN(int position, StringStageVO stage) {
		this.position = position;
		this.stage = stage;
	}


	
	
	

	
	public void startUsing() {
		
		stage = StringStageVO.IN_USE;
	}
	
	
	
	
	
	
	
	
	public boolean inUse() {
		
		return stage == StringStageVO.IN_USE;
	}
	
	

	
	
	
	public void replaced() {
		
		stage = StringStageVO.REPLACED;
	}
	
	
	
	
	
	


	public int getPosition() {
		return position;
	}



	public StringStageVO getStage() {
		return stage;
	}


	
	
	






	@Override
	public Boolean checkInvariants() {

		if (position < 1 ||
			position > 12)
			return invariantsError("String position must be betwenn 1 and 12!");

		if (stage == null)
			return invariantsError("String requires stage!");
		
		return true;
	}

	
	

	private static final long serialVersionUID = 1L;
	
}
