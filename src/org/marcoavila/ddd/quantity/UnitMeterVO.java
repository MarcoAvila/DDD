package org.marcoavila.ddd.quantity;

public class UnitMeterVO implements Unit {

	
	
	
	
	
	@Override
	public String code() {

		return "m";
	}

	
	
	
	
	
	@Override
	public String description() {

		return "meters";
	}

	


	@Override
	public UnitMeasurement unitMeasurement() {
		
		return UnitMeasurement.DISTANCE;
	}
	
	

	@Override
	public Float ratio(Unit otherUnit) {
		
		if (otherUnit instanceof UnitCentimeterVO)
			return 0.01f;
		
		return null;
	}
	

	
	
	private UnitMeterVO() {

	}

	public static final Unit instance = new UnitMeterVO();
	
}
