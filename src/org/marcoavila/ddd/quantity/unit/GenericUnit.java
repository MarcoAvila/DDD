package org.marcoavila.ddd.quantity.unit;

import java.util.HashMap;
import java.util.Map;

public class GenericUnit implements Unit {

	private final String code;

	private final String description;
	
	private final UnitMeasurement unitMeasurement;
	
	private Map<Unit, Float> ratioMap;
	
	
	public GenericUnit(String code, String description, UnitMeasurement unitMeasurement) {
		this.code = code;
		this.description = description;
		this.unitMeasurement = unitMeasurement;
		this.ratioMap = new HashMap<>();
	}


	
	
	
	
	
	
	
	public void addConversionRatio(Unit unit, Float ratio) {
		
		ratioMap.put(unit, ratio);
	}
	
	
	
	
	




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
	public Float ratioFor(Unit otherUnit) {
		
		for (Unit unit : ratioMap.keySet())
			if (unit.equals(otherUnit))
				return ratioMap.get(unit);
		
		return null;
	}
	
	
	
	
	
	


	private static final long serialVersionUID = 1L;
}
