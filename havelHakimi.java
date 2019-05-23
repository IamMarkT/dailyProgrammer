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
		stepFour = Arrays.copyOfRange(stepOne, 1, stepOne.length - 1);

		// Step 5
		if (lengthCheck(max, stepFour))
			return false;

		// Step 6
		stepFour = frontElim(max, stepFour);

		// Recursive call until true or false is returned
		return havelHakimi(stepFour);

	}

	// O(n): Function to get Max Value
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

	// O(n): Function to print value in array. Just to check work.
	public static void printArray(int[] array)
	{
    	System.out.println("Array Elements:");
    	for (int i = 0; i < array.length; i++)
    	   System.out.println(array[i]);
	}

	public static int[] toIntArray(List<Integer> list)
	{
		int[] arr = new int[list.size()];
 		for(int i = 0; i < arr.length; i++)
  			arr[i] = list.get(i);
  		return arr;
	}

	public static void main(String [] args)
	{
		int[] array1 = {5, 3, 0, 2, 6, 2, 0, 7, 2, 5};
		int[] array3_t = {1, 1};
		int[] array3_f = {6, 5, 5, 3, 2, 2, 2};
		int[] array4_1 = {5, 4, 3, 2, 1};
		int[] array4_2 = {14, 13, 13, 13, 12, 10,
							8, 8, 7, 7, 6, 6, 4, 4, 2};



		// Test Warmup 1/2
		printArray(noZeroDesSort(array1));
		// 7, 6, 5, 5, 3, 2, 2, 2


		// Test Warmup 3
		if(lengthCheck(3, array3_t))
			System.out.println("W3t-TRUE");
		else
			System.out.println("W3t-FALSE");
		// W3t-TRUE

		if(lengthCheck(7, array3_f))
			System.out.println("W3f-TRUE");
		else
			System.out.println("W3f-FALSE");
		// W3f-FALSE


		// Test Warmup 4
		printArray(frontElim(4, array4_1));
		// 4, 3, 2, 1, 1
		printArray(frontElim(11, array4_2));
		// 13, 12, 12, 12, 11, 9, 7, 7, 6, 6, 5, 6, 4, 4, 2


/*
		if(havelHakimi(array))
			System.out.println("TRUUU");
		else
			System.out.println("FALSEE");*/
	}

}
