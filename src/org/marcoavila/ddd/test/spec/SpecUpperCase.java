package org.marcoavila.ddd.test.spec;

import org.marcoavila.ddd.spec.impl.AbstractSpecification;

public class SpecUpperCase extends AbstractSpecification<String> {

	
	
		
	
	
	@Override
    public boolean isSatisfiedBy(String candidate) {

		if (candidate == null ||
			!candidate.equals( candidate.toUpperCase() ))
			return notSatisfied("This string isn't upper case!");
						
	    return true;
    }

	
	
	
	
	

}
