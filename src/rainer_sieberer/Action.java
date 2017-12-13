package rainer_sieberer;

public interface Action<S extends State>
{

	public S performOn ( S currentState );

	public String getLabel ();

}
