package rainer_sieberer.p2;

import java.lang.Math;

import java.util.Set;
import java.util.LinkedList;
import java.util.Collection;

import java.io.PrintStream;

import rainer_sieberer.*;
import assignment8_int.*;

public class P2Solver implements P2
{

	private int xCapacity;
	private int yCapacity;
	private int zCapacity;
	public int solve(int xCapacity, int yCapacity, int zCapacity, int xInit, int yInit, int zInit, int goal, PrintStream out)
	{
		this.xCapacity = xCapacity;
		this.yCapacity = yCapacity;
		this.zCapacity = zCapacity;

		Collection<Action<P2State>> possibleActions = new LinkedList<Action<P2State>>();
		possibleActions.add(new PourXintoY());
		possibleActions.add(new PourYintoZ());
		possibleActions.add(new PourZintoX());

		StateExplorer<P2State> waterPourer = new StateExplorer<P2State>( possibleActions );
		return waterPourer.solve( new P2State( xInit, yInit, zInit ), goal, out );
	}

	private class PourXintoY implements Action<P2State>
	{
		public P2State performOn ( P2State currentState )
		{
			int x = currentState.xValue;
			int y = currentState.yValue;
			int z = currentState.zValue;
			int poured = java.lang.Math.min( x, yCapacity-y );
			return new P2State( x-poured, y+poured, z );
		}

		public String getLabel() { return "PourXintoY"; }
	}

	private class PourYintoZ implements Action<P2State>
	{
		public P2State performOn ( P2State currentState )
		{
			int x = currentState.xValue;
			int y = currentState.yValue;
			int z = currentState.zValue;
			int poured = java.lang.Math.min( y, zCapacity-z );
			return new P2State( x, y-poured, z+poured );
		}

		public String getLabel() { return "PourYintoZ"; }
	}

	private class PourZintoX implements Action<P2State>
	{
		public P2State performOn ( P2State currentState )
		{
			int x = currentState.xValue;
			int y = currentState.yValue;
			int z = currentState.zValue;
			int poured = java.lang.Math.min( z, xCapacity-x );
			return new P2State( x+poured, y, z-poured );
		}

		public String getLabel() { return "PourZintoX"; }
	}


}
