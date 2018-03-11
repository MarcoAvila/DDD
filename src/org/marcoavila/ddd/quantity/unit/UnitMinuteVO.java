package org.marcoavila.ddd.quantity.unit;

/**
 * 
 * @author Marco Avila
 */
public class UnitMinuteVO implements Unit {
	
	@Override
	public String code() {

		return "m";
	}

	
	
	
	@Override
	public String description() {

		return "minutes";
	}



	@Override
	public UnitMeasurement unitMeasurement() {
		
		return UnitMeasurement.TIME;
	}
	
	
	
	@Override
	public Float ratioFor(Unit otherUnit) {

		if (otherUnit instanceof UnitSecondVO)
			return 60f;

		if (otherUnit instanceof UnitHourVO)
			return 1f / 60;
		
		return null;
	}

	
	private UnitMinuteVO() {

	}

	public static final Unit instance = new UnitMinuteVO();

	private static final long serialVersionUID = 1L;
}
