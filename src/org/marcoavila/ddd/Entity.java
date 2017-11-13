package org.marcoavila.ddd;

/**
 * Abstraction that represents an Domain Entity. 
 *
 * @author Marco Avila
 */
public interface Entity<ID> extends InvariantsOwner {

	public ID getId();
	
	public void setId(ID id);	
}
