package rainer_sieberer;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

import java.io.PrintStream;


public class StateExplorer <S extends State>
{

	protected Collection<Action<S>> actions;

	public StateExplorer(Collection<Action<S>> actions )
	{
		this.actions = actions;
	}

	public Collection<Action<S>> solve ( S init, int goal, PrintStream out )
	{
		Set<S> explored = new HashSet<S>();
		Map<S,Source<S>> sources = new HashMap<S,Source<S>>();
		List<S> frontier = new LinkedList<S>();

		frontier.add( init );
		explored.add( init );
		sources.put( init, null );

		while ( !frontier.isEmpty() )
		{
			S currentState = frontier.remove(0); // gets the first element in the list;
			explored.add( currentState );

			for ( Action<S> currentAction: actions )
			{
				S nextState = currentAction.performOn( currentState );

				if ( nextState != null && !nextState.isAlreadyExplored( explored ) )
				{
					frontier.add( nextState );
					sources.put( nextState, new Source<S>( currentState, currentAction ) );

					if ( nextState.containsGoal( goal ) )
					{
						return backTrace( nextState, sources, out );
					}
					
				}

			}
			
		}

		return null;
	}

	public Collection<Action<S>> backTrace ( S finalState, Map<S,Source<S>> sources, PrintStream out )
	{
		Stack<Action<S>> stack = new Stack<Action<S>>();
		LinkedList<Action<S>> actions = new LinkedList<Action<S>>();
		S currentState = finalState;

		while ( sources.get(currentState) != null )
		{
			stack.push( sources.get(currentState).getAction() );
			currentState = sources.get(currentState).getPredecessor();
		}

		while ( !stack.isEmpty() )
		{
			actions.add( stack.pop() );
		}

		return actions;
	}

}
