package org.marcoavila.ddd;

/**
 * Base class for Value Object implementation, makes the equals implementation mandatory,
 * but not invariants checking.
 *
 * @author Marco Avila
 */
public abstract class AbstractValueObject<VO> extends AbstractInvariantsOwner implements ValueObject<VO> {

	private static final long serialVersionUID = 1L;



	
	
	

	@Override
	public Boolean checkInvariants() {
		return true;	
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
