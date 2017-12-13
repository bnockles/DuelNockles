package sortomania;

import java.awt.Color;
import java.util.Arrays;

public class CarsonSort extends Contestant{

	public static void main(String a[]){
		CarsonSort test = new CarsonSort();
		//		int[][] input = {{10,2,5,1,6}, {3,7,6,4,7,10}, {2,5,3,1,6}, {4,8,1,2,6}, {4,23,5,23,12}};
		String[] test1 = {"abc", "zaq", "baq", "Aba", "C", "l", "ii"};

		System.out.println(Arrays.toString(test1));
		System.out.println(test.sortAndSearch(test1,"huiho"));
		System.out.println(Arrays.toString(test1));
	}

	public Color getColor() {
		return new Color(123,123,123);
	}

	public String getSpriteName() {
		return KEN;
	}

	public double sortAndGetMedian(int[] random) {
		quickSort(random, 0, random.length-1);
		if(random.length % 2 == 0) {
			return (random[(int)random.length /2]+random[((int)random.length /2)+1])/2;
		}
		else {
			return random[(int)random.length /2];
		}
	}

	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		for (int i=0; i<strings.length;i++) {
			for (int j=i+1 ; j<strings.length; j++) {
				if (strings[j].compareTo(strings[i])<0) {
					String k = strings[i];
					strings[i] = strings[j];
					strings[j] = k;
				}
			}
		}
		for(int l = 0; l < strings.length; l++) {
			if(toFind.equals(strings[l])) {
				return l;
			}
		}
		return -1;
	}

	void insertSort(int arr[])
	{
		int n = arr.length;
		for (int i=1; i<n; ++i) {
			int key = arr[i];
			int j = i-1;
			while (j>=0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j-1;
			}
			arr[j+1] = key;
		}
	}

	public double mostlySortAndGetMedian(int[] mostlySorted) {
		insertSort(mostlySorted);
		printArray(mostlySorted);
		if(mostlySorted.length % 2 == 0) {
			return (mostlySorted[(int)mostlySorted.length /2]+mostlySorted[((int)mostlySorted.length /2)+1])/2;
		}
		return mostlySorted[(int)mostlySorted.length /2];
	}

	public double sortMultiDim(int[][] grid) {
		int[] arr = new int[grid.length];
		for(int i = 0; i < grid.length; i ++) {
			arr[i] = (int) sortAndGetMedian(grid[i]);
		}
		return sortAndGetMedian(arr);
	}

	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		for (int i=0; i<arr.length;i++) {
			for (int j=i+1 ; j<arr.length; j++) {
				if (arr[j].compareTo(arr[i])<0) {
					Comparable k = arr[i];
					arr[i] = arr[j];
					arr[j] = k;
				}
			}
		}
		for(int l = 0; l < arr.length; l++) {
			if(toFind.equals(arr[l])) {
				return l;
			}
		}
		return -1;
	}
	public static void quickSort(int[] intArr, int lowerIndex, int higherIndex) {
		if (intArr == null || intArr.length == 0) {
			return;
		}
		int i = lowerIndex;
		int j = higherIndex;
		int pivot = intArr[lowerIndex+(higherIndex-lowerIndex)/2];
		while (i <= j) {
			while (intArr[i] < pivot) {
				i++;
			}
			while (intArr[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(intArr, i, j);
				i++;
				j--;
			}
		}
		if (lowerIndex < j) {
			quickSort(intArr, lowerIndex, j);
		}
		if (i < higherIndex) {
			quickSort(intArr, i, higherIndex);
		}
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i=0; i<n; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

