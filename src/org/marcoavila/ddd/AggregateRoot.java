package org.marcoavila.ddd;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* Annotation that represents the aggregate root concept.
*
* @author Marco Avila
*/
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = { ElementType.TYPE }) 
public @interface AggregateRoot {

}
