package org.marcoavila.ddd;

/**
 * 
 * @author Marco Avila
 */

public abstract class AbstractInvariantsOwner implements InvariantsOwner {

	protected String message;

	
	
	
	
	
	
	

	

	
	@Override
	public final String invariantsMessage() {
		
		return message;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	protected final boolean invariantsError(String message) {
		
		final String title = "INVARIANTS ERROR: ";
		
		this.message = (message.contains(title) ? "" : title + invariantsHeader() )  + 
						message;
		
		return false;
	}


	
	
	
	

	
	
	
	
	
	
	
	
	

	protected String invariantsHeader() {
		
		return this.getClass().getSimpleName() + ": ";
	}
	
	
	
	
	
	
	
	
}
