package org.marcoavila.ddd.quantity.unit;

public class UnitKilogramVO implements Unit {

	public static final UnitKilogramVO instance = new UnitKilogramVO();
	
	
	
	
	private UnitKilogramVO() {
		
	}





	@Override
	public String code() {

		return "kg";
	}

	
	
	
	
	@Override
	public String description() {

		return "kilograms";
	}

	
	
	
	
	
	

	@Override
	public UnitMeasurement unitMeasurement() {
		
		return UnitMeasurement.WEIGHT;
	}
	
	
		


	
	@Override
	public float convertTo(float amount, Unit targetUnit) {

		if (targetUnit instanceof UnitGramVO)
			return amount * 100f;
		
		return amount;
	}
	
	
	
	
	
	
	
	


	private static final long serialVersionUID = 1L;
}
