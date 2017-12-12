package sortomania;

import java.awt.Color;

public class JasonDavid{ //extends Contestants
	private int[] numbers;
    private int[] helper;

    private int number;
    public int count;
    public JasonDavid() {
    	count=0;
    }
	public static void main(String args[]) {
		JasonDavid hi = new JasonDavid();
		long num = simAvg();
		System.out.println(num+ " " + simSD(num)+" ms");
		System.out.println(hi.count);
	}
	
	public static long simAvg() {
		long num = 0;
		for (int i=0; i<200; i++) {
			JasonDavid hi = new JasonDavid();
			int[] array = rand();
			long startTime = System.nanoTime();
			double med = hi.sortAndGetMedian(array);
			long endTime = System.nanoTime();
			long duration = (endTime - startTime)/100000;
			num += duration;
		}
		return num/200;
	}
	public static long simSD(long avg) {
		long num =0;
		for (int i=0; i<200; i++) {
			JasonDavid hi = new JasonDavid();
			int[] array = rand();
			long startTime = System.nanoTime();
			double med = hi.sortAndGetMedian(array);
			long endTime = System.nanoTime();
			long duration = (endTime - startTime)/100000;
			num += Math.pow(duration-avg, 2);
		}
		return (long) Math.sqrt(num/201);
	}
	//@Override
	public Color getColor() {
		return new Color(124, 255, 124);
	}
	private static void printArray(int[] anArray) {
	      for (int i = 0; i < anArray.length; i++) {
	         if (i > 0) {
	            System.out.print(", ");
	         }
	         System.out.print(anArray[i]);
	      }
	   }
	//@Override
	public String getSpriteName() {
		return CHUN_LI;
	}
	public static int[] rand() {
		int[] array= new int[10000];
		for (int i=0; i<array.length; i++) {
			array[i] = randInt(0,9999);
		}
		return array;
	}
	
	public static int randInt(int min, int max) {
		return min + (int)(Math.random() * ((max - min) + 1));
	}
	//@Override
	public double sortAndGetMedian(int[] random) {
		quickSort(random,0,random.length-1);
		 if (random.length%2==0) {
			 int floor = (int)Math.floor(random.length/2)-1;
			 int ceiling = floor+1;
			 return (double)(random[floor]+random[ceiling])/2; 
		 }
		 else {
			 return random[random.length/2];
		 }
		
	}
	public boolean checkSort(int[] arr) {
		if(arr[0]<arr[1] && arr[1]<arr[2]&& arr[2]<arr[3]&& arr[4]<arr[5]) {
			return true;
		}
		return false;
	}
	int partition(int arr[], int low, int high)
    {
        int pivot = arr[randInt(low,high)]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
	/* The main function that implements QuickSort()
    arr[] --> Array to be sorted,
    low  --> Starting index,
    high  --> Ending index */
	 
	  public void quickSort(int arr[], int low, int high) {
		  if (low < high)
	      {
	          /* pi is partitioning index, arr[pi] is 
	            now at right place */
	          int pi = partition(arr, low, high);
	
	          // Recursively sort elements before
	          // partition and after partition
	          quickSort(arr, low, pi-1);
	          quickSort(arr, pi+1, high);
	      }
	  }
	  public void mSort(int[] values) {
	        this.numbers = values;
	        number = values.length;
	        this.helper = new int[number];
	        mergesort(0, number - 1);
	    }

	    private void mergesort(int low, int high) {
	        // check if low is smaller than high, if not then the array is sorted
	        if (low < high) {
	            // Get the index of the element which is in the middle
	            int middle = low + (high - low) / 2;
	            // Sort the left side of the array
	            mergesort(low, middle);
	            // Sort the right side of the array
	            mergesort(middle + 1, high);
	            // Combine them both
	            merge(low, middle, high);
	        }
	    }

	    private void merge(int low, int middle, int high) {

	        // Copy both parts into the helper array
	        for (int i = low; i <= high; i++) {
	            helper[i] = numbers[i];
	        }

	        int i = low;
	        int j = middle + 1;
	        int k = low;
	        // Copy the smallest values from either the left or the right side back
	        // to the original array
	        while (i <= middle && j <= high) {
	            if (helper[i] <= helper[j]) {
	                numbers[k] = helper[i];
	                i++;
	            } else {
	                numbers[k] = helper[j];
	                j++;
	            }
	            k++;
	        }
	        // Copy the rest of the left side of the array into the target array
	        while (i <= middle) {
	            numbers[k] = helper[i];
	            k++;
	            i++;
	        }
	        // Since we are sorting in-place any leftover elements from the right side
	        // are already at the right position.

	    }
	//@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

	//@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		mSort(mostlySorted);
		 if (mostlySorted.length%2==0) {
			 int floor = (int)Math.floor(mostlySorted.length/2)-1;
			 int ceiling = floor+1;
			 return (double)(mostlySorted[floor]+mostlySorted[ceiling])/2; 
		 }
		 else {
			 return mostlySorted[mostlySorted.length/2];
		 }
	}

	//@Override
	public double sortMultiDim(int[][] grid) {
		// TODO Auto-generated method stub
		return 0;
	}

	//@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

}
