package org.marcoavila.ddd.unitofwork;

import java.util.List;

import org.marcoavila.ddd.Entity;

public interface UnitOfWork {
	
	public <EN extends Entity<?>> EN find(EN persistedEntity);
	
	public void add(Entity<?> entity);
	public  <EN extends Entity<?>> void addAll(List<EN> entities);
	
	public void remove(Entity<?> entity);
	
	public boolean commit();	
	
	public void printChangesToCommit();
	public String message();	
}
