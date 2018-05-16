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
	public Float ratioFor(Unit otherUnit) {
		
		//if (otherUnit instanceof UnitCentimeterVO)
			//return 100f;
		
		return null;
	}
	

	
	
	private UnitPercentageVO() {

	}

	public static final Unit instance = new UnitPercentageVO();

	private static final long serialVersionUID = 1L;
}
