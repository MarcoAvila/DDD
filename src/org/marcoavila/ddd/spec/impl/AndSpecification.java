package org.marcoavila.ddd.spec.impl;

import org.marcoavila.ddd.spec.Specification;

/**
 * 
 * @author Marco Avila
 */
public class AndSpecification<T> extends AbstractSpecification<T> {

	private Specification<T> specificationLeft;
	private Specification<T> specificationRight;
	
	
	
	public AndSpecification(Specification<T> specificationLeft, Specification<T> specificationRight) {
	    this.specificationLeft = specificationLeft;
	    this.specificationRight = specificationRight;
    }


	
	
	
	
	
	
	

	@Override
    public boolean isSatisfiedBy(T candidate) {
		
		boolean specLeft = specificationLeft.isSatisfiedBy(candidate);
		boolean specRight = specificationRight.isSatisfiedBy(candidate);
		
		if (!specRight)
			unsatisfiedSpec = specificationRight;

		if (!specLeft)
			unsatisfiedSpec = specificationLeft;
		
		if (unsatisfiedSpec != null && 
			((AbstractSpecification<T>)unsatisfiedSpec).composite())
			unsatisfiedSpec = unsatisfiedSpec.remainderUnsatisfiedBy(candidate);
		
	    return specLeft && specRight;
    }



	
	
	
	
	
	
	
	

	@Override
	boolean composite() {
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
}
