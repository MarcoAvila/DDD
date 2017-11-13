package org.marcoavila.ddd.quantity;

/**
 * 
 * @author Marco Avila
 */
public class UnitLiterVO implements Unit {

	
	
	
	
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
	public Float ratio(Unit otherUnit) {
		
		return null;
	}
	
	
	
	
	

}
