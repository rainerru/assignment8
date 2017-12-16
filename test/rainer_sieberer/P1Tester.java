package rainer_sieberer;

import rainer_sieberer.p1.*;

public class P1Tester
{

	public static void main ( String[] args )
	{

		System.out.println("asdf");
		P1Solver p1 = new rainer_sieberer.p1.P1Solver();
		int x = p1.solve(5, 9, 8, System.out);
		System.out.println("result = " + x );

	}

}
