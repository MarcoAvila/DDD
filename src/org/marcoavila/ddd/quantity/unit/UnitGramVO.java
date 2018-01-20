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
	public Float ratioFor(Unit otherUnit) {
		
		if (otherUnit instanceof UnitKilogramVO)
			return 1f / 100;
		
		return null;
	}
	
	
	
	
	
}
