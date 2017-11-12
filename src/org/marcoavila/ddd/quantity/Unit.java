package org.marcoavila.ddd.quantity;

/**
 * 
 * @author Marco Avila
 */
public interface Unit {

	public String code();

	public String description();
	
	public UnitMeasurement unitMeasurement();
	
	public Float ratio(Unit otherUnit);
	
}
