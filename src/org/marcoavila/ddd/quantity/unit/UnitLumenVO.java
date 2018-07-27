package org.marcoavila.ddd.quantity.unit;

/**
 * 
 * @author Marco Avila
 */
public class UnitLumenVO implements Unit {

	public static final UnitLumenVO instance = new UnitLumenVO();
	
	private UnitLumenVO() {
		
	}

	
	
	
	
	@Override
	public String code() {

		return "lm";
	}

	
	
	
	
	@Override
	public String description() {

		return "lumens";
	}




	@Override
	public UnitMeasurement unitMeasurement() {
		
		return UnitMeasurement.LUMINOUS_FLUX;
	}
	

	
	@Override
	public float convertTo(float amount, Unit targetUnit) {

		//if (targetUnit instanceof UnitMilliliterVO)
			//return amount * 1000f;
		
		throw new IllegalStateException("Not implemented!");
	}
	
	
	
	
	
	


	private static final long serialVersionUID = 1L;
}
