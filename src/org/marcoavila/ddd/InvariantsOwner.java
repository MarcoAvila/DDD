package org.marcoavila.ddd;

/**
 * 
 * @author marco-souza
 */
public interface InvariantsOwner {
	
	public Boolean checkInvariants();	
	
	public String invariantsMessage();	
}
