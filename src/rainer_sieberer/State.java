package rainer_sieberer;

import java.util.Set;

/**
 * test
 *
 * @author Rudolf Rainer, Jonas Sieberer
 */
public interface State
{

	/**
	 * constructor
	 * @param o		bla
	 * @return		asdfwre
	 */
	public boolean equals ( Object o );

	/**
	 * constructor
	 * @param goal		bla12345
	 * @return				asdfwre
	 */
	public boolean containsGoal ( int goal );

	/**
	 * constructor
	 * @param explored		bla456567478
	 * @return						asdfwre
	 */
	public <S extends State> boolean isAlreadyExplored ( Set<S> explored );

}
