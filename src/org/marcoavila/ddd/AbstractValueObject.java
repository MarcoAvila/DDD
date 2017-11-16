package org.marcoavila.ddd;

/**
 * Abstraction that represents a Domain Value Object. 
 * 
 * Enforces the equality verification. 
 *
 * @author Marco Avila
 */
public abstract class AbstractValueObject<VO> extends AbstractInvariantsOwner implements ValueObject<VO> {

	private static final long serialVersionUID = 1L;



	
	
	

	@Override
	public Boolean checkInvariants() {
		throw new IllegalStateException("checkInvariants() NOT IMPLEMENTED on this Value Object!");		
	}


	
	

	
	

	@Override
	@SuppressWarnings("unchecked")
	public final boolean equals(Object obj) {
		if (obj == null ||
		   !obj.getClass().equals(this.getClass()))
			return false;
		return valueEquals( (VO)obj );
	}
	
	
	
		
	
	
}
