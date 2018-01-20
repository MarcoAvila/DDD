package org.marcoavila.ddd.quantity;

import org.marcoavila.ddd.quantity.unit.Unit;
import org.marcoavila.ddd.quantity.unit.UnitLiterVO;
import org.marcoavila.ddd.quantity.unit.UnitMeasurement;

public class VolumeVO extends QuantityVO {

	private VolumeVO(float amount, Unit unit) {
		super(amount, unit);

		if (unit.unitMeasurement() != UnitMeasurement.VOLUME)
			throw new IllegalArgumentException("Invalid unit for volume!");
	}

	
	
	
	
	public static VolumeVO forLiters(Float amount) {		
		return new VolumeVO(amount, UnitLiterVO.instance);
	}
	
	
	
	

	
	
	
	
	private static final long serialVersionUID = 1L;
}
