package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class AnnieJoannaSort extends Contestant {

	public static void main(String[] args){
		AnnieJoannaSort test = new AnnieJoannaSort();
		int[] arr = {4, 7, 10, 18, 12, 34, 42, 23, 40, 56, 31, 8};
		System.out.println("The median is: " + test.sortAndGetMedian(arr));
		System.out.println("And the sorted array is: \n" + Arrays.toString(arr));
	}
	
	public AnnieJoannaSort() {
		// TODO Auto-generated constructor stub
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
      
        for (int i = 0; i < strings.length - 1; i++) 
        {
            System.out.print(strings[i] + ",");
        }
        System.out.print(strings[n - 1]);
		
        findIndex(strings,toFind);
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
		return 0;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public double getMedian(int[] sorted) {
		int half = sorted.length / 2;
		if(sorted.length % 2 == 0)
			return (double)((sorted[half] + sorted[half - 1]) / 2);
		else
			return sorted[half];
	}

}
