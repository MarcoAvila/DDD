package org.marcoavila.ddd.util;

public class ExceptionUtil {

	
	
	
	
	
	
	
	
	
	
	public static String getMessage(Exception e) {
		
		//if (e instanceof NullPointerException)
			//return "NullPointerException";
		
		if (e.getLocalizedMessage() != null)
			return e.getLocalizedMessage();
		
		if (e.getMessage() != null)
			return e.getMessage();
		
		return e.toString() +
			   (e.getCause() != null ? " - Cause: " + e.getCause().toString() : "");		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
