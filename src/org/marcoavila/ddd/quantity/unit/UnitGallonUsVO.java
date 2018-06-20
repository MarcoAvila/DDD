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
	

	
	@Override
	public float convertTo(float amount, Unit targetUnit) {

		//if (targetUnit instanceof UnitMilliliterVO)
			//return amount * 1000f;
		
		return amount;
	}
	
	
	
	
	
	


	private static final long serialVersionUID = 1L;
}
