package org.marcoavila.ddd.quantity;

import org.marcoavila.ddd.quantity.unit.Unit;
import org.marcoavila.ddd.quantity.unit.UnitGramVO;
import org.marcoavila.ddd.quantity.unit.UnitKilogramVO;
import org.marcoavila.ddd.quantity.unit.UnitMeasurement;

public class WeightVO extends QuantityVO {

	private WeightVO(float amount, Unit unit) {
		super(amount, unit);		
		
		if (unit.unitMeasurement() != UnitMeasurement.WEIGHT)
			throw new IllegalArgumentException("Invalid unit for weight!");
	}

	
	
	
	
	public static WeightVO forGrams(Float amount) {		
		return new WeightVO(amount, UnitGramVO.instance);
	}
	

	
	public static WeightVO forKilograms(Float amount) {		
		return new WeightVO(amount, UnitKilogramVO.instance);
	}
	
	
	
	

	
	
	
	
	private static final long serialVersionUID = 1L;
}
