package org.marcoavila.ddd.quantity.unit;

import java.io.Serializable;

/**
 * 
 * @author Marco Avila
 */
public interface Unit extends Serializable {

	public String code();

	public String description();
	
	public UnitMeasurement unitMeasurement();
	
	public Float ratioFor(Unit otherUnit);
	
}
