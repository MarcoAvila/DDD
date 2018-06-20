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
	public float convertTo(float amount, Unit targetUnit) {

		if (targetUnit instanceof UnitDayVO)
			return amount * 7f;
		
		return amount;
	}
	
	
	
	
	
	
	
	
	
	
	
	private UnitWeekVO() {

	}

	public static final Unit instance = new UnitWeekVO();

	private static final long serialVersionUID = 1L;
	
}
