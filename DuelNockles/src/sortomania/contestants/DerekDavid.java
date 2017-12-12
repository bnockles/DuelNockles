package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class DerekDavid extends Contestant {
	
	private String [] a;
	
	public static void main(String[] args) {
		

		//TASK 1 ARRAY
		DerekDavid test = new DerekDavid();
		int[] arr = {4, 7,10, 2,18,12, 34, 42, 23, 40, 56, 31, 8};
		

		//TASK 2 ARRAY
		String[] a = {"X","E","C","A"};

		//TASK 3 ARRAY
		int [] array = new int[100];    // Almost sorted Array of 100
		array[0] = (int)(Math.random () * 10) + 1;
		for (int i = 1; i < array.length; i++) {
		  array[i] = array[i-1] + (int)(Math.random() * 12) - 2;
		}
		
		
		//TASK 1
		System.out.println("The median is: " + test.sortAndGetMedian(arr));
		System.out.println("And the sorted array is: \n");
		printArray(arr);
		
		//TASK 3
		System.out.println("The median of the mostly sorted array is: " + test.mostlySortAndGetMedian(array));
		System.out.println("The mostly sorted array \n");
		printArray(array);
		
		
		
		
		//TASK 2
		
		// prints the given array
		
		
		
		test.sortquick();
		
		System.out.println("");
		
		//prints the sorted array
		printArrayS();
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
		
		quickSort(0,strings.length);
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

	public int[] heapSort(int arr[]) {
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

	void heapify(int arr[], int n, int i) {
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

	
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	
	
	
	

	 

	
	// This method sort an array internally and internally calls quickSort 
		public void sortquick(){
			int left = 0;
			int right = a.length-1;
				
			quickSort(left, right);
		}
		
		// This method is used to sort the array using quicksort algorithm.
		// It takes left and the right end of the array as two cursors
		private void quickSort(int left,int right){
			
			// If both cursor scanned the complete array quicksort exits
			if(left >= right)
				return;
			
			// Pivot using median of 3 approach
			String pivot = getMedian(left, right);
			int partition = partition(left, right, pivot);
			
			// Recursively, calls the quicksort with the different left and right parameters of the sub-array
			quickSort(0, partition-1);
			quickSort(partition+1, right);
		}
		
		// This method is used to partition the given array and returns the integer which points to the sorted pivot index
		private int partition(int left,int right,String pivot){
			int leftCursor = left-1;
			int rightCursor = right;
			while(leftCursor < rightCursor){
			while(((Comparable<String>)a[++leftCursor]).compareTo(pivot) < 0);
	        while(rightCursor > 0 && ((Comparable<String>)a[--rightCursor]).compareTo(pivot) > 0);
				if(leftCursor >= rightCursor){
					break;
				}else{
					swap(leftCursor, rightCursor);
				}
			}
			swap(leftCursor, right);
			return leftCursor;
		}
		
		public String getMedian(int left,int right){
			int center = (left+right)/2;
			
			if(((Comparable<String>)a[left]).compareTo(a[center]) > 0)
				swap(left,center);
			
			if(((Comparable<String>)a[left]).compareTo(a[right]) > 0)
				swap(left, right);
			
			if(((Comparable<String>)a[center]).compareTo(a[right]) > 0)
				swap(center, right);
			
			swap(center, right);
			return a[right];
		}
		
		// This method is used to swap the values between the two given index
		public void swap(int left,int right){
			String temp = a[left];
			a[left] = a[right];
			a[right] = temp;
		}
		
		public void printArrayS(){
			for(String i : a){
				System.out.print(i+" ");
			}
		}
	
	

	public int[] insertionSort(int arr[]) {
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
