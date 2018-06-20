package org.marcoavila.ddd.quantity.unit;

/**
 * 
 * @author Marco Avila
 */
public class UnitPercentageVO implements Unit {

	
	
	
	
	
	@Override
	public String code() {

		return "%";
	}

	
	
	
	
	
	@Override
	public String description() {

		return "per cent";
	}

	


	@Override
	public UnitMeasurement unitMeasurement() {
		
		return UnitMeasurement.PERCENTAGE;
	}
	
	


	@Override
	public float convertTo(float amount, Unit targetUnit) {

		return amount;
	}
	
	
	
	

	
	
	private UnitPercentageVO() {

	}

	public static final Unit instance = new UnitPercentageVO();

	private static final long serialVersionUID = 1L;
}
