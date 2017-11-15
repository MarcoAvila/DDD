package org.marcoavila.ddd;

public interface ValueObject extends InvariantsOwner {

	public boolean valueEquals(ValueObject that);
		
}
