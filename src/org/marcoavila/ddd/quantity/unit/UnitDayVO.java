package org.marcoavila.ddd.quantity.unit;

/**
 * 
 * @author Marco Avila
 */
public class UnitDayVO implements Unit { 

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
	public float convertTo(float amount, Unit targetUnit) {

		if (targetUnit instanceof UnitWeekVO)
			return amount / 7f;
		
		return amount;
	}
	
	
	
	
	
	
	
	
	
	private UnitDayVO() {

	}

	public static final Unit instance = new UnitDayVO();

	private static final long serialVersionUID = 1L;
}
