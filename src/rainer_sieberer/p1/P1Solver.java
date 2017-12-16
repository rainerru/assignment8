package rainer_sieberer.p1;

import java.lang.Math;

import java.util.Set;
import java.util.LinkedList;
import java.util.Collection;

import java.io.PrintStream;

import rainer_sieberer.*;
import assignment8_int.*;

public class P1Solver implements P1
{

	private int xCapacity;
	private int yCapacity;

	public int solve(int xCapacity, int yCapacity, int goal, PrintStream out)
	{
		this.xCapacity = xCapacity;
		this.yCapacity = yCapacity;

		Collection<Action<P1State>> possibleActions = new LinkedList<Action<P1State>>();
		possibleActions.add(new PourXintoY());
		possibleActions.add(new PourYintoX());
		possibleActions.add(new FillX());
		possibleActions.add(new FillY());
		possibleActions.add(new EmptyX());
		possibleActions.add(new EmptyY());

		StateExplorer<P1State> waterPourer = new StateExplorer<P1State>( possibleActions );
		return waterPourer.solve( new P1State( 0,0 ), goal, out );
	}

	private class PourXintoY implements Action<P1State>
	{
		public P1State performOn ( P1State currentState )
		{
			int x = currentState.xValue;
			int y = currentState.yValue;
			int poured = java.lang.Math.min( x, yCapacity-y );
			return new P1State( x-poured, y+poured );
		}

		public String getLabel() { return "PourXintoY"; }
	}

	private class PourYintoX implements Action<P1State>
	{
		public P1State performOn ( P1State currentState )
		{
			int x = currentState.xValue;
			int y = currentState.yValue;
			int poured = java.lang.Math.min( y, xCapacity-x );
			return new P1State( x+poured, y-poured );
		}

		public String getLabel() { return "PourYintoX"; }
	}

	private class FillX implements Action<P1State>
	{
		public P1State performOn ( P1State currentState )
		{
			return new P1State( xCapacity, currentState.yValue );
		}

		public String getLabel() { return "FillX"; }
	}

	private class FillY implements Action<P1State>
	{
		public P1State performOn ( P1State currentState )
		{
			return new P1State( currentState.xValue, yCapacity );
		}

		public String getLabel() { return "FillY"; }
	}

	private class EmptyX implements Action<P1State>
	{
		public P1State performOn ( P1State currentState )
		{
			return new P1State( 0, currentState.yValue );
		}

		public String getLabel() { return "EmptyX"; }
	}

	private class EmptyY implements Action<P1State>
	{
		public P1State performOn ( P1State currentState )
		{
			return new P1State( currentState.xValue, 0 );
		}

		public String getLabel() { return "EmptyY"; }
	}



}
