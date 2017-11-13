package org.marcoavila.ddd.spec.impl;

import org.marcoavila.ddd.spec.Specification;

/**
 * 
 * @author Marco Avila
 */
public abstract class AbstractSpecification<C> implements Specification<C> {
	
	protected Specification<C> unsatisfiedSpec;
	
	
	
	
	
	
	
	
	
	
	
	@Override
    public final Specification<C> and(Specification<C> other) {
		
	    return new AndSpecification<C>(this, other);
    }

	
	
	
	
	
	
	@Override
    public final Specification<C> or(Specification<C> other) {
		
	    return new OrSpecification<C>(this, other);
    }

	

	
	
	
	
	
	@Override
    public final Specification<C> xor(Specification<C> other) {
		
	    return new XorSpecification<C>(this, other);
    }

	
	
	
	

	@Override
    public final Specification<C> not() {		
	    return new NotSpecification<C>(this);
    }

	

	
	
	
	

	boolean composite() {
		return false;
	}
	
	
	
	
	
	

	
	protected String message = "Especificação sem mensagem definida!";
	
	
	@Override
	public String message() {
		return message;
	}

	
	
	
	
	
	
	protected boolean notSatisfied(String message) {			
		this.message = message;
		return false;
	}
	
	
	
	
	
	

	/**
	 *  Retorna a especificação que não foi atendida pelo objeto.
	 *  Implementado para encadeamentos AND.
	 */

	@Override
	public final Specification<C> remainderUnsatisfiedBy(C candidate){
				
		return isSatisfiedBy(candidate) ?
			   null :
			   unsatisfiedSpec;
	}
	
	
	
	
	
	
	
	
	
}
