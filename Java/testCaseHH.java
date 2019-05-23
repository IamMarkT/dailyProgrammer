// Mark Trinidad
// havelHakimi: testCaseHH.java

// Testcases to see if warmups and main havelHakimi() work

import java.util.*;

public class testCaseHH
{

	public static void main(String [] args)
	{
		int[] array1 = {5, 3, 0, 2, 6, 2, 0, 7, 2, 5};
		int[] array3_t = {1, 1};
		int[] array3_f = {6, 5, 5, 3, 2, 2, 2};
		int[] array4_1 = {5, 4, 3, 2, 1};
		int[] array4_2 = {14, 13, 13, 13, 12, 10,
							8, 8, 7, 7, 6, 6, 4, 4, 2};
		int[] array = {4, 2, 0, 1, 5, 0};


		// Test Warmup 1/2
		printArray(havelHakimi.noZeroDesSort(array1));
		// 7, 6, 5, 5, 3, 2, 2, 2


		// Test Warmup 3
		if(havelHakimi.lengthCheck(3, array3_t))
			System.out.println("W3t-TRUE");
		else
			System.out.println("W3t-FALSE");
		// W3t-TRUE

		if(havelHakimi.lengthCheck(7, array3_f))
			System.out.println("W3f-TRUE");
		else
			System.out.println("W3f-FALSE");
		// W3f-FALSE


		// Test Warmup 4
		printArray(havelHakimi.frontElim(4, array4_1));
		// 4, 3, 2, 1, 1
		printArray(havelHakimi.frontElim(11, array4_2));
		// 13, 12, 12, 12, 11, 9, 7, 7, 6, 6, 5, 6, 4, 4, 2


		if(havelHakimi.havelHakimi(array))
			System.out.println("TRUE");
		else
			System.out.println("FALSE");
		// FALSE
	}

	// O(n): Function to print value in array. Just to check work.
	private static void printArray(int[] array)
	{
    	System.out.println("Array Elements:");
    	for (int i = 0; i < array.length; i++)
    	   System.out.println(array[i]);
	}
}