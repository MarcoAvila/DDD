package org.marcoavila.ddd.quantity;

/**
 * 
 * @author Marco Avila
 */
public class UnitMinuteVO implements Unit {

	
	
	
	
	@Override
	public String code() {

		return "m";
	}

	
	
	
	@Override
	public String description() {

		return "minutes";
	}



	@Override
	public UnitMeasurement unitMeasurement() {
		
		return UnitMeasurement.TIME;
	}
	
	
	
	@Override
	public Float ratio(Unit otherUnit) {
		// TODO Auto-generated method stub
		return null;
	}

}
