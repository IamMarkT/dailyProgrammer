// Mark Trinidad
// Completed 5/23/19

// [2019-05-20] Challenge #378 [Easy] The Havel-Hakimi algorithm for graph realization
// COMPLETE

import java.util.*;

public class havelHakimi
{
	// Warmup 1: Eliminating 0s & Warmup 2: Descending sort
	// Using Counting Sort : O(m + n)
	public static int[] noZeroDesSort(int [] oriArr)
	{
		int max = getMax(oriArr);
		int[] freq = new int[max + 1];
		LinkedList<Integer> desList = new LinkedList<Integer>();

		// O(n): n being number of elements in oriArr
		for (int i = 0; i < oriArr.length; i++)
			freq[oriArr[i]]++;

		// O(m): m being length of freq
		for (int i = max; i > 0; i--)
		{
			if (freq[i] > 0)
			{
				while(freq[i] > 0)
				{
					desList.add(i);
					freq[i]--;
				}

			}
		}
		// Convert linkedList to array
		return toIntArray(desList);
	}

	// Warmup 3: Length check
	// O(1)
	public static boolean lengthCheck(int n, int[] array)
	{
		return n > array.length ? true : false;
	}

	// Warmup 4: Front Elimination
	// O(n)
	public static int[] frontElim(int n, int[] desArr)
	{
		for(int i = 0; i < n; i++)
			desArr[i]--;
		
		return desArr;
	}

	// Main function call for havelHakimi
	public static boolean havelHakimi(int[] oriArr)
	{
		int[] stepOne, stepFour;
		int max;
		

		// Step 1 & 3
		stepOne = noZeroDesSort(oriArr);
		// Step 2
		if (stepOne.length == 0)
			return true;

		// Step 4
		max = stepOne[0];
		stepFour = Arrays.copyOfRange(stepOne, 1, stepOne.length);

		// Step 5
		if (lengthCheck(max, stepFour))
			return false;

		// Step 6
		stepFour = frontElim(max, stepFour);

		// Recursive call until true or false is returned
		return havelHakimi(stepFour);

	}

	// O(n): Get max value from an array
	public static int getMax(int[] array)
	{
		int max = array[0];

		for (int i = 1; i < array.length; i++) 
		{
			if (array[i] > max)
				max = array[i];
		}

		return max;
	}

	// O(n): Change List to int Array
	public static int[] toIntArray(List<Integer> list)
	{
		int[] arr = new int[list.size()];

 		for(int i = 0; i < arr.length; i++)
  			arr[i] = list.get(i);

  		return arr;
	}
}
