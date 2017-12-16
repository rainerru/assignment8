package rainer_sieberer;

import java.util.Set;

public interface State
{

	public boolean equals ( Object o );

	public boolean containsGoal ( int goal );

	public <S extends State> boolean isAlreadyExplored ( Set<S> explored );

	public String getInfo ();

}
