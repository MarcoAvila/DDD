package org.marcoavila.ddd.quantity.unit;

/**
 * 
 * @author Marco Avila
 */
public class UnitCentimeterVO implements Unit {

	public static final UnitCentimeterVO instance = new UnitCentimeterVO();
	
	private UnitCentimeterVO() {
		
	}

	
	
	
	
	@Override
	public String code() {

		return "cm";
	}

	
	
	
	
	@Override
	public String description() {

		return "centimeters";
	}

	
	
	
	
	
	

	@Override
	public UnitMeasurement unitMeasurement() {
		
		return UnitMeasurement.DISTANCE;
	}
	
	
	
	
	
	

	
	@Override
	public float convertTo(float amount, Unit targetUnit) {

		if (targetUnit instanceof UnitMeterVO)
			return amount / 100f;
		
		return amount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	private static final long serialVersionUID = 1L;
}
