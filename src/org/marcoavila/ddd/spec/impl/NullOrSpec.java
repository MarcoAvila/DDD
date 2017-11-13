package org.marcoavila.ddd.spec.impl;

/**
 * 
 * @author Marco Avila
 */
public class NullOrSpec<T> extends AbstractSpecification<T> {

	
	
	
	
	
	
	@Override
	public boolean isSatisfiedBy(T candidate) {
		return false;
	}

	
	
	
	
	
}
