package org.marcoavila.ddd.quantity.unit;

/**
 * 
 * @author Marco Avila
 */
public class UnitCelsiusVO implements Unit {

	
	
	
	
	
	@Override
	public String code() {

		return "°C";
	}

	
	
	
	
	
	@Override
	public String description() {

		return "Celsius";
	}

	

	

	@Override
	public UnitMeasurement unitMeasurement() {
		
		return UnitMeasurement.TEMPERATURE;
	}
	
	
	
	
	

	
	@Override
	public float convertTo(float amount, Unit targetUnit) {

		if (targetUnit instanceof UnitFahrenheitVO)
			return amount * (9f / 5f) + 32f;
		
		return amount;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	private UnitCelsiusVO() {

	}

	public static final Unit instance = new UnitCelsiusVO();

	private static final long serialVersionUID = 1L;
}
