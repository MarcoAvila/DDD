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
	
	//Tirar esse método e impl o abaichooooooo, bíacho
	//public Float ratioFor(Unit otherUnit);
	
	//Para Celsius <-> Farenheit TODO IMPL!!!!
	public float convertTo(float amount, Unit targetUnit);
	
}
