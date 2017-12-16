package rainer_sieberer.p2;

import java.util.Set;

import rainer_sieberer.State;

public class P2State implements State
{

	final public int xValue;
	final public int yValue;
	final public int zValue;

	public P2State ( int x, int y, int z )
	{
		this.xValue = x;
		this.yValue = y;
		this.zValue = z;
	}

	public boolean equals ( Object o )
	{
		if ( o instanceof P2State )
		{
			P2State compareState = (P2State) o;
			return ( this.xValue == compareState.xValue
				&& this.yValue == compareState.yValue
				&& this.zValue == compareState.zValue ); 
		}
		else
			return false;
	}

	public boolean containsGoal ( int goal )
	{
		return ( this.xValue == goal || this.yValue == goal || this.zValue == goal );
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
		return ( this.xValue + " " + this.yValue + " " + this.zValue );
	}

}
