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
	public float convertTo(float amount, Unit targetUnit) {

		if (targetUnit instanceof UnitSecondVO)
			return amount * 60f;

		if (targetUnit instanceof UnitHourVO)
			return amount / 60f;
		
		return amount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private UnitMinuteVO() {

	}

	public static final Unit instance = new UnitMinuteVO();

	private static final long serialVersionUID = 1L;
}
