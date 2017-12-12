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
	 public static void main (String[] args)
	    {
		 FahadDavidSorter test = new FahadDavidSorter();
		 int[][] arr = {{3,2,1},{4,3,5}};
		 System.out.println("The median is: " + test.sortMultiDim(arr));
		 for(int i = 0; i < arr.length;i++) {
			 System.out.println("An array is: " + Arrays.toString(arr[i]));
		 }
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
		
		for(int i = 0; i < strings.length; i++) {
			if(strings[i] == toFind) {
				return i;
			}
		}
		return -1;
	}

	public double mostlySortAndGetMedian(int[] mostlySorted) {
		
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
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == toFind) {
				return i;
			}
		}
		return -1;
	}

	 public static void radixSort(int[] a)
	    {
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
}