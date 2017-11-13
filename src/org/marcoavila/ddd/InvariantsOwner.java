package org.marcoavila.ddd;

/**
 * 
 * @author Marco Avila
 */
public interface InvariantsOwner {
	
	public Boolean checkInvariants();	
	
	public String message();	
}
