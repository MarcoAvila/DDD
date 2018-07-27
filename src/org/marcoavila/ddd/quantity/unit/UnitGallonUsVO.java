package org.marcoavila.ddd.quantity.unit;

/**
 * 
 * @author Marco Avila
 */
public class UnitGallonUsVO implements Unit {

	public static final UnitGallonUsVO instance = new UnitGallonUsVO();
	
	private UnitGallonUsVO() {
		
	}

	
	
	
	
	@Override
	public String code() {

		return "gal";
	}

	
	
	
	
	@Override
	public String description() {

		return "gallon (US)";
	}




	@Override
	public UnitMeasurement unitMeasurement() {
		
		return UnitMeasurement.VOLUME;
	}
	

	
	
	
	
	
	
	
	
	
	
	/*
	The US gallon is used in the United States and is equal to 
	exactly 231 cubic inches or 3.785411784 liters.
	 */
	
	@Override
	public float convertTo(float amount, Unit targetUnit) {

		if (targetUnit instanceof UnitLiterVO)
			return amount * 3.785411784f;

		if (targetUnit instanceof UnitGallonUkVO)
			return amount / 1.2f;
		
		return amount;
	}
	
	
	
	
	
	


	private static final long serialVersionUID = 1L;
}
