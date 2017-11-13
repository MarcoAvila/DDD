package org.marcoavila.ddd.util;

import java.lang.reflect.Constructor;

/**
 * 
 * @author Marco Avila
 */
public class InstantiationUtil {

	
	
	
	
	
	
	
	




	public static <T> T instantiate(Class<T> clazz) {
		
		try {
			Constructor<T> cons = clazz.getConstructor();

			return cons.newInstance();
			
		} catch (Exception e) {
			throw new IllegalStateException("Error on InstantiationUtil");
		}		
	}
	
	
	
	
	
	
	
	
	
	
	



	public static <T> T instantiate(Class<T> clazz, Object... construtorArg) {
		
		try {
			Constructor<T> cons = clazz.getConstructor( construtorArg.getClass() );

			return cons.newInstance(construtorArg);
			
		} catch (Exception e) {
			throw new IllegalStateException("Error on InstantiationUtil");
		}		
	}
	
	
	
	
	
	
	
	
	
	
	
}
