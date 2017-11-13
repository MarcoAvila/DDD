package org.marcoavila.ddd.quantity;

/**
 * 
 * @author Marco Avila
 */
public class UnitDayVO implements Unit{ 

	@Override
	public String code() {
		return "d";
	}

	@Override
	public String description() {
		return "days";
	}


	@Override
	public UnitMeasurement unitMeasurement() {		
		return UnitMeasurement.TIME;
	}
	
	@Override
	public Float ratio(Unit otherUnit) {
		if (otherUnit instanceof UnitWeekVO)
			return 1f/7;
		return null;
	}

	
	
	
	private UnitDayVO() {

	}

	public static final Unit instance = new UnitDayVO();
	
	
	
}
