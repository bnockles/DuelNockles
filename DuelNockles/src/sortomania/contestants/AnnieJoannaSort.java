package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class AnnieJoannaSort extends Contestant {

	public static void main(String[] args){
		AnnieJoannaSort test = new AnnieJoannaSort();
		int[] arr = {2, 2, 4, 7, 9, 8, 10, 12, 18, 23, 31, 34, 40, 42, 56};
		System.out.println("The median is: " + test.mostlySortAndGetMedian(arr));
		System.out.println("And the sorted array is: \n" + Arrays.toString(arr));
		String[] arrS = {"cat", "dog", "hi", "boy", "girl", "apple juice", "bee", "cathair", "cat hair"};
		System.out.println("The index is: " + test.sortAndGetResultingIndexOf(arrS, "cat"));
		System.out.println("And the sorted array is: \n" + Arrays.toString(arrS));
		int[][] arrD = {{2, 4, 3}, {3, 5, 2}, {7, 2, 1, 2},};
		System.out.println("The median of medians is: " + test.sortMultiDim(arrD));
		String twoD = "[";
		for(int i = 0; i < arrD.length - 1; i++)
			twoD += Arrays.toString(arrD[i]) + ", ";
		twoD += Arrays.toString(arrD[arrD.length - 1]) + "]";
		System.out.println("And the sorted array is: \n" + twoD);
		
	}
	
	@Override
	public Color getColor() {
		return new Color(211, 233, 248);
	}

	@Override
	public String getSpriteName() {
		return CHUN_LI ;
	}

	@Override
	public double sortAndGetMedian(int[] random) {
		doMergeSort(random, 0, random.length -1);
		return getMedian(random);
	}
	
	
    public void doMergeSort(int[] arr, int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(arr, lowerIndex, middle);
            doMergeSort(arr, middle + 1, higherIndex);
            mergeParts(arr, lowerIndex, middle, higherIndex);
        }
    }
 
    public void mergeParts(int[] arr, int lowerIndex, int middle, int higherIndex) {
    	int[] tempMergArr = new int[arr.length];
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = arr[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
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

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		String temp;
		for (int i = 0; i < strings.length; i++) 
        {
            for (int j = i + 1; j < strings.length; j++) 
            {
                if (strings[i].compareTo(strings[j])>0) 
                {
                    temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
            }
        }
        return findIndex(strings,toFind);
	}
	

	private int findIndex(String[] strings, String toFind) {
		for(int i = 0; i < strings.length; i++) {
			if(strings[i].equals(toFind))
				return i;
		}
		return -1;
	}


	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		doInsertionSort(mostlySorted);
		return getMedian(mostlySorted);
	}
	
	public int[] doInsertionSort(int[] input){
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

	@Override
	public double sortMultiDim(int[][] grid) {
		double[] medians = new double[grid.length];
		for(int i = 0; i < grid.length; i++)
			medians[i] = sortAndGetMedian(grid[i]);
		return sortAndGetMedian(medians);
	}
	
	public double sortAndGetMedian(double[] random) {
		doMergeSort(random, 0, random.length -1);
		return getMedian(random);
	}
	
	public void doMergeSort(double[] arr, int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(arr, lowerIndex, middle);
            doMergeSort(arr, middle + 1, higherIndex);
            mergeParts(arr, lowerIndex, middle, higherIndex);
        }
    }
 
    public void mergeParts(double[] arr, int lowerIndex, int middle, int higherIndex) {
    	double[] tempMergArr = new double[arr.length];
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = arr[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
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

    public double getMedian(double[] sorted) {
		double median;
		if (sorted.length % 2 == 0)
		    median = ((double)sorted[sorted.length/2] + (double)sorted[sorted.length/2 - 1])/2;
		else
		    median = (double) sorted[sorted.length/2];
		return median;
	}

	@Override
	
		public int sortAndSearch(Comparable[] arr, Comparable toFind) {
			for (int i = 0; i<arr.length; i++) {
	            for (int j = i+1; j < arr.length; j++) {
	                if (arr[i].compareTo(arr[j])>0) {
	                    Comparable t = arr[i]; arr[i] = arr[j]; arr[j] = t;
	                }
	            }
	        }
			findMed(toFind);
	    }
	}
	
	private void findMed(Comparable toFind) {
		// TODO Auto-generated method stub
		
	}

	public double getMedian(int[] sorted) {
		double median;
		if (sorted.length % 2 == 0)
		    median = ((double)sorted[sorted.length/2] + (double)sorted[sorted.length/2 - 1])/2;
		else
		    median = (double) sorted[sorted.length/2];
		return median;
	}
	
}
