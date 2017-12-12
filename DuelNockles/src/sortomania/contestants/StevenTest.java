package sortomania.contestants;

import java.util.Arrays;
import java.util.Random;

public class StevenTest {
	
	static int[] numbers=new int[10000];
	private static int number;
	
	public static int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public StevenTest() {
		
	}

	public void makeNums()
	{
		for(int i=0;i<numbers.length;i++) {
			numbers[i]=(int)(Math.random()*10000);
		}
	}
	
	/************************************************************************************************************************/
	
	public static String[] generateRandomWords(int numberOfWords)
	{
	    String[] randomStrings = new String[numberOfWords];
	    Random random = new Random();
	    for(int i = 0; i < numberOfWords; i++)
	    {
	        char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
	        for(int j = 0; j < word.length; j++)
	        {
	            word[j] = (char)('a' + random.nextInt(26));
	        }
	        randomStrings[i] = new String(word);
	    }
	    return randomStrings;
	}
	
	/************************************************************************************************************************/
	
	public static void main(String[] args) {
		
		String[] strings = generateRandomWords(10000);
		StevenTest a=new StevenTest();
		a.makeNums();
		long avg = 0;
		for (int i = 0; i < 200; i++)
		{
			long startTime = System.nanoTime();
			
			sortAndGetMedian(getNumbers());	
			sortAndGetResultingIndexOf(strings , "adj");
			mostlySortAndGetMedian(getNumbers());
			
		long endTime = System.nanoTime();
		long b = endTime - startTime;
		avg += b;
		a.makeNums();
		}
		avg = avg/200;
		System.out.println("That took " + avg + " nanoTime");

		System.out.println(sortAndGetMedian(getNumbers()));	
		System.out.println(sortAndGetResultingIndexOf(strings , "adj"));
		System.out.println(Arrays.toString(strings));
		System.out.println(mostlySortAndGetMedian(getNumbers()));
		
		
	}
	
	/************************************************************************************************************************/
	public static void sort(int[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            return;
        }
        numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }

    private static void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private static void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    
    /************************************************************************************************************************/
    // Merge Sort
    public static void mergeSort(String[] a) {
        if (a.length >= 2) {
            String[] left = new String[a.length / 2];
            String[] right = new String[a.length-a.length / 2];

            for (int i = 0; i < left.length; i++)
            {
                left[i] = a[i];
            }
            for (int i = 0; i < right.length; i++)
            {
                right[i] = a[i + a.length / 2];
            }

            mergeSort(left);
            mergeSort(right);

            merge(a, left, right);
        }
    }

    public static void merge(String[] result, String[] left, String[] right) {
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < result.length; i++) {
        	 if (i2 >= right.length || (i1 < left.length &&
                     left[i1].compareToIgnoreCase(right[i2])<0)) {
                      result[i] = left[i1];
                      i1++;
                 } else {
                      result[i] = right[i2];
                      i2++;
                 }
            }
    }
    /************************************************************************************************************************/
    
    // Test Methods
    public static double sortAndGetMedian(int[] random) {
    	sort(random);
    	
    	return (random[4999]+random[5000])/2;
	}
    
	public static int sortAndGetResultingIndexOf(String[] strings, String toFind)
	{
		mergeSort(strings);
		
		for (int i = 0; i < strings.length; i++)
		{
			if (strings[i].equals(toFind))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public static double mostlySortAndGetMedian(int[] mostlySorted)
	{
		for (int i = 0; i < mostlySorted.length; i++)
		{
			
			if (i+1 < mostlySorted.length)
			{
				if (mostlySorted[i+1] < mostlySorted[i])
				{
					sort(mostlySorted);
					return (mostlySorted[4999]+mostlySorted[5000])/2;
				}
			}
			else
			{
				return (mostlySorted[4999]+mostlySorted[5000])/2;
			}
		}
		return -1;
	}
}
//

