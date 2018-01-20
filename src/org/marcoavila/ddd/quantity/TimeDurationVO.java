package org.marcoavila.ddd.quantity;

import org.marcoavila.ddd.quantity.unit.Unit;
import org.marcoavila.ddd.quantity.unit.UnitDayVO;
import org.marcoavila.ddd.quantity.unit.UnitMeasurement;
import org.marcoavila.ddd.quantity.unit.UnitWeekVO;

public class TimeDurationVO extends QuantityVO {

	private TimeDurationVO(float amount, Unit unit) {
		super(amount, unit);		
		
		if (unit.unitMeasurement() != UnitMeasurement.TIME)
			throw new IllegalArgumentException("Invalid unit for weight!");
	}

	
	
	
	
	public static TimeDurationVO forWeeks(Float amount) {		
		return new TimeDurationVO(amount, UnitWeekVO.instance);
	}
	
	
	

	
	public static TimeDurationVO forDays(Float amount) {		
		return new TimeDurationVO(amount, UnitDayVO.instance);
	}
	
	
	
	

	
	
	
	
	private static final long serialVersionUID = 1L;
}
