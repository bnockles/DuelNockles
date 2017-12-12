package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class DerekDavid extends Contestant {
	
	
	
	public static void main(String[] args) {
		
		//TASK 1 ARRAY
		DerekDavid test = new DerekDavid();
		int[] arr = {4,7,10, 2,18,12, 34, 42, 23, 40, 56, 31, 8};
		
		//TASK 3 ARRAY
		int [] array = new int[100];    // Almost sorted Array of 100
		array[0] = (int)(Math.random () * 10) + 1;
		for (int i = 1; i < array.length; i++) {
		  array[i] = array[i-1] + (int)(Math.random() * 12) - 2;
		}
		
		
		//TASK 1
		System.out.println("The median is: " + test.sortAndGetMedian(arr));
		System.out.println("And the sorted array is: \n"+Arrays.toString(heapSort(arr)));
		
		
		//TASK 3
		System.out.println("The median of the mostly sorted array is: " + test.mostlySortAndGetMedian(array));
		System.out.println("The mostly sorted array \n"+Arrays.toString(insertionSort(array)));
		
		
		
		
		
		
}
	@Override
	public Color getColor() {
		return new Color(104, 152, 225);
	}

	@Override
	public String getSpriteName() {
		return RYU;
	}

	public double sortAndGetMedian(int[] random) {
		
		int[] numArray = heapSort(random);
		
		double median;
		if (numArray.length % 2 == 0)
			median = ((double) numArray[numArray.length / 2] + (double) numArray[numArray.length / 2 - 1]) / 2;
		else
			median = (double) numArray[numArray.length / 2];
		return median;
	}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		
		Quicksort(strings);
		return Arrays.asList(strings).indexOf(toFind);
	}

	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		int [] numArray = insertionSort(mostlySorted);
		
		double median;
		if (numArray.length % 2 == 0)
			median = ((double) numArray[numArray.length / 2] + (double) numArray[numArray.length / 2 - 1]) / 2;
		else
			median = (double) numArray[numArray.length / 2];
		return median;
	}

	@Override
	public double sortMultiDim(int[][] grid) {
		
		return 0;
	}

	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		return 0;
	}

	
	//TASK ONE HEAP SORT
	public static int[] heapSort(int arr[]) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);
		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
		return arr;
	}

	//TASK ONE HEAP SORT
	static void heapify(int arr[], int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2
		if (l < n && arr[l] > arr[largest])
			largest = l;
		if (r < n && arr[r] > arr[largest])
			largest = r;
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			heapify(arr, n, largest);
		}
	}

	 
	 
	    public void Quicksort(String[] stringArray, int idx1, int idx2) {
	        if (idx1 >= idx2) {
	            
	            return;
	        }
	        int pivotIndex = partition(stringArray, idx1, idx2);
	        Quicksort(stringArray, idx1, pivotIndex);
	        Quicksort(stringArray, pivotIndex+1, idx2);
	     }
	    
	    public int partition(String[] stringArray, int idx1, int idx2) {
		 	String pivotValue = stringArray[idx1];
	        while (idx1 < idx2) {
	           String value1;
	           String value2;
	           while ((value1 = stringArray[idx1]).compareTo( pivotValue ) < 0) {
	               idx1 = idx1 + 1;
	           }
	           while ((value2 = stringArray[idx2]).compareTo( pivotValue ) > 0) {
	               idx2 = idx2 - 1;
	           }
	           stringArray[idx1] = value2;
	           stringArray[idx2] = value1;
	        }
	        return idx1;
	    }
	    
	    
	    
	    public void Quicksort(String[] stringArray) {
	        Quicksort(stringArray, 0, stringArray.length - 1);
	    }
	    
	
	public static int[] insertionSort(int arr[]) {
		double n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}

		return arr;
	}


}
