package org.marcoavila.ddd.quantity;

public class UnitHourVO implements Unit{

	@Override
	public String code() {

		return "h";
	}

	@Override
	public String description() {

		return "hours";
	}


	@Override
	public UnitMeasurement unitMeasurement() {
		
		return UnitMeasurement.TIME;
	}
	
	@Override
	public Float ratio(Unit otherUnit) {

		return null;
	}

}
