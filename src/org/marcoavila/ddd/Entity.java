package org.marcoavila.ddd;

/**
 * 
 * @author Marco Avila
 */
public interface Entity<ID> extends InvariantsOwner {

	public ID getId();
	
	public void setId(ID id);	
}
