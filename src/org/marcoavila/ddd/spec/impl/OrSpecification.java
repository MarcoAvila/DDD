package org.marcoavila.ddd.spec.impl;

import org.marcoavila.ddd.spec.Specification;

/**
 * 
 * @author Marco Avila
 */
public class OrSpecification<T> extends AbstractSpecification<T> {

	private Specification<T> specificationLeft;
	private Specification<T> specificationRight;
	
	
	
	public OrSpecification(Specification<T> specificationLeft, Specification<T> specificationRight) {
	    this.specificationLeft = specificationLeft;
	    this.specificationRight = specificationRight;
    }


	
	

	@Override
    public boolean isSatisfiedBy(T candidate) {
	    return specificationLeft.isSatisfiedBy(candidate) ||
	    	   specificationRight.isSatisfiedBy(candidate);
    }
	
	
	

	

	@Override
	boolean composite() {
		return true;
	}
	
	
	
	
	

}
