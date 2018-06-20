package org.marcoavila.ddd.quantity.unit;

/**
 * 
 * @author Marco Avila
 */
public class UnitFahrenheitVO implements Unit {

	
	
	
	
	
	@Override
	public String code() {

		return "°F";
	}

	
	
	
	
	
	@Override
	public String description() {

		return "Fahrenheit";
	}

	


	@Override
	public UnitMeasurement unitMeasurement() {
		
		return UnitMeasurement.TEMPERATURE;
	}
	
	


	@Override
	public float convertTo(float amount, Unit targetUnit) {

		if (targetUnit instanceof UnitCelsiusVO)
			return (amount - 32f) / (9f / 5f);
		
		return amount;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	private UnitFahrenheitVO() {

	}

	public static final Unit instance = new UnitFahrenheitVO();

	private static final long serialVersionUID = 1L;
}
