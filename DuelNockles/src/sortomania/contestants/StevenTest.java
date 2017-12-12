package sortomania.contestants;

import java.util.Arrays;

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
	public static void main(String[] args) {
		StevenTest a=new StevenTest();
		a.makeNums();
		long avg = 0;
		for (int i = 0; i < 200; i++)
		{
		long startTime = System.nanoTime();
		
		System.out.println(sortAndGetMedian(getNumbers()));
		
		long endTime = System.nanoTime();
		long b = endTime - startTime;
		avg += b;
		a.makeNums();
		}
		avg = avg/200;
		System.out.println("That took " + avg + " nanoTime");
	//	System.out.print(a.getNumbers().toString());

	//	System.out.println(Arrays.toString(getNumbers()));
		
		
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
    public static void sort(int[] a, int low, int high) 
    {
        int N = high - low;         
        if (N <= 1) 
            return; 
        int mid = low + N/2; 
        // recursively sort 
        sort(a, low, mid); 
        sort(a, mid, high); 
        // merge two sorted subarrays
        int[] temp = new int[N];
        int i = low, j = mid;
        for (int k = 0; k < N; k++) 
        {
            if (i == mid)  
                temp[k] = a[j++];
            else if (j == high) 
                temp[k] = a[i++];
            else if (a[j]<a[i]) 
                temp[k] = a[j++];
            else 
                temp[k] = a[i++];
        }    
        for (int k = 0; k < N; k++) 
            a[low + k] = temp[k];         
    }
    /************************************************************************************************************************/
    
    // Test Methods
    public static double sortAndGetMedian(int[] random) {
    	sort(random);
    	
    	return (random[4999]+random[5000])/2;
	}
}


