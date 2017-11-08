package org.marcoavila.ddd.quantity;

public class UnitCentimeterVO implements Unit {

	
	
	
	
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
	public Float ratio(Unit otherUnit) {
		
		if (otherUnit instanceof UnitMeterVO)
			return 100f;
		
		return null;
	}
	
	
	
	
	
}
