package org.marcoavila.ddd.quantity;

import org.marcoavila.ddd.util.Log;


public final class QuantityVO {

	private final float amount;
	
	private final Unit unit;

	public QuantityVO(float amount, Unit unit) {
		this.amount = amount;
		this.unit = unit;
	}

	
	
	
	
	
	
	
	
	
	public QuantityVO convertTo(Unit targetUnit) {
		
		if (!unit.unitMeasurement().equals( targetUnit.unitMeasurement()))
			throw new IllegalArgumentException("Attempt to convert to an incompatible unit! From " +
												unit.description() + " to " + targetUnit.description());
		
		float ratio = unit.ratio(targetUnit);
		
		return new QuantityVO(amount *  ratio, targetUnit);
	}
	
	
	
	
	
	
	
	
	
	
	
	public String display() {
		return amount + " " + unit.code();
	}





	public float getAmount() {
		return amount;
	}


	public int getAmountInt() {
		return Float.valueOf(amount).intValue();
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuantityVO other = (QuantityVO) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
	}


	
	
	
/*
	public static void main(String[] a) {

		QuantityVO days = new QuantityVO( 6, UnitDayVO.instance);		
		QuantityVO weeks = days.convertTo( UnitMeterVO.instance );
		
		Log.print( weeks.getAmountInt() );
	}
*/
	
	
}
