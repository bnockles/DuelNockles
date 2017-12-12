package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class AlexAndErik extends Contestant {

	private int[] array;
    private int[] tempMergArr;
    private int length;
    
    private double[] arrayDo;
    private double[] tempMergArrDo;
    private int lengthDo;
    
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
		
		String[] temp = {"siddeeq","erik","alex"};
		System.out.println("Here is the index: " + test.sortAndGetResultingIndexOf(temp,"alex"));
		
		int[] arr1 = {11,20,21,50};
		System.out.println("The median is: " + test.sortAndGetMedian(arr1));
		System.out.println("And the sorted array is: \n" + Arrays.toString(arr1));
		
		int[] arr2 = {11,20,10};
		System.out.println("The median is: " + test.sortAndGetMedian(arr2));
		System.out.println("And the sorted array is: \n" + Arrays.toString(arr2));
		
		int[] arr3 = {11,20,21,50};
		System.out.println("The median is: " + test.mostlySortAndGetMedian(arr3));
		System.out.println("And the sorted array is: \n" + Arrays.toString(arr3));
		
		int[] arr4 = {11,20,10};
		System.out.println("The median is: " + test.mostlySortAndGetMedian(arr4));
		System.out.println("And the sorted array is: \n" + Arrays.toString(arr4));
		
		int[][] arr5 = {{100,200,300},{100,10,300},{1,2,3}};
		System.out.println("The median is: " + test.sortMultiDim(arr5));
		System.out.println("And the sorted array is: \n" + Arrays.deepToString(arr5));
		
		int[][] arr6 = {{12,10,30},{53,0,1000},{9,9,4}};
		System.out.println("The median is: " + test.sortMultiDim(arr6));
		System.out.println("And the sorted array is: \n" + Arrays.deepToString(arr6));
	}

	
	@Override
	public Color getColor() {
		return new Color(255,120,140);
	}

	@Override
	public String getSpriteName() {
		return E_HONDA;
	}

	//simpler version of getMedian()
	public double getMedian(int[] arr) {
		int half = arr.length/2;
		if(arr.length%2 == 0) {
			return (double)(arr[half-1] + arr[half])/2;
		}else {
			return arr[half];
		}
	}
	
	public double getMedian(double[] arr) {
		if(arr.length%2 == 0) {
			int mid = (arr.length/2) -1;
			int mid2 = arr.length/2;
			return (double)(arr[mid] + arr[mid2])/2;
		}else {
			int mid = arr.length/2;
			return arr[mid];
		}
	}
	
	public double sortAndGetMedian(int[] random) {
		mergeSort(random);
		return getMedian(random);
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
            int middle = (higherIndex + lowerIndex) / 2;
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
		//int count = 0;
		int numMatches = 0;
		for(int i = 0; i < strings.length; i++) {
			if(toFind.length() == strings[i].length()) {
				for(int j = 0; j < toFind.length();j++) {
					if(toFind.substring(j,j+1).equals(strings[i].substring(j,j+1))) {
						numMatches++;
						if(numMatches == toFind.length()) {
							return i;
						}
					}
				}
			}
		}
		return -1;
		/*while(count < strings.length) {
			for(int i = 0; i < toFind.length()-1;i++) {
				if(toFind.length() == strings[count].length() && !toFind.substring(i,i+1).equals(strings[count].substring(i,i+1))) {
					count++;
				}
			}
		}
		return count;*/
		// TODO Auto-generated method stu
	}

	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		mergeSort(mostlySorted);
		return getMedian(mostlySorted);
	}

	@Override
	public double sortMultiDim(int[][] grid) {
		double[] medians = new double[grid.length];
		for(int i = 0; i < grid.length;i++) {
			mergeSort(grid[i]);
			medians[i] = getMedian(grid[i]);
		}
		System.out.println("The median array is: \n" + Arrays.toString(medians));
		mergeSortDoubles(medians);
		System.out.println("The newly sorted median array is: \n" + Arrays.toString(medians));
		return getMedian(medians);
	}

	public void mergeSortDoubles(double[] medians) {
		this.arrayDo = medians;
        this.length = medians.length;
        this.tempMergArrDo = new double[length];
        doMergeSortDo(0, length - 1);
	}

	private void doMergeSortDo(int lowerIndex, int higherIndex) {  
	        if (lowerIndex < higherIndex) {
	            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
	            // Below step sorts the left side of the array
	            doMergeSortDo(lowerIndex, middle);
	            // Below step sorts the right side of the array
	            doMergeSortDo(middle + 1, higherIndex);
	            // Now merge both sides
	            mergePartsDo(lowerIndex, middle, higherIndex);
	        }
	    }
	
	private void mergePartsDo(int lowerIndex, int middle, int higherIndex) {
		  
	        for (int i = lowerIndex; i <= higherIndex; i++) {
	            tempMergArrDo[i] = arrayDo[i];
	        }
	        int i = lowerIndex;
	        int j = middle + 1;
	        int k = lowerIndex;
	        while (i <= middle && j <= higherIndex) {
	            if (tempMergArrDo[i] <= tempMergArrDo[j]) {
	                arrayDo[k] = tempMergArrDo[i];
	                i++;
	            } else {
	                arrayDo[k] = tempMergArrDo[j];
	                j++;
	            }
	            k++;
	        }
	        while (i <= middle) {
	            arrayDo[k] = tempMergArrDo[i];
	            k++;
	            i++;
	        }
	 
	    }
	
	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

}
