package org.marcoavila.ddd.test.spec;

import org.marcoavila.ddd.spec.impl.AbstractSpecification;

public class SpecTwoChars extends AbstractSpecification<String> {

	
	
		
	
	
	@Override
    public boolean isSatisfiedBy(String candidate) {

		if (candidate == null ||
		    candidate.length() != 2)
			return notSatisfied("This string hasn't 2 chars!");
						
	    return true;
    }

	
	
	
	
	

}
