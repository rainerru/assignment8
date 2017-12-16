package rainer_sieberer;

import rainer_sieberer.p1.*;

public class P1Tester
{

	public static void main ( String[] args )
	{

		P1Solver p1 = new P1Solver();
		int x = p1.solve(5, 9, 8, System.out);
		System.out.println("result = " + x );

		x = p1.solve(10,2,2, System.out);
		System.out.println("result = " + x );

		x = p1.solve(5, 9, 10, System.out);
		System.out.println("result = " + x );

		x = p1.solve(5, 9, -1, System.out);
		System.out.println("result = " + x );

		x = p1.solve(3,10,5, System.out);
		System.out.println("result = " + x );

		x = p1.solve(3,10,0, System.out);
		System.out.println("result = " + x );


	}

}
