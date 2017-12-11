package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class AlexAndErik extends Contestant {

	public AlexAndErik() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		AlexAndErik test = new AlexAndErik();
		int[] array = {2,2,3,4,5};
		int[] sortarray = mergeSort(array);
		System.out.println("The median is " + test.sortAndGetMedian(array) + " .");
		System.out.println("And the sorted array is: \n" + sortarray);
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
		random = mergeSort(random);
		int mid = random.length/2;
		int median = random[mid];
		return median;
	}

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
