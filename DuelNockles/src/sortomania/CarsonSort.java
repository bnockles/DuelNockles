package sortomania;

import java.awt.Color;
import java.util.Arrays;

public class CarsonSort extends Contestant{

	private static int array[];
	private int length;

	public static void main(String a[]){
		CarsonSort test = new CarsonSort();
		int[] input = {24,2,45,20,56,75,2,56,99,53,12,1};
		CarsonSort.quickSort(input, 0, input.length - 1);
		System.out.println("The median is: " + test.sortAndGetMedian(input));
		for(int i:input){
            System.out.print(i);
            System.out.print(" ");
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
		else
		return random[(int)random.length /2];
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
		    int m = arr.length;
		       for (int l=0; l<m; ++l)
		    	   System.out.print(arr[i] + " ");
		 
		        System.out.println();
		}
	}

	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		insertSort(mostlySorted);
		if(mostlySorted.length % 2 == 0) {
			return (mostlySorted[(int)mostlySorted.length /2]+mostlySorted[((int)mostlySorted.length /2)+1])/2;
		}
		return mostlySorted[(int)mostlySorted.length /2];
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
	
	public void quickSort(String[] strArr, int lowerIndex, int higherIndex) {
		
		if (strArr == null || strArr.length == 0) {
			return;
		}

		int i = lowerIndex;
		int j = higherIndex;
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
		// Divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which 
			 * is greater then the pivot value, and also we will identify a number 
			 * from right side which is less then the pivot value. Once the search 
			 * is done, then we exchange both numbers.
			 */
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(strArr, i, j);
				//move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (lowerIndex < j)
			quickSort(strArr, lowerIndex, j);
		if (i < higherIndex)
			quickSort(strArr, i, higherIndex);
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

