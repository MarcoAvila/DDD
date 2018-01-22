package org.marcoavila.ddd;

/**
 * Base class for invariants owner implementation, holds the message.
 *
 * @author Marco Avila
 */

public abstract class AbstractInvariantsOwner implements InvariantsOwner {

	protected String message;

	private String invariantsMessage;
	
	
	
	
	
	
	

	

	
	@Override
	public final String message() {
		
		return message;
	}
	
	
	
	
	
	

	

	public String invariantsMessage() {
		
		return invariantsMessage;
	}
	
	
	
	

	
	protected final boolean invariantsError(String message) {
		
		this.message = message;
		
		final String title = "INVARIANTS ERROR: ";
		
		this.invariantsMessage = (message.contains(title) ? "" : title + invariantsHeader() ) + 
						          message;
		
		return false;
	}

	
	
	

	
	
	
	
	
	
	
	
	

	protected String invariantsHeader() {
		
		return this.getClass().getSimpleName() + ": ";
	}
	
	
	
	
	
	
	

	private static final long serialVersionUID = 1L;
	
}
