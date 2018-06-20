package org.marcoavila.ddd.quantity.unit;

/**
 * 
 * @author Marco Avila
 */
public class UnitLiterVO implements Unit {

	public static final UnitLiterVO instance = new UnitLiterVO();
	
	private UnitLiterVO() {
		
	}

	
	
	
	
	@Override
	public String code() {

		return "L";
	}

	
	
	
	
	@Override
	public String description() {

		return "liters";
	}




	@Override
	public UnitMeasurement unitMeasurement() {
		
		return UnitMeasurement.VOLUME;
	}
	

	
	@Override
	public float convertTo(float amount, Unit targetUnit) {

		if (targetUnit instanceof UnitMilliliterVO)
			return amount * 1000f;
		
		return amount;
	}
	
	
	
	
	
	


	private static final long serialVersionUID = 1L;
}
