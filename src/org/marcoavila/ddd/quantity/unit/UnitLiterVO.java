package org.marcoavila.ddd.quantity.unit;

/**
 * 
 * @author Marco Avila
 */
public class UnitLiterVO implements Unit {

	public static final UnitLiterVO instance = new UnitLiterVO();
	
	private UnitLiterVO() {
		
	}

	
	
	
	
	@Override
	public String code() {

		return "l";
	}

	
	
	
	
	@Override
	public String description() {

		return "liters";
	}




	@Override
	public UnitMeasurement unitMeasurement() {
		
		return UnitMeasurement.VOLUME;
	}
	


	@Override
	public Float ratioFor(Unit otherUnit) {
		
		return null;
	}
	
	
	
	
	

}
