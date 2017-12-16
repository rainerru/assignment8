package rainer_sieberer.p3;

import java.util.Set;

import rainer_sieberer.State;

public class P3State implements State
{

	final public int xValue;
	final public int yValue;
	final public int timePassed;

	public P3State ( int x, int y, int time )
	{
		this.xValue = x;
		this.yValue = y;
		this.timePassed = time;
	}

	public boolean equals ( Object o )
	{
		if ( o instanceof P3State )
		{
			P3State compareState = (P3State) o;
			return ( this.xValue == compareState.xValue
				&& this.yValue == compareState.yValue
				&& this.timePassed == compareState.timePassed ); 
		}
		else
			return false;
	}

	public boolean containsGoal ( int goal )
	{
		return ( this.timePassed == goal );
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
		return ( this.timePassed + ": " + this.xValue + " " + this.yValue );
	}

}
