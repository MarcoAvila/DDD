package org.marcoavila.ddd.spec;

import java.util.List;

/**
 * 
 * @author marco-souza
 */

public interface FetchSpecification <FILTER, C> {

	public List<C> selectSatisfied(FILTER filter);
	
}
