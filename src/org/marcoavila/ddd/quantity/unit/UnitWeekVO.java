package org.marcoavila.ddd.quantity.unit;

/**
 * 
 * @author Marco Avila
 */
public class UnitWeekVO implements Unit{

	@Override
	public String code() {
		return "week";
	}

	@Override
	public String description() {
		return "weeks";
	}


	@Override
	public UnitMeasurement unitMeasurement() {		
		return UnitMeasurement.TIME;
	}
	
	@Override
	public Float ratioFor(Unit otherUnit) {
		if (otherUnit instanceof UnitDayVO)
			return 7f;
		return null;
	}

	
	private UnitWeekVO() {

	}

	public static final Unit instance = new UnitWeekVO();

	private static final long serialVersionUID = 1L;
	
}
