package org.marcoavila.ddd.quantity;

import org.marcoavila.ddd.quantity.unit.Unit;
import org.marcoavila.ddd.quantity.unit.UnitCentimeterVO;
import org.marcoavila.ddd.quantity.unit.UnitMeasurement;
import org.marcoavila.ddd.quantity.unit.UnitMeterVO;

public class HeightVO extends QuantityVO {

	private HeightVO(float amount, Unit unit) {
		super(amount, unit);		
		
		if (unit.unitMeasurement() != UnitMeasurement.DISTANCE)
			throw new IllegalArgumentException("Invalid unit for height!");
	}

	
	
	
	
	public static HeightVO forCentimeters(Float amount) {		
		return new HeightVO(amount, UnitCentimeterVO.instance);
	}
	

	
	public static HeightVO forMeters(Float amount) {		
		return new HeightVO(amount, UnitMeterVO.instance);
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	

	@Override
	public String toString() {
		
		return display();
	}



	
	

	
	
	
	
	private static final long serialVersionUID = 1L;
}
