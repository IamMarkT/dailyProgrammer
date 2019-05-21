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
		int[] main;
		int max;
		int[] newMain;

		// Step 1 & 3
		main = noZeroDesSort(oriArr);
		// Step 2
		if (main.length == 0)
			return true;

		// Step 4
		max = main[0];
		newMain = Arrays.copyOfRange(main, 1, main.length - 1);

		// Step 5
		if (lengthCheck(max, newMain))
			return false;

		// Step 6
		newMain = frontElim(max, newMain);

		// Recursive call until true or false is returned
		return havelHakimi(newMain);

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
		int[] array1 = {16, 9, 9, 15, 9, 7, 9, 11, 17, 11, 4, 9, 12, 14, 14, 12, 17, 0, 3, 16};
		if(havelHakimi(array1))
			System.out.println("TRUUU");
		else
			System.out.println("FALSEE");
	}

}
