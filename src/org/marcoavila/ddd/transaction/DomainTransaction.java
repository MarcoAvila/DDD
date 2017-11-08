package org.marcoavila.ddd.transaction;

import org.marcoavila.ddd.Entity;
import org.marcoavila.ddd.facade.BaseReturn;

public interface DomainTransaction<AGGREGATE extends Entity<?>> {

	public BaseReturn<AGGREGATE> execute(AGGREGATE rootEntity);
	
}
