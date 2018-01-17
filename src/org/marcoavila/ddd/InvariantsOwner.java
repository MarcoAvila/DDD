package org.marcoavila.ddd;

import java.io.Serializable;

/**
 * Abstraction that represents invariants checking capability. 
 *
 * @author Marco Avila
 */
public interface InvariantsOwner extends Serializable {
	
	public Boolean checkInvariants();	
	
	public String message();	
}
