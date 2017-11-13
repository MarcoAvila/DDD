package org.marcoavila.ddd.test.spec;

import org.marcoavila.ddd.spec.impl.AbstractSpecification;

public class SpecSingleChar extends AbstractSpecification<String> {

	
	
	
	
	
	
	@Override
    public boolean isSatisfiedBy(String candidate) {
						
		if (candidate == null ||
		    candidate.length() != 1)
			return notSatisfied("This string has more than 1 char!");
				
	    return true;
    }

	
	
	
	
	
}
