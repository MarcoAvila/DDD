package org.marcoavila.ddd.example;

import java.util.ArrayList;
import java.util.List;

import org.marcoavila.ddd.AbstractValueObject;

/**
 * 
 * @author Marco Avila
 */
public class StringsVO extends AbstractValueObject<StringsVO>{

	private final List<StringEN> strings;

	public StringsVO(List<StringEN> strings) {
		this.strings = new ArrayList<>(strings);
	}


	
	
	
	
	
	
	public StringsVO replaceWith(StringEN newString) {

		List<StringEN> newStrings = new ArrayList<>();
		
		for (StringEN string : strings)
			if (string.getPosition() == newString.getPosition()) {

				newString.startUsing();
				string.replaced();
				
				newStrings.add(newString);				
			}		
			else
				newStrings.add(string);
		
		return new StringsVO(newStrings);
	}
	






	public List<StringEN> getCurrentStrings() {
		
		List<StringEN> stringsInUse = new ArrayList<>();
		
		for (StringEN s : strings)
			if (s.inUse())
				stringsInUse.add(s);
		
		return stringsInUse;
	}





	
	
	
	
	
	
	
	







	@Override
	public Boolean checkInvariants() {
		
		if (strings == null)
			return invariantsError("StringsVO requires strings!");

		for (int position=1; position<=strings.size(); position++)
			if ( strings.get( position-1 ).getPosition() != position)
				return invariantsError("String in the wrong position!");
					
		return true;
	}



	
	
	
	
	
	







	@Override
	public boolean valueEquals(StringsVO other) {
		if (strings == null) {
			if (other.strings != null)
				return false;
		} else if (!strings.equals(other.strings))
			return false;
		return true;
	}










	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((strings == null) ? 0 : strings.hashCode());
		return result;
	}








	
	
	
	
	

	private static final long serialVersionUID = 1L;
	
}
