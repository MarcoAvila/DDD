package org.marcoavila.ddd.example;

import org.marcoavila.ddd.AbstractEntity;
import org.marcoavila.ddd.AggregateRoot;

/**
 * 
 * @author Marco Avila
 */

@AggregateRoot
public class InstrumentEN extends AbstractEntity<Long> {

	private final InstrumentTypeVO type;
	
	private final InstrumentNatureVO nature;
	
	private final String name;
	
	private final int stringsCount;
	
	private StringsVO strings;

	
	
	
		
	
	public InstrumentEN(InstrumentTypeVO type, InstrumentNatureVO nature,
			String name, int stringsCount) {
		this.type = type;
		this.nature = nature;
		this.name = name;
		this.stringsCount = stringsCount;
	}

	
	
	
	


	public InstrumentTypeVO getType() {
		return type;
	}


	public InstrumentNatureVO getNature() {
		return nature;
	}


	public String getName() {
		return name;
	}


	public int getStringsCount() {
		return stringsCount;
	}

	 
	public StringsVO getStrings() {
		return strings;
	}



	
	
	
	
	
	
	@Override
	public Boolean checkInvariants() {

		if (type == null)
			return invariantsError("Instrument requires type!");

		if (nature == null)
			return invariantsError("Instrument requires nature!");
		
		if (name == null)
			return invariantsError("Instrument requires name!");

		if (stringsCount < 1)
			return invariantsError("String count must be greater than zero!");

		if (strings == null)
			return invariantsError("Instrument requires strings!");
		
		return true;
	}

	
	
	
	
	
	
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + stringsCount;
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		InstrumentEN other = (InstrumentEN) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stringsCount != other.stringsCount)
			return false;
		return true;
	}




	private static final long serialVersionUID = 1L;
	
}
