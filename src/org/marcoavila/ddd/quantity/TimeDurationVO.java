package org.marcoavila.ddd.quantity;

import org.marcoavila.ddd.quantity.unit.Unit;
import org.marcoavila.ddd.quantity.unit.UnitDayVO;
import org.marcoavila.ddd.quantity.unit.UnitHourVO;
import org.marcoavila.ddd.quantity.unit.UnitMeasurement;
import org.marcoavila.ddd.quantity.unit.UnitMinuteVO;
import org.marcoavila.ddd.quantity.unit.UnitSecondVO;
import org.marcoavila.ddd.quantity.unit.UnitWeekVO;

public class TimeDurationVO extends QuantityVO {

	private TimeDurationVO(float amount, Unit unit) {
		super(amount, unit);		
		
		if (unit.unitMeasurement() != UnitMeasurement.TIME)
			throw new IllegalArgumentException("Invalid unit for time duration!");
	}

	
	
	
	
	public static TimeDurationVO forWeeks(Float amount) {		
		return new TimeDurationVO(amount, UnitWeekVO.instance);
	}
	
	
	

	
	public static TimeDurationVO forDays(Float amount) {		
		return new TimeDurationVO(amount, UnitDayVO.instance);
	}
	
	
	
	
	
	public static TimeDurationVO forHours(Float amount) {		
		return new TimeDurationVO(amount, UnitHourVO.instance);
	}
	
	

	
	
	public static TimeDurationVO forMinutes(Float amount) {		
		return new TimeDurationVO(amount, UnitMinuteVO.instance);
	}
	
	
	

	
	
	public static TimeDurationVO forSeconds(Float amount) {		
		return new TimeDurationVO(amount, UnitSecondVO.instance);
	}
	
	

	
	
	
	
	private static final long serialVersionUID = 1L;
}
