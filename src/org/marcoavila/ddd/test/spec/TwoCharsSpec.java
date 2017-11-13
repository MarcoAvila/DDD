package com.procergs.ddd.test.spec;

import com.procergs.ddd.spec.impl.AbstractSpecification;

/**
 * 
 * @author Marco Avila
 */
public class TwoCharsSpec extends AbstractSpecification<String> {

	
	
		
	
	
	@Override
    public boolean isSatisfiedBy(String candidate) {
	
	    return candidate != null &&
		       candidate.length() == 2;
    }

	
	
	
	
	

}
