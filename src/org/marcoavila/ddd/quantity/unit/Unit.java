package org.marcoavila.ddd.quantity.unit;

/**
 * 
 * @author Marco Avila
 */
public interface Unit {

	public String code();

	public String description();
	
	public UnitMeasurement unitMeasurement();
	
	public Float ratioFor(Unit otherUnit);
	
}
