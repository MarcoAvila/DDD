package org.marcoavila.ddd.facade;

import java.io.Serializable;

public class BaseReturn<R> implements Serializable {

    private static final long serialVersionUID = 1L;
    
	private final boolean success;
	private final String message;
	private final R result;
	
	
	
	
	
	public BaseReturn(boolean success, String message, R result) {
	    this.success = success;
	    this.message = message;
	    this.result = result;
    }


	
	public BaseReturn(boolean success, String message) {
	    this.success = success;
	    this.message = message;
	    this.result = null;
    }

	
	
		
	
	
    public boolean success() {
	    return success;
    }

	
    public boolean failure() {
	    return !success;
    }
		
    public String message() {
	    return message;
    }
	
    public R getResult() {
	    return result;
    }



	
	
	
	
	
}
