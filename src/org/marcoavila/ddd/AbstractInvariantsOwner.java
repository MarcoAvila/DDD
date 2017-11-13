package org.marcoavila.ddd;

/**
 * Base class for invariants owner implementation, holds the message.
 *
 * @author Marco Avila
 */

public abstract class AbstractInvariantsOwner implements InvariantsOwner {

	protected String message;

	
	
	
	
	
	
	

	

	
	@Override
	public final String message() {
		
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
