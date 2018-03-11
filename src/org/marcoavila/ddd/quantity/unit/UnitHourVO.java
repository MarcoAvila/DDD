package org.marcoavila.ddd.quantity.unit;

/**
 * 
 * @author Marco Avila
 */
public class UnitHourVO implements Unit {

	public static final UnitHourVO instance = new UnitHourVO();
	
	public UnitHourVO() {

	}

	
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
	public Float ratioFor(Unit otherUnit) {

		return null;
	}

}
