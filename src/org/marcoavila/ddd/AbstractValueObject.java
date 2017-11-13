package org.marcoavila.ddd;

/**
 * Abstraction that represents a Domain Value Object. 
 * 
 * Enforces the equality verification. 
 *
 * @author Marco Avila
 */
public abstract class AbstractValueObject extends AbstractInvariantsOwner {

	private static final long serialVersionUID = 1L;



	
	
	

	@Override
	public Boolean checkInvariants() {
		throw new IllegalStateException("checkInvariants() NOT IMPLEMENTED on this value object!");		
	}


	
	

	
	

	@Override
	public boolean equals(Object obj) {
		if (obj == null ||
			(!obj.getClass().equals(this.getClass())) ||
			!(obj instanceof AbstractValueObject))
			return false;
		return valueEquals( (AbstractValueObject)obj );
	}
	
	
	
	
	
	
	protected abstract boolean valueEquals(AbstractValueObject that);
	
	
	
	
}
