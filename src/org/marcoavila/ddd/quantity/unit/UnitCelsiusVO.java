package org.marcoavila.ddd.quantity.unit;

/**
 * 
 * @author Marco Avila
 */
public class UnitCelsiusVO implements Unit {

	
	
	
	
	
	@Override
	public String code() {

		return "°";
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
	public Float ratioFor(Unit otherUnit) {
		
		//if (otherUnit instanceof UnitCentimeterVO)
			//return 100f;
		
		return null;
	}
	

	
	
	private UnitCelsiusVO() {

	}

	public static final Unit instance = new UnitCelsiusVO();

	private static final long serialVersionUID = 1L;
}
