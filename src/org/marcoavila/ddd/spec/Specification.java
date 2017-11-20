package org.marcoavila.ddd.spec;

/**
 * Abstraction that represents an Domain Specification. 
 *
 * Declare logical operators between specifications. 
 *
 * @author Marco Avila
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
