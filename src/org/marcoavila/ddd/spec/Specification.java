package org.marcoavila.ddd.spec;

/**
 * 
 * @author marco-souza
 */

public interface Specification<C> {

	public boolean isSatisfiedBy(C candidate);
	
	public Specification<C> and(Specification<C> other);
	public Specification<C> or(Specification<C> other);
	public Specification<C> xor(Specification<C> other);
	public Specification<C> not();
	
	public Specification<C> remainderUnsatisfiedBy(C candidate);
	public String message();
}
