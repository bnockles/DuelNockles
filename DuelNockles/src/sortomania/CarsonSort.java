package sortomania;

import java.awt.Color;
import java.util.Arrays;

public class CarsonSort extends Contestant{

	public static void main(String a[]){
		CarsonSort test = new CarsonSort();
		int[][] input = {{4,2,5,1,3}, {3,7,6,4,7}, {6,5,3,1,6}, {4,8,1,2,6}};
		System.out.println(test.sortMultiDim(input));
		
		for(int i = 0; i < input.length; i ++) {
			for(int j = 0; j < input[i].length; j++) {
				System.out.println(input[i][j] + " ");
			}
		}
	}

	public Color getColor() {
		return new Color(123,123,123);
	}
//1,2,3,4 2+3/2 
	public String getSpriteName() {
		return "CarsonTylerSprite";
	}

	public double sortAndGetMedian(int[] random) {
		quickSort(random, 0, random.length-1);
		if(random.length % 2 == 0) {
			return (random[(int)random.length /2]+random[((int)random.length /2)+1])/2;
		}
		else {
			return random[(int)random.length /2];
		}
		//System.out.println(Arrays.toString(random));

	}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		return 0;
	}
	void insertSort(int arr[])
	{
		      int n = arr.length;
		        for (int i=1; i<n; ++i)
		        {
		            int key = arr[i];
		            int j = i-1;
		 
		            /* Move elements of arr[0..i-1], that are
		               greater than key, to one position ahead
		               of their current position */
		            while (j>=0 && arr[j] > key)
		            {
		                arr[j+1] = arr[j];
		                j = j-1;
		            }
		            arr[j+1] = key;
		        }
	}

	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		insertSort(mostlySorted);
	    printArray(mostlySorted);
		if(mostlySorted.length % 2 == 0) {
			return (mostlySorted[(int)mostlySorted.length /2]+mostlySorted[((int)mostlySorted.length /2)+1])/2;
		}
		return mostlySorted[(int)mostlySorted.length /2];
	}

	@Override
	public double sortMultiDim(int[][] grid) {
		int[] arr = new int[grid.length];
		for(int i = 0; i < grid.length; i ++) {
			arr[i] = (int) sortAndGetMedian(grid[i]);
		}
		return sortAndGetMedian(arr);
	}

	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void quickSort(int[] intArr, int lowerIndex, int higherIndex) {
		
		if (intArr == null || intArr.length == 0) {
			return;
		}

		int i = lowerIndex;
		int j = higherIndex;
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = intArr[lowerIndex+(higherIndex-lowerIndex)/2];
		// Divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which 
			 * is greater then the pivot value, and also we will identify a number 
			 * from right side which is less then the pivot value. Once the search 
			 * is done, then we exchange both numbers.
			 */
			while (intArr[i] < pivot) {
				i++;
			}
			while (intArr[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(intArr, i, j);
				//move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (lowerIndex < j)
			quickSort(intArr, lowerIndex, j);
		if (i < higherIndex)
			quickSort(intArr, i, higherIndex);
	}
	
	static void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i] + " ");
	 
	        System.out.println();
	    }

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	private static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

