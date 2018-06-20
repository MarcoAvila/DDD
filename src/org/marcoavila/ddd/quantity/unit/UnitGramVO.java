package org.marcoavila.ddd.quantity.unit;

public class UnitGramVO implements Unit {

	public static final UnitGramVO instance = new UnitGramVO();
	
	
	
	
	private UnitGramVO() {
		
	}





	@Override
	public String code() {

		return "g";
	}

	
	
	
	
	@Override
	public String description() {

		return "grams";
	}

	
	
	
	
	
	

	@Override
	public UnitMeasurement unitMeasurement() {
		
		return UnitMeasurement.WEIGHT;
	}
	
	
	
		
	

	
	@Override
	public float convertTo(float amount, Unit targetUnit) {

		if (targetUnit instanceof UnitKilogramVO)
			return amount / 100f;
		
		return amount;
	}
	
	
	
	
	
	


	private static final long serialVersionUID = 1L;
}
