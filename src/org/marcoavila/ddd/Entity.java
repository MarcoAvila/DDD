package org.marcoavila.ddd;

/**
 * 
 * @author marco-souza
 */
public interface Entity<ID> extends InvariantsOwner {

	public ID getId();
	
	public void setId(ID id);	
}
