package rainer_sieberer;

import rainer_sieberer.p2.*;

public class P2Tester
{

	public static void main ( String[] args )
	{

		P2Solver p2 = new P2Solver();

		// public int solve(int xCapacity, int yCapacity, int zCapacity, int xInit, int yInit, int zInit, int goal, PrintStream out);
		int x = p2.solve(5, 9, 8, 2,3,4,5, System.out);
		System.out.println("result = " + x );

		x = p2.solve(3,7,6, 2,0,4,1, System.out);
		System.out.println("result = " + x );


	}

}
