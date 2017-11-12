package org.marcoavila.ddd.util.lifecycle;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Marco Avila
 */
public class State<STATE> {

	private int id;
	
	private boolean birth;
	
	private STATE state;

	private List<State<STATE> > transitions;

	
	
	
	
	public State(int id, boolean birth, STATE state) {
		this.id = id;
		this.birth = birth;
		this.state = state;
		this.transitions = new ArrayList<>();
	}




	
	
	
	
	
	
	
	public boolean validateTransitionTo(STATE state) {
		
		for (State<STATE> t : transitions)
			if (t.sameState(state))
				return true;
		
		return false;
	}
	
	
	
	
	
	
	
	


	public State<STATE> transitionTo(STATE state) {

		for (State<STATE> t : transitions)
			if (t.sameState(state))
				return t;
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public int getId() {
		return id;
	}






	public boolean isBirth() {
		return birth;
	}





	public STATE getState() {
		return state;
	}



	
	
/*
	public List<LifeCycleMoment<STATE>> getTransitions() {
		return transitions;
	}
*/



	
	

	public void addTransition(State<STATE> moment) {
		
		for (State<STATE> t : transitions)
			if (t.sameState(moment))
				return;
		
		transitions.add(moment);
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	public void replaceTransition(State<STATE> current, State<STATE> newMoment) {
		
		for (State<STATE> t : transitions)
			if (t.same(current)) {
				
				int position = transitions.indexOf(t);
				
				transitions.remove(t);
				
				transitions.add(position, newMoment);
				break;
			}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	private boolean same(State<STATE> moment) {
		return this.id == moment.id;
	}
	
	
	


	public boolean sameState(STATE state) {
		return this.state.equals(state);
	}
	
	


	public boolean sameState(State<STATE> moment) {
		return this.state.equals( moment.state );
	}
	
	
	
	
	
	
	
	
	



	public void setId(int id) {
		this.id = id;
	}











	@Override
	public String toString() {

		String s = id + " ";

		s += state.toString();
		s += (birth ? " [birth] " : "");
		
		if (!transitions.isEmpty()) {
			s += "\nTransitions:";
			
			for (State<STATE> t : transitions)
				s += " " + t.getId() + " " + t.state + 
				           (t.isBirth() ? "[b]" : "");
			
			s += "\n";
		}
		else
			s += " [final]\n";
		
		return s;
	}



	/*@Override
	public String toString() {

		String s = "LifeCycleMoment "+ id;

		s += (birth ? " [birth]" : "");
		s += "\n" + state.toString();
		s += "\nTransitions:";
		
		for (LifeCycleMoment<STATE> t : transitions)
			s += " " + t.getId() + " " + t.state;
		
		s += "\n";
		
		return s;
	}*/

	
	
	
}
