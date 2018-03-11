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
	public Float ratioFor(Unit otherUnit) {
		
		if (otherUnit instanceof UnitGramVO)
			return 100f;
		
		return null;
	}
	
	
	
	


	private static final long serialVersionUID = 1L;
}
