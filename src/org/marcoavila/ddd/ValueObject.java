package org.marcoavila.ddd;

/**
 * Abstraction that represents an Domain Value Object. 
 *
 * @author Marco Avila
 */
public interface ValueObject<VO> extends InvariantsOwner {

	public boolean valueEquals(VO that);
		
}
