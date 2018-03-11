package org.marcoavila.ddd.quantity.unit;

/**
 * 
 * @author Marco Avila
 */
public class UnitSecondVO implements Unit {

	
	
	
	
	@Override
	public String code() {

		return "s";
	}

	
	
	
	@Override
	public String description() {

		return "seconds";
	}



	@Override
	public UnitMeasurement unitMeasurement() {
		
		return UnitMeasurement.TIME;
	}
	
	
	
	@Override
	public Float ratioFor(Unit otherUnit) {

		if (otherUnit instanceof UnitMinuteVO)
			return 1f / 60;

		if (otherUnit instanceof UnitHourVO)
			return 1f / 3600;
		
		return null;
	}

	
	private UnitSecondVO() {

	}

	public static final Unit instance = new UnitSecondVO();

	private static final long serialVersionUID = 1L;
}
