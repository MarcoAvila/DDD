package org.marcoavila.ddd.spec;

import java.util.List;

/**
 * 
 * @author Marco Avila
 */

public interface FetchSpecification <FILTER, C> {

	public List<C> selectSatisfied(FILTER filter);
	
}
