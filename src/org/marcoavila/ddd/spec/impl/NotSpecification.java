package org.marcoavila.ddd.spec.impl;

import org.marcoavila.ddd.spec.Specification;

/**
 * 
 * @author Marco Avila
 */
public class NotSpecification<T> extends AbstractSpecification<T> {

	private Specification<T> specification;
	
	
	
	public NotSpecification(Specification<T> specification) {
	    this.specification = specification;
    }


	
	
	
	

	@Override
    public boolean isSatisfiedBy(T candidate) {
	    return !specification.isSatisfiedBy(candidate);
    }



	
	
	


	@Override
	public String message() {
		return specification.message();
	}
	
	
	


	
	
}
