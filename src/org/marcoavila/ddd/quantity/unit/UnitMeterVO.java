package org.marcoavila.ddd.quantity.unit;

/**
 * 
 * @author Marco Avila
 */
public class UnitMeterVO implements Unit {

	
	
	
	
	
	@Override
	public String code() {

		return "m";
	}

	
	
	
	
	
	@Override
	public String description() {

		return "meters";
	}

	


	@Override
	public UnitMeasurement unitMeasurement() {
		
		return UnitMeasurement.DISTANCE;
	}
	
		
	

	@Override
	public float convertTo(float amount, Unit targetUnit) {

		if (targetUnit instanceof UnitCentimeterVO)
			return amount * 100f;
		
		return amount;
	}
	
	
	
	
	
	
	
	
	

	
	
	private UnitMeterVO() {

	}

	public static final Unit instance = new UnitMeterVO();

	private static final long serialVersionUID = 1L;
}
