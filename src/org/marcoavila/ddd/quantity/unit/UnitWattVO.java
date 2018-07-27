package org.marcoavila.ddd.quantity.unit;

/**
 * 
 * @author Marco Avila
 */
public class UnitWattVO implements Unit {

	public static final UnitWattVO instance = new UnitWattVO();
	
	private UnitWattVO() {
		
	}

	
	
	
	
	@Override
	public String code() {

		return "W";
	}

	
	
	
	
	@Override
	public String description() {

		return "watt";
	}




	@Override
	public UnitMeasurement unitMeasurement() {
		
		return UnitMeasurement.POWER;
	}
	

	
	@Override
	public float convertTo(float amount, Unit targetUnit) {

		//if (targetUnit instanceof UnitMilliliterVO)
			//return amount * 1000f;
		
		throw new IllegalStateException("Not implemented!");
	}
	
	
	
	
	
	


	private static final long serialVersionUID = 1L;
}
