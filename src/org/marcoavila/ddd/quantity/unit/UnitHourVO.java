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
	public float convertTo(float amount, Unit targetUnit) {

		if (targetUnit instanceof UnitMinuteVO)
			return amount * 60f;

		if (targetUnit instanceof UnitSecondVO)
			return amount * 3600f;
		
		return amount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private static final long serialVersionUID = 1L;
}
