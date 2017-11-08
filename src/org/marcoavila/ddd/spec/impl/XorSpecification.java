package org.marcoavila.ddd.spec.impl;

import org.marcoavila.ddd.spec.Specification;

/**
 * 
 * @author marco-souza
 */
public class XorSpecification<T> extends AbstractSpecification<T> {

	private Specification<T> specificationLeft;
	private Specification<T> specificationRight;
	
	
	
	public XorSpecification(Specification<T> specificationLeft, Specification<T> specificationRight) {
	    this.specificationLeft = specificationLeft;
	    this.specificationRight = specificationRight;
    }


	
	

	@Override
    public boolean isSatisfiedBy(T candidate) {
		
		boolean spec1 = specificationLeft.isSatisfiedBy(candidate);
		boolean spec2 = specificationRight.isSatisfiedBy(candidate);
				
	    return spec1 ^ spec2;
    }



	
	


	@Override
	boolean composite() {
		return true;
	}
	
	
	
	
	
	
	
	
	
	
}
