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

		if (otherUnit instanceof UnitMinuteVO)
			return 60f;

		if (otherUnit instanceof UnitSecondVO)
			return 3600f;
		
		return null;
	}


	private static final long serialVersionUID = 1L;
}
