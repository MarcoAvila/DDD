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
	public float convertTo(float amount, Unit targetUnit) {

		if (targetUnit instanceof UnitMinuteVO)
			return amount / 60f;

		if (targetUnit instanceof UnitHourVO)
			return amount / 3600f;
		
		return amount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	private UnitSecondVO() {

	}

	public static final Unit instance = new UnitSecondVO();

	private static final long serialVersionUID = 1L;
}
