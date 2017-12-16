package rainer_sieberer;

import rainer_sieberer.p3.*;

public class P3Tester
{

	public static void main ( String[] args )
	{

		P3Solver p3 = new P3Solver();

		// public int solve(int xCapacity, int yCapacity, int goal, PrintStream out)
		int x = p3.solve(7,4,9, System.out);
		System.out.println("result = " + x );

		x = p3.solve(2,5,17, System.out);
		System.out.println("result = " + x );


	}

}
