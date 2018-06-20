package org.marcoavila.ddd.quantity.unit;

/**
 * 
 * @author Marco Avila
 */
public class UnitMilliliterVO implements Unit {

	public static final UnitMilliliterVO instance = new UnitMilliliterVO();
	
	private UnitMilliliterVO() {
		
	}

	
	
	
	
	@Override
	public String code() {

		return "ml";
	}

	
	
	
	
	@Override
	public String description() {

		return "milliliters";
	}




	@Override
	public UnitMeasurement unitMeasurement() {
		
		return UnitMeasurement.VOLUME;
	}
	


	@Override
	public float convertTo(float amount, Unit targetUnit) {

		if (targetUnit instanceof UnitLiterVO)
			return amount / 1000f;
		
		return amount;
	}
	
	
	
	
	
	


	private static final long serialVersionUID = 1L;
}
