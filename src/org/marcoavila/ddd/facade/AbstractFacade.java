package org.marcoavila.ddd.facade;

/**
 * 
 * @author Marco Avila
 */
public abstract class AbstractFacade {

	private String errorMessage;
	
	
	
	
	
	
	
	
	
	
	
	
	
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
	
	
	
	
	
	
	
	
	
	
	
    	
	
	
	

	
	
	
	public final String errorMessage() {
		return errorMessage;
	}
	
	
	
	
	
	
	
	


	protected final boolean facadeError(String errorMessage) {
		this.errorMessage = errorMessage;
		return false;
	}






	protected final Object consultaFacadeError(String errorMessage) {
		this.errorMessage = errorMessage;
		return null;
	}




	
	
	
	
	
	
	
	
}

