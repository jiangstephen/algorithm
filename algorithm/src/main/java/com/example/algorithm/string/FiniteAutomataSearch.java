package com.example.algorithm.string;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class FiniteAutomataSearch implements Search {

	private static State startState = new State(StringUtils.EMPTY);
	
	@Override
	public int indexOf(String pattern, String input) {
		State state = getFiniteAutomata(pattern);
		for(int i=0; i< input.length() ;i++){
			state = state.getState(input.charAt(i));
			if(state.getName().equals(pattern)){
				return i;
			}
		}
		return -1;
	}
	
	private State getFiniteAutomata(String pattern){
		State resultState = startState;
		State currentState = startState;
		for(int i=0; i < pattern.length(); i++){
			char c = pattern.charAt(i);
			State state = new State(pattern.substring(0, i+1));
			Edge edge = new Edge(currentState, state, c);
			currentState.addEdge(edge);
			currentState = state;
		}
		return resultState;
	}
	
	private static class State{
		
		private final String name;
		
		private Map<Character, Edge> edgesMap;
		
		public State(String name){
			this.name = name;
		}
		
		public void addEdge(Edge edge){
			if(edgesMap == null){
				edgesMap = new HashMap<>();
			}
			edgesMap.put(edge.getName(), edge);
		}
		
		public State getState(char name){
			if(edgesMap.containsKey(name)){
				return edgesMap.get(name).getEndState();
			}
			return startState;
		}

		public String getName() {
			return name;
		}

		
	}
	
	private static class Edge {
		
		private final State startState;
		private final State endState;
		private final char name;
		
		public Edge(State startState, State endState, char name){
			this.startState = startState;
			this.endState = endState;
			this.name = name;
		}

		public State getStartState() {
			return startState;
		}

		public State getEndState() {
			return endState;
		}

		public char getName() {
			return name;
		}
	}

}
