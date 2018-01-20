package org.marcoavila.ddd.quantity;

import org.marcoavila.ddd.AbstractValueObject;
import org.marcoavila.ddd.quantity.unit.Unit;

/**
 * 
 * @author Marco Avila
 */

public class QuantityVO extends AbstractValueObject<QuantityVO> {

	private final float amount;
	
	protected final Unit unit;

	public QuantityVO(float amount, Unit unit) {
		this.amount = amount;
		this.unit = unit;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	public boolean equalsQuantity(QuantityVO otherHeight) {
		
		QuantityVO otherSameUnit = otherHeight.convertTo( unit );
		
		return Float.floatToIntBits( getAmount() ) == Float.floatToIntBits( otherSameUnit.getAmount() );
	}
	
	
	
	
	
	
	
	
	
	public boolean greaterThan(QuantityVO otherHeight) {
		
		QuantityVO otherSameUnit = otherHeight.convertTo( unit );
				
		return this.getAmount() > otherSameUnit.getAmount();
	}
	
	

	
	
	
	
	
	public boolean lesserThan(QuantityVO otherHeight) {

		QuantityVO otherSameUnit = otherHeight.convertTo( unit );
				
		return this.getAmount() < otherSameUnit.getAmount();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public QuantityVO convertTo(Unit targetUnit) {
		
		if (unit.unitMeasurement() == targetUnit.unitMeasurement() &&
			unit.code().equals( targetUnit.code() ))
			return this;
		
		if (!unit.unitMeasurement().equals( targetUnit.unitMeasurement()))
			throw new IllegalArgumentException("Attempt to convert to an incompatible unit! From " +
												unit.description() + " to " + targetUnit.description());
		
		float ratio = unit.ratioFor(targetUnit);
		
		return new QuantityVO(amount * ratio, targetUnit);
	}
	
	
	
	
	
	
	
	
	
	
	
	public final String display() {
				
		String amountString = ( (double)amount == Math.floor( (double)amount) ?
				String.valueOf( (int)amount) : 
				String.valueOf(  amount) );
		
		return amountString + unit.code();
	}





	public final float getAmount() {
		return amount;
	}


	public final int getAmountInt() {
		return Float.valueOf(amount).intValue();
	}



	
	
	
	

	@Override
	public boolean valueEquals(QuantityVO other) {
		
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
	}







	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		return result;
	}



	
	
	
	
	
	

	@Override
	public String toString() {
		
		return display();
	}






	private static final long serialVersionUID = 1L;
	
}
