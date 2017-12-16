package rainer_sieberer.p1;

import java.util.Set;

import rainer_sieberer.State;

public class P1State implements State
{

	final public int xValue;
	final public int yValue;

	public P1State ( int x, int y )
	{
		this.xValue = x;
		this.yValue = y;
	}

	public boolean equals ( Object o )
	{
		if ( o instanceof P1State )
		{
			P1State compareState = (P1State) o;
			return ( this.xValue == compareState.xValue && this.yValue == compareState.yValue ); 
		}
		else
			return false;
	}

	public boolean containsGoal ( int goal )
	{
		return ( this.xValue == goal || this.yValue == goal );
	}

	public <S extends State> boolean isAlreadyExplored ( Set<S> explored )
	{
		for ( S currentState: explored )
		{
			if ( this.equals( currentState ) )
				return true; 
		}
		return false;
	}

	public String getInfo ()
	{
		return ( this.xValue + " " + this.yValue );
	}

}
