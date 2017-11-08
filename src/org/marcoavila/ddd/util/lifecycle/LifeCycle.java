package org.marcoavila.ddd.util.lifecycle;

/**
 * 
 * @author marco-souza
 */

public interface LifeCycle<STATE> {

	public boolean born();
	public boolean unborn();
	
	public boolean canBirth(STATE state);
	public void birth(STATE birthState);

	public boolean canDoTransitionTo(STATE state);
	public void doTransitionTo(STATE state);
	
	public State<STATE> currentState();
	public int getStateId();	
	public void restoreState(int stateId);
}