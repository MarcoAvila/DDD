package org.marcoavila.ddd.quantity.unit;

/**
 * 
 * @author Marco Avila
 */
public class UnitMilliliterVO implements Unit {

	public static final UnitMilliliterVO instance = new UnitMilliliterVO();
	
	private UnitMilliliterVO() {
		
	}

	
	
	
	
	@Override
	public String code() {

		return "ml";
	}

	
	
	
	
	@Override
	public String description() {

		return "milliliters";
	}




	@Override
	public UnitMeasurement unitMeasurement() {
		
		return UnitMeasurement.VOLUME;
	}
	


	@Override
	public Float ratioFor(Unit otherUnit) {

		if (otherUnit instanceof UnitLiterVO)
			return 1f/1000;
		
		return null;
	}
	
	
	
	
	


	private static final long serialVersionUID = 1L;
}
