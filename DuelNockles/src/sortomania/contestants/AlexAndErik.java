package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class AlexAndErik extends Contestant {

	private int[] array;
    private int[] tempMergArr;
    private int length;
    
	public AlexAndErik() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		AlexAndErik test = new AlexAndErik();
		int[] array = {2,2,3,4,5};
		System.out.println("The median is " + test.sortAndGetMedian(array) + " .");
		System.out.println("And the sorted array is: \n" + Arrays.toString(array));
		
		
		int[] arr = {4, 7,10, 2,18,12, 34, 42, 23, 40, 56, 31, 8,9};
		System.out.println("The median is: " + test.sortAndGetMedian(arr));
		System.out.println("And the sorted array is: \n" + Arrays.toString(arr));
		
		int[] arr1 = {11,20,21,50};
		System.out.println("The median is: " + test.sortAndGetMedian(arr1));
		System.out.println("And the sorted array is: \n" + Arrays.toString(arr1));
		
		int[] arr2 = {11,20,10};
		System.out.println("The median is: " + test.sortAndGetMedian(arr2));
		System.out.println("And the sorted array is: \n" + Arrays.toString(arr2));
	}

	
	@Override
	public Color getColor() {
		return new Color(255,120,140);
	}

	@Override
	public String getSpriteName() {
		return E_HONDA;
	}

	public double sortAndGetMedian(int[] random) {
		mergeSort(random);
		if(random.length%2 == 0) {
			int mid = (random.length/2) -1;
			int mid2 = random.length/2;
			return (double)(random[mid] + random[mid2])/2;
		}else {
			int mid = random.length/2;
			return random[mid];
		}
	}	
//CODE TO MERGE INCOMPLETE
/*	
	public static int[] mergeSort(int[] random) {
		if(random.length == 1) {
			return random;
		}
		int mid = random.length/2;
		int[] firstHalf = new int[mid];
	    int[] secondHalf = new int[random.length - mid];
	    for(int i=0; i<firstHalf.length; i++){
	        firstHalf[i]=random[i];
	    }
	    for(int i=0; i<secondHalf.length; i++){
	        secondHalf[i]=random[i+firstHalf.length];
	    }
	    return merge(mergeSort(firstHalf),mergeSort(secondHalf));
	}

	public static int[] merge(int[] mergeSort, int[] mergeSort2) {
		int[] arr = new int[mergeSort.length + mergeSort2.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < mergeSort.length && j < mergeSort2.length) {
			if(mergeSort[i] <= mergeSort2[j]) {
				arr[k] = mergeSort[i];
				i++;
			}else {
				arr[k] = mergeSort2[j];
				j++;
			}
			k++;
		}
		while(i < mergeSort.length) {
			arr[k] = mergeSort[i];
			i++;
			k++;
		}
		while(j < mergeSort2.length-1) {
			arr[k] = mergeSort[j];
			j++;
			k++;
		}
//		int[] arr = new int[mergeSort.length + mergeSort2.length];
//		if(mergeSort[mergeSort.length-1] < mergeSort2[mergeSort2.length-1]) {
//			arr[0] = mergeSort[mergeSort.length-1];
//			arr[1] = mergeSort2[mergeSort2.length-1];
//		}
		return arr;
	}
*/
	
//CODE FOR MERGESORT COMPLETE	
	   public void mergeSort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }
 
    private void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
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

}