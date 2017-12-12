package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class VickieAreej extends Contestant{

	public VickieAreej() {
	}

	public static void main(String[] args) {
		int[] arr = {4, 7,10, 2,18,12, 34, 42, 23, 40, 56, 31, 8, 56,234,56,35,234,67};
		heapSort(arr);
		//bubbleSort(arr);
		System.out.print(Arrays.toString(arr));
		//System.out.println("The median is: " + sortAndGetMedian(arr));
		//System.out.println("And the sorted array is: \n" + arr);
    }  

	@Override
	public Color getColor() {
		 return new Color(218,112,214);
	}

	@Override
	public String getSpriteName() {
		return FEI_LONG;
	}

		public static void heapSort(int arr[])
	    {
	        int n = arr.length;
	 
	        // Build heap (rearrange array)
	        for (int i = n / 2 - 1; i >= 0; i--)
	            heapify(arr, n, i);
	 
	        // One by one extract an element from heap
	        for (int i=n-1; i>=0; i--)
	        {
	            // Move current root to end
	            int temp = arr[0];
	            arr[0] = arr[i];
	            arr[i] = temp;
	 
	            // call max heapify on the reduced heap
	            heapify(arr, i, 0);
	        }
	        //return arr;
	    }
	 
	    // To heapify a subtree rooted with node i which is
	    // an index in arr[]. n is size of heap
	    static void heapify(int arr[], int n, int i)
	    {
	        int largest = i;  // Initialize largest as root
	        int l = 2*i + 1;  // left = 2*i + 1
	        int r = 2*i + 2;  // right = 2*i + 2
	 
	        // If left child is larger than root
	        if (l < n && arr[l] > arr[largest])
	            largest = l;
	 
	        // If right child is larger than largest so far
	        if (r < n && arr[r] > arr[largest])
	            largest = r;
	 
	        // If largest is not root
	        if (largest != i)
	        {
	            int swap = arr[i];
	            arr[i] = arr[largest];
	            arr[largest] = swap;
	 
	            // Recursively heapify the affected sub-tree
	            heapify(arr, n, largest);
	        }
	    }
	 
	    /* A utility function to print array of size n */
	    static void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i]+" ");
	        System.out.println();
	    }
 
    // Driver program
	public double sortAndGetMedian(int[] random) {
		//heap sort
		heapSort(random);
		//get median
		double median = random[random.length/2];
		return median;
	}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

			public static  int[] bubbleSort(int[] mostlySorted) {
				int n = mostlySorted.length;  
		        int temp = 0;  
		         for(int i=0; i < n; i++){  
		                 for(int j=1; j < (n-i); j++){  
		                          if(mostlySorted[j-1] > mostlySorted[j]){  
		                                 //swap elements  
		                                 temp = mostlySorted[j-1];  
		                                 mostlySorted[j-1] = mostlySorted[j];  
		                                 mostlySorted[j] = temp;  
		                         }  
		                          
		                 }  
		         }
		         return mostlySorted;
			}
	
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		//bubble sort
		bubbleSort(mostlySorted);
		//get median
		int median = mostlySorted[mostlySorted.length/2];
		return median;
	}

	@Override
	public double sortMultiDim(int[][] grid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		// TODO Auto-generated method stub
		return 0;
	}
	public String toString() {
		return null;
		
	}

}
