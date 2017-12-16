package rainer_sieberer.p3;

import java.lang.Math;

import java.util.Set;
import java.util.LinkedList;
import java.util.Collection;

import java.io.PrintStream;

import rainer_sieberer.*;
import assignment8_int.*;

public class P3Solver implements P3
{

	private int xCapacity;
	private int yCapacity;

	public int solve(int xCapacity, int yCapacity, int goal, PrintStream out)
	{
		this.xCapacity = xCapacity;
		this.yCapacity = yCapacity;

		Collection<Action<P3State>> possibleActions = new LinkedList<Action<P3State>>();
		possibleActions.add(new reverseLeft());
		possibleActions.add(new reverseRight());

		StateExplorer<P3State> waterPourer = new StateExplorer<P3State>( possibleActions );
		return waterPourer.solve( new P3State( 0,0,0 ), goal, out );
	}

	private class reverseLeft implements Action<P3State>
	{
		public P3State performOn ( P3State currentState )
		{
			int x = currentState.xValue;
			int y = currentState.yValue;
			int t = currentState.timePassed;
			int passed = java.lang.Math.min( x, y );

			x = xCapacity - (x-passed);
			y = y-passed;
			t = t+passed;

			return new P3State( x,y,t );
		}

		public String getLabel() { return "reverseLeft"; }
	}

	private class reverseRight implements Action<P3State>
	{
		public P3State performOn ( P3State currentState )
		{
			int x = currentState.xValue;
			int y = currentState.yValue;
			int t = currentState.timePassed;
			int passed = java.lang.Math.min( x, y );

			x = x-passed;
			y = yCapacity - (y-passed);
			t = t+passed;

			return new P3State( x,y,t );
		}

		public String getLabel() { return "reverseRight"; }
	}

	private class reverseBoth implements Action<P3State>
	{
		public P3State performOn ( P3State currentState )
		{
			int x = currentState.xValue;
			int y = currentState.yValue;
			int t = currentState.timePassed;
			int passed = java.lang.Math.min( x, y );

			x = xCapacity - (x-passed);
			y = yCapacity - (y-passed);
			t = t+passed;

			return new P3State( x,y,t );
		}

		public String getLabel() { return "reverseBoth"; }
	}


}
