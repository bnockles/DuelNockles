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
	
	public static String[] insertionSortString(String[] arr) {
		int i,j;
		  String idx;
		  for (j = 1; j < arr.length; j++) {
			  idx = arr[j];
		    i = j - 1;
		    while (i >= 0) {
		      if (idx.compareTo(arr[i]) > 0) {
		        break;
		      }
		      arr[i + 1] = arr[i];
		      i--;
		    }
		    arr[i + 1] = idx;
		  }		
		  return arr;
	}
	
	public static String[] mergeSortString(String[] arr) {
        if (arr.length >= 2) {
            String[] left = new String[arr.length / 2];
            String[] right = new String[arr.length-arr.length / 2];

            for (int i = 0; i < left.length; i++)
            {
                left[i] = arr[i];
            }
            for (int i = 0; i < right.length; i++)
            {
                right[i] = arr[i + arr.length / 2];
            }

            mergeSortString(left);
            mergeSortString(right);

            merge(arr, left, right);
        }
        return arr;
    }
	//helper method for mergeSortString
	 public static void merge(String[] result, String[] left, String[] right) {
	        int i1 = 0;
	        int i2 = 0;
	        for (int i = 0; i < result.length; i++) {
	            if (i2 >= right.length || (i1 < left.length &&
	                                 left[i1].compareToIgnoreCase(right[i2])<0)) {
	                      result[i] = left[i1];
	                      i1++;
	                 } else {
	                      result[i] = right[i2];
	                      i2++;
	                 }
	            }
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
		return getMedian(random);
	}

	
	public double getMedian(int[] x)	
	{
		double median;
		if (x.length % 2 == 0)//even 
		{
		    median = ((double)x[x.length/2] + (double)x[x.length/2 - 1])/2; //two numbers in middle adding then dividng by 2
		}
		else //odd
		{
		    median = (double) x[x.length/2];
		}//middle num
		
		return median;
	}
	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		mostlySorted = insertionSort(mostlySorted);
		return getMedian(mostlySorted);
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
