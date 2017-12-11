package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class JessicaJi extends Contestant {

	public static void main(String[] args) {
		JessicaJi test = new JessicaJi();
		int[] arr = {4, 7, 10, 2, 8, 12, 100, 34, 42, 23, 40, 56, 31, 8};
		System.out.println("The median is: " + test.sortAndGetMedian(arr));
	//	System.out.println("And the sorted array is: \n" + Arrays.toString(insertionSort(arr)));
		System.out.println("And the sorted array is: \n" + Arrays.toString(mergeSort(arr, 0, arr.length - 1)));
	}
	public static int[] insertionSort(int[] arr) {
        for (int i=1; i<arr.length; i++)
        {
            int idx = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] > idx)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = idx;
        }
		return arr;
	}

	public static int[] mergeSort(int[] arr, int lower, int higher) {
		int[] tempMergArr = new int[arr.length];
		if (lower < higher) {
	            int middle = lower + (higher - lower) / 2;
	            // Below step sorts the left side of the array
	            mergeSort(arr, lower, middle);
	            // Below step sorts the right side of the array
	            mergeSort(arr, middle + 1, higher);
				//mergeParts(lowerIndex, middle, higherIndex);
	            
	            for (int i = lower; i <= higher; i++) {
		        tempMergArr[i] = arr[i];
		        }
		        int i = lower;
		        int j = middle + 1;
		        int k = lower;
		        while (i <= middle && j <= higher) {
		            if (tempMergArr[i] <= tempMergArr[j]) {
		                arr[k] = tempMergArr[i];
		                i++;
		            } else {
		                arr[k] = tempMergArr[j];
		                j++;
		            }
		            k++;
		        }
		        while (i <= middle) {
		            arr[k] = tempMergArr[i];
		            k++;
		            i++;
		        }
	        }
		return arr;
	
	}
	
	public static String[] mergeSortString(String[] arr) {
		// TODO Auto-generated method stub
		return arr;
	}
	public JessicaJi() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Color getColor() {
		return new Color(174, 198, 208);
	}

	@Override
	public String getSpriteName() {
		return RYU;
	}

	@Override
	public double sortAndGetMedian(int[] random) {
		random = mergeSort(random, 0, random.length - 1);
		if((random.length - 1)%2 == 0)
		{
			
		}
		
	}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		// TODO Auto-generated method stub
		return 0;
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
	
	@Override
	public String toString(){
		return "JessicaJi";
	}

}
