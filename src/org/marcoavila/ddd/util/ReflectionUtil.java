package org.marcoavila.ddd.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @author marco-souza
 */

public class ReflectionUtil {

	
	
	
	
	
	
	
	
	

	
	public static <A extends Annotation> boolean annotated(Class<?> clazz, Class<A> annotation) {
		
		return clazz.getAnnotation( annotation ) != null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static Class<?> parameterizedType(Class<?> clazz) {
		
		return parameterizedTypes(clazz).iterator().next();
	}
 	
	
	
	

	
	
	public static List<Class<?>> hierarchy(Class<?> clazz) {

		List<Class<?>> classes = new ArrayList<>();
				
		while (!clazz.equals( Object.class )   ) {

			classes.add(clazz);			
			
			clazz = clazz.getSuperclass();
		}
			
		return classes;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static List<Class<?>> implementedInterfaces(Class<?> clazz) {

		List<Class<?>> implemented = new ArrayList<>();
		
		List<Class<?>> hierarchy = hierarchy(clazz);
		
		for (Class<?> c : hierarchy)
			for (Class<?> i : c.getInterfaces())
				implemented.add(i);
			
		return implemented;
	}
	
	
	
	
	
	
	
	
	
	
	public static List<Class<?>> types(Class<?> clazz) {

		List<Class<?>> types = ReflectionUtil.hierarchy(clazz);
		
		types.addAll( ReflectionUtil.implementedInterfaces(clazz) );
			
		return types;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static List<Class<?>> parameterizedTypes(Class<?> clazz) {
		
		List<Class<?>> classes = new ArrayList<>();
		
		ParameterizedType pt = (ParameterizedType)clazz.getGenericSuperclass();
				
		for (Type t : pt.getActualTypeArguments())
			classes.add( (Class<?>)t);
		
		return classes;		
	}
 	
	
	
	
	
	
	
	
	
	
	
	

	

	public static List<Field> classAttributes(Class<?> clazz) { 

		Field[] fields =  clazz.getDeclaredFields();
		
		List<Field> atts = new ArrayList<>();
		
		for (Field f : fields)
			if (f.getType() != null)
				atts.add(f);
				
		return atts;
	}
 	
	
	
	
	
	
	
	
	
	
	

	
	

	public static Object fieldValue(Field field, Object owner) {

		Method[] methods = owner.getClass().getMethods();

		try {	    			
    		for (Method m : methods)
    			if (m.getName().equalsIgnoreCase("get" + field.getName())) {
    				
    				Object o = m.invoke(owner, new Object[] {} );
    				
    				return o;    				
    			}
    					
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
 
	
	
	
	
	
		
	
	
	
	
	

	
	

	public static boolean isCollection(Class<?> clazz) {
		
		return Collection.class.isAssignableFrom(clazz);
	}
 	
	
	
	
	
	
	
}

