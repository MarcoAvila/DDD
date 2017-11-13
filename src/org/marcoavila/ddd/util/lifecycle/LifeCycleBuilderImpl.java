package org.marcoavila.ddd.util.lifecycle;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Marco Avila
 */
public class LifeCycleBuilderImpl<STATE> implements LifeCycleBuilder<STATE> {
		
	private List< State<STATE> > states;

	private List< State<STATE> > toBirthStates;

	private List< State<STATE> > convergingPaths;

	private List<STATE> wildCards;
	
	private State<STATE> currentState;
	private int id = 1;

	private State<STATE> bifurcationState;
	
	private boolean doConverge;
	
	
	
	
	
	
		
	
	
	
	public LifeCycleBuilderImpl() {
		states = new ArrayList<>();
		toBirthStates = new ArrayList<>();
		convergingPaths = new ArrayList<>();
		wildCards = new ArrayList<>();
	}






	
	
	
	
	







	@Override
	public LifeCycleBuilder<STATE> birth(STATE birthState) {

		State<STATE> newMoment = createBirth(birthState);
		
		solveConvergingPaths(newMoment);
		
		if (currentState != null)
			convergingPaths.add(currentState);
		
		bifurcationState = null;
		
		currentState = newMoment;		
		states.add(currentState);
		
		return this;		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public LifeCycleBuilder<STATE> next(STATE nextState) {

		State<STATE> newMoment = create(nextState);
		
		solveConvergingPaths(newMoment);
		
		currentState.addTransition(newMoment);

		currentState = newMoment;		
		states.add(currentState);
		
		bifurcationState = null;
		
		return this;		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public LifeCycleBuilder<STATE> path(STATE nextState) {

		State<STATE> newMoment = create(nextState);
		
		solveConvergingPaths(newMoment);
		
		if (bifurcationState == null) {
			bifurcationState = currentState;

			currentState.addTransition(newMoment);
		}		
		else
			bifurcationState.addTransition(newMoment);
		
		currentState = newMoment;		
		states.add(currentState);
		
		return this;		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public LifeCycleBuilder<STATE> toBirth() {

		//TODO solveConvergingPaths(state);
		
		toBirthStates.add(currentState);
		
		currentState = null;
		
		return this;		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public LifeCycleBuilder<STATE> converge() {
		
		convergingPaths.add(currentState);
		
		doConverge = true;

		bifurcationState = null;

		return this;		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	private void solveConvergingPaths(State<STATE> convergingState) {
		
		if (!doConverge)
			return;

		STATE state = convergingPaths.iterator().next().getState();
		
		for (State<STATE> m : convergingPaths)
			if (!m.sameState(state))
				throw new IllegalStateException("Converging different paths!!!");
						
		State<STATE> last = convergingPaths.get( convergingPaths.size() - 1 );
		
		last.addTransition(convergingState);
				
		for (int i=0; i<convergingPaths.size() - 1; i++)
			replaceState(convergingPaths.get(i), last);

		convergingPaths.clear();
		doConverge = false;
		
		bifurcationState = null;
	}
	
	
	
	
	
	
	
		
	
	
	
	
	
	@Override
	public LifeCycleBuilder<STATE> back() {

		bifurcationState = null;
		
		for (int a=states.size() - 2; a>=0; a--)
			if (states.get(a).sameState( currentState.getState() )) {
				
				replaceState(currentState, states.get(a));				
				break;
			}
				
		return this;
	}

	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void addWildCard(STATE wildCardState){
		
		this.wildCards.add(wildCardState);
	}

	
	
	
	
	
	
//-------------------------------------------------------------------------------------------------
		
		
	
	
	
	
	
	@Override
	public LifeCycle<STATE> build() {
		
		solveToBirths();
		
		solveWildCards();
		
		LifeCycle<STATE> lifeCycle = new LifeCycleImpl<STATE>(states);
			
		return lifeCycle;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void solveToBirths() {
		
		for (State<STATE> bm : toBirthStates) {
			
			State<STATE> birthMoment = null;
			
			for (State<STATE> m : states)
				if (m.isBirth() && m.sameState(bm)) {
					birthMoment = m;
					break;
				}
					
			replaceState(bm, birthMoment);			
		}
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	private void solveWildCards() {

		if (wildCards == null)
			return;
		
		for (STATE s : wildCards) {
			
			State<STATE> newMoment = create(s);
			
			states.add(newMoment);

			for (State<STATE> m : states)
				if (!m.sameState(s))
					m.addTransition(newMoment);
		}
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private State<STATE> create(STATE state) {

		return new State<STATE>(id++, false, state);
	}
	
	
	
	
	
	
	
	
	

	
	private State<STATE> createBirth(STATE birthState) {
		
		for (State<STATE>  m : states)
			if (m.sameState(birthState) &&
				m.isBirth())
				throw new IllegalArgumentException("Only 1 birth per STATE allowed!");

		return new State<STATE>(id++, true, birthState);
	}
	
	
	
	
	
	
	
	

	
	
	
	private void replaceState(State<STATE> current, State<STATE> newState) {
				
		states.remove(current);
				
		for (State<STATE> s : states)
			s.replaceTransition(current, newState);		
	}
	
	
	
	
	
	
	
}
