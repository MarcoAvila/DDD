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

		return "L";
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

		if (otherUnit instanceof UnitMilliliterVO)
			return 1000f;
		
		return null;
	}
	
	
	
	
	


	private static final long serialVersionUID = 1L;
}
