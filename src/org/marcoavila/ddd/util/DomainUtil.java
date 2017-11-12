package org.marcoavila.ddd.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.marcoavila.ddd.AggregateRoot;
import org.marcoavila.ddd.Entity;

/**
 * 
/**
 * 
 * @author Marco Avila
 */
 */

public class DomainUtil {

	
	

	
	
	
	
	
	public static boolean hasId(Entity<?> entity) {

		return entity.getId() != null;
	}
	
	
	
	
	
	
	
	
	
	

	
	
	public static boolean noId(Entity<?> entity) {

		return entity.getId() == null;
	}
	
	
	
	
	


	
	
	
	
	
	
	
	
	
	public static boolean sameId(Entity<?> entity, Entity<?> otherEntity) {

		if (!entity.getClass().equals(otherEntity.getClass()))
			return false;
		
		if (noId(entity) || noId(otherEntity))
			return false;
		
		return entity.getId().equals(otherEntity.getId());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	public static boolean aggregateRoot(Entity<?> entity) {

		return ReflectionUtil.annotated(entity.getClass(), AggregateRoot.class);
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
	

	
	public static List<Entity<?>> lookForAggregateRoots(Entity<?> entity) {
		
		List<Entity<?>> roots = new ArrayList<>();
		
		if (!aggregateRoot(entity))
			return roots;
		
		//Fields
		List<Field> atts = ReflectionUtil.classAttributes( entity.getClass() );
		
		for (Field f : atts)
			if (ReflectionUtil.annotated( f.getType(), AggregateRoot.class)) {
				
				Object object = ReflectionUtil.fieldValue(f, entity);
				
				if (object != null)
					roots.add( (Entity<?>)object  );
			}
		
		//Collections
		for (Field f : atts)
			if (ReflectionUtil.isCollection( f.getType() )) {
				
				Collection<?> collectionObject = (Collection<?>)ReflectionUtil.fieldValue(f, entity);
				
				if (collectionObject != null)
    				for (Object o : collectionObject)
    					if (o != null &&
    						ReflectionUtil.annotated(o.getClass(), AggregateRoot.class)) 
    						roots.add( (Entity<?>)o );						
			}
									
		return roots;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	public static boolean referencedNewEntity(Entity<?> entity, Entity<?> referencedEntity) {
		
		List<Entity<?>> roots = new ArrayList<>();
		
		roots.add(entity);
		
		for (int i=0; i<roots.size(); i++) {
			
			Entity<?> root = roots.get(i);
			
			if (root.equals(referencedEntity))
				return true;
			
			List< Entity<?> > nested = lookForAggregateRoots(root);
			
			for (Entity<?> e : nested)
				if (!hasId(e))
					roots.add(e);	
		}
						
		return false;
	}

	
	
		
		
		
	
	
	
	
	
}

