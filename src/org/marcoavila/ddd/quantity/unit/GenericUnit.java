package org.marcoavila.ddd.quantity.unit;

public class GenericUnit implements Unit {

	private final String code;

	private final String description;
	
	private final UnitMeasurement unitMeasurement;
	
	//private Map<Unit, Float> ratioMap;
	
	
	public GenericUnit(String code, String description, UnitMeasurement unitMeasurement) {
		this.code = code;
		this.description = description;
		this.unitMeasurement = unitMeasurement;
		//this.ratioMap = new HashMap<>();
	}


	
	
	
	
	
	
	/*
	public void addConversionRatio(Unit unit, Float ratio) {
		
		ratioMap.put(unit, ratio);
	}
	*/
	
	
	
	




	@Override
	public String code() {

		return code;
	}
	
	
	
	
	

	@Override
	public String description() {

		return description;
	}

	
	
	
	
	
	@Override
	public UnitMeasurement unitMeasurement() {

		return unitMeasurement;
	}

	
	
	
	
	
	@Override
	public float convertTo(float amount, Unit targetUnit) {
		
		return amount;
	}
	
	
	
	
	
	


	private static final long serialVersionUID = 1L;
}
