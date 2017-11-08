package org.marcoavila.ddd.spec.impl;


/**
 * 
 * @author marco-souza
 */
public class NullOrSpec<T> extends AbstractSpecification<T> {

	
	
	
	
	
	
	@Override
	public boolean isSatisfiedBy(T candidate) {
		return false;
	}

	
	
	
	
	
}
