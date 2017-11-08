package org.marcoavila.ddd.transaction;

import org.marcoavila.ddd.Entity;
import org.marcoavila.ddd.facade.BaseReturn;
import org.marcoavila.ddd.util.DomainUtil;

public abstract class AbstractDomainTransaction<AGGREGATE extends Entity<?>> implements DomainTransaction<AGGREGATE> {

	private String message = "";
	
	private AGGREGATE result;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public BaseReturn<AGGREGATE> execute(AGGREGATE rootEntity) {

		//Aggregate Root
		if (!DomainUtil.aggregateRoot(rootEntity))
			return failure("ENTITY is not an AGGREGATE ROOT!");
		
		//Pre-Conditions
		if (!preConditions(rootEntity))
			return failure(message);
		
		//Execute
		if (!executeImpl(rootEntity))
			return failure(message);

		//Post-Conditions
		if (!postConditions(rootEntity))
			return failure(message);
				
		return success("SUCCESS", result);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

	protected abstract boolean preConditionsImpl(AGGREGATE entity);

	protected abstract boolean executeImpl(AGGREGATE entity);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private boolean preConditions(AGGREGATE entity) {

		//Invariants
		if (entity != null &&
		   !entity.checkInvariants()) 
			return falseWithMessage("PRE-TRANSCTION: " + entity.invariantsMessage() );	
		
		return preConditionsImpl(entity);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private boolean postConditions(AGGREGATE entity) {

		//Invariants
		if (!entity.checkInvariants())
			return falseWithMessage("POST-TRANSACTION: " + entity.invariantsMessage() );	
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	protected void setResult(AGGREGATE entity) {	
		this.result = entity;
	}
	
	protected final void setMessage(String message) {		
		this.message = message;
	}

	protected final void addMessage(String message) {		
		this.message += message;
	}
	
	protected final boolean falseWithMessage(String message) {		
		setMessage(message);
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	protected <T> BaseReturn<T> success(String mensagem, T result){
		return new BaseReturn<T>(true, mensagem, result);
	}
	
	protected <T> BaseReturn<T> success(String mensagem){
		return success(mensagem, null);
	}
	
	protected <T> BaseReturn<T> failure(String mensagem, T result){
		return new BaseReturn<T>(false, mensagem, result);
	}
	
	protected <T> BaseReturn<T> failure(String mensagem){
		return failure(mensagem, null);
	}
	
	
	
	
	
	
	
	
	
	
}
