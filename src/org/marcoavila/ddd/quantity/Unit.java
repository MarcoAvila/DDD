package org.marcoavila.ddd.quantity;

public interface Unit {

	public String code();

	public String description();
	
	public UnitMeasurement unitMeasurement();
	
	public Float ratio(Unit otherUnit);
	
}
