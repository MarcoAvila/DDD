package com.procergs.ddd.test.spec;

import com.procergs.ddd.spec.impl.AbstractSpecification;

public class UpperCaseSpec extends AbstractSpecification<String> {

	
	
		
	
	
	@Override
    public boolean isSatisfiedBy(String candidate) {
	
	    return candidate != null &&
		       candidate.equals( candidate.toUpperCase() );
    }

	
	
	
	
	

}
