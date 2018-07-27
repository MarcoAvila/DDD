package org.marcoavila.ddd.quantity.unit;

/**
 * 
 * @author Marco Avila
 */
public class UnitGallonUkVO implements Unit {

	public static final UnitGallonUkVO instance = new UnitGallonUkVO();
	
	private UnitGallonUkVO() {
		
	}

	
	
	
	
	@Override
	public String code() {

		return "gal";
	}

	
	
	
	
	@Override
	public String description() {

		return "gallon (UK)";
	}




	@Override
	public UnitMeasurement unitMeasurement() {
		
		return UnitMeasurement.VOLUME;
	}
	

	
	
	
	
	
	
	

	
	
	/*
	The Imperial gallon or UK gallon is used in the United Kingdom 
	and is equal to approximately 277.42 cubic inches. 
	Its exact value is defined as 4.54609 liters. 
	One imperial gallon is approximately 1.2 US gallons.
	 */
		
	@Override
	public float convertTo(float amount, Unit targetUnit) {

		if (targetUnit instanceof UnitLiterVO)
			return amount * 4.54609f;

		if (targetUnit instanceof UnitGallonUsVO)
			return amount * 1.2f;
		
		return amount;
	}
	
	
	
	
	
	


	private static final long serialVersionUID = 1L;
}
