package org.marcoavila.ddd.quantity.unit;

public class Units {

	
	
	
	
	private Unit[] knownUnits = {
		
		UnitCentimeterVO.instance,
		UnitMeterVO.instance,
		
		UnitGramVO.instance,
		UnitKilogramVO.instance,
		
		UnitMinuteVO.instance,
		UnitHourVO.instance,
		UnitDayVO.instance,
		UnitWeekVO.instance,
		
		UnitLiterVO.instance,
		UnitMilliliterVO.instance
	};
	
	
	
	
	
	
	
	
	public Unit parseUnit(String code) {
		
		for (Unit u : knownUnits)
			if (u.code().equals(code))
				return u;
						
		return new GenericUnit(code, "", UnitMeasurement.ANY);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
