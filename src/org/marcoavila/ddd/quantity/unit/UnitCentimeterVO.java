package org.marcoavila.ddd.quantity.unit;

/**
 * 
 * @author Marco Avila
 */
public class UnitCentimeterVO implements Unit {

	public static final UnitCentimeterVO instance = new UnitCentimeterVO();
	
	private UnitCentimeterVO() {
		
	}

	
	
	
	
	@Override
	public String code() {

		return "cm";
	}

	
	
	
	
	@Override
	public String description() {

		return "centimeters";
	}

	
	
	
	
	
	

	@Override
	public UnitMeasurement unitMeasurement() {
		
		return UnitMeasurement.DISTANCE;
	}
	
	
	
	

	@Override
	public Float ratioFor(Unit otherUnit) {
		
		if (otherUnit instanceof UnitMeterVO)
			return 0.01f;
		
		return null;
	}
	
	
	
	
	
}
