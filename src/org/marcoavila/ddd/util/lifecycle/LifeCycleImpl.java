package org.marcoavila.ddd.util.lifecycle;

import java.util.List;

/**
 * 
 * @author marco-souza
 */

public class LifeCycleImpl<STATE> implements LifeCycle<STATE> {

	private List< State<STATE> > states;

	private State<STATE> state;
	
	
	
	
	
	
	public LifeCycleImpl(List< State<STATE> > states) {
		this.states = states;
		
		normalizeIds();
	}



	
	
	
	
	
	
	


	@Override
	public boolean born() {
		return state != null;
	}









	@Override
	public boolean unborn() {
		return !born();
	}




	
	
	
	
	
	

	
	@Override
	public boolean canBirth(STATE birthState) {

		for (State<STATE> m : states)
			if (m.isBirth() && 
				m.sameState(birthState))
				return true;
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	@Override
	public void birth(STATE birthState) {
		
		for (State<STATE> m : states)
			if (m.isBirth() && 
				m.sameState(birthState)) {
				state = m;
				break;
			}
	}
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public boolean canDoTransitionTo(STATE nextState) {

		if (state.sameState(nextState))
			return true;
		
		return state.validateTransitionTo(nextState);
	}
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void doTransitionTo(STATE nextState) {
		
		if (canDoTransitionTo(nextState))
			state = state.transitionTo(nextState);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	@Override
	public void restoreState(int momentId) {
		
		for (State<STATE> m : states)
			if (m.getId() == momentId) {
				state = m;
				break;
			}
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	@Override
	public int getStateId() {
		
		return state.getId();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public State<STATE> currentState() {
		return state;
	}



	
	
	
	
	
	

	@Override
	public String toString() {

		String s = "LifeCycle\n";
		
		for (State<STATE> m : states)
			s += "\n" + m.toString();
		
		return s;
	}






	
	private void normalizeIds() {
		int id = 1;
		
		for (State<STATE> s : states)
			s.setId(id++);
	}
	






	
	
	
	
}
