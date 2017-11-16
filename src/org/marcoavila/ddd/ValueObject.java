package org.marcoavila.ddd;

/**
 * Abstraction that represents an Domain Value Object. 
 *
 * @author Marco Avila
 */
public interface ValueObject<T> extends InvariantsOwner {

	public boolean valueEquals(T that);
		
}
