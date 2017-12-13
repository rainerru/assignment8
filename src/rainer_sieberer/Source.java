package rainer_sieberer;

public class Source <S extends State>
{

	final private S predecessor;
	final private Action<S> action;

	public Source ( S pred, Action<S> act )
	{
		this.predecessor = pred;
		this.action = act;
	}

	public S getPredecessor () { return this.predecessor; }

	public Action<S> getAction () { return this.action; }

}
