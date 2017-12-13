package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import sortomania.Contestant;

public class FahadDavidSorter extends Contestant {

	//Radix Sort
	//TimSort
	//recursive merge sort
	 public static void main (String[] args){
		 FahadDavidSorter test = new FahadDavidSorter();
		 int[] arr = {4,6,2,4,5};
		 System.out.println(mostlySortAndGetMedian(arr));
	   }
	
	public Color getColor() {
		return new Color(192,192,192);
	}

	public String getSpriteName() {
		return CAMMY;
	}

	public double sortAndGetMedian(int[] random) {
		radixSort(random);
		if(random.length %2 == 1) {
			return random[(random.length-1)/2];
		}
		else{
			int temp = (random.length)/2;
			double temp2 = (random[temp] + random[temp - 1]);
			return temp2/2;
		//	return ((random[(random.length-1)/2]) + (random[(random.length)/2]))/2;
		}
	}
	
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		insertionSort(strings);
		for(int i = 0; i < strings.length; i++) {
			if(strings[i] == toFind) {
				return i;
			}
		}
		return -1;
	}

	public double mostlySortAndGetMedian(int[] mostlySorted) {
		insertionSort(mostlySorted);
		if(mostlySorted.length %2 == 1) {
			return mostlySorted[(mostlySorted.length-1)/2];
		}
		else{
			int temp = (mostlySorted.length)/2;
			return (mostlySorted[temp] + mostlySorted[temp + 1])/2;
		}
	}

	public double sortMultiDim(int[][] grid) {
		 double[] temp = new double[grid.length];
		
		for(int i = 0; i < grid.length; i++) {
			temp[i] = sortAndGetMedian(grid[i]);
		}
		if(temp.length %2 == 1) {
			return temp[(temp.length-1)/2];
		}
		else{
			int temp2 = (temp.length)/2;
			double temp3 = (temp[temp2] + temp[temp2 - 1]);
			return temp3/2;
		//	return ((random[(random.length-1)/2]) + (random[(random.length)/2]))/2;
		}
	}

	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		insertionSort(arr);
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == toFind) {
				return i;
			}
		}
		return -1;
	}

	 public static void radixSort(int[] a) {
	        int i, m = a[0], exp = 1, n = a.length;
	        int[] b = new int[10];
	        for (i = 1; i < n; i++)
	            if (a[i] > m)
	                m = a[i];
	        
	        while (m / exp > 0)
	        {
	            int[] bucket = new int[10];
	 
	            for (i = 0; i < n; i++)
	                bucket[(a[i] / exp) % 10]++;
	            for (i = 1; i < 10; i++)
	                bucket[i] += bucket[i - 1];
	            for (i = n - 1; i >= 0; i--)
	                b[--bucket[(a[i] / exp) % 10]] = a[i];
	            for (i = 0; i < n; i++)
	                a[i] = b[i];
	            exp *= 10;        
	        }
	 } 
	 
	 public static int[] insertionSort(int[] input){
	        int temp;
	        for (int i = 1; i < input.length; i++) {
	            for(int j = i ; j > 0 ; j--){
	                if(input[j] < input[j-1]){
	                    temp = input[j];
	                    input[j] = input[j-1];
	                    input[j-1] = temp;
	                }
	            }
	        }
	        return input;
	}
	 
	 public static void insertionSort(String[] inputArray) {
		  for (int j = 1; j < inputArray.length; j++) { //the condition has changed
			    String key = inputArray[j];
			    int i = j - 1;
			    while (i >= 0) {
			      if (key.compareTo(inputArray[i]) > 0) {//here too
			        break;
			      }
			      inputArray[i + 1] = inputArray[i];
			      i--;
			    }
			    inputArray[i + 1] = key;
			  }
	 }
}