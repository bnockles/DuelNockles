package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class JessicaJi extends Contestant {

	public static void main(String[] args) {
		JessicaJi test = new JessicaJi();
		int[] arr = {4, 7, 10, 2, 8, 12, 100, 34, 42, 23, 40, 56, 31, 8};
		System.out.println("The median is: " + test.sortAndGetMedian(arr));
		System.out.println("And the sorted array is: \n" + mergeSort(arr));
	}
	public static int[] insertionSort(int[] arr) {
		// TODO Auto-generated method stub
		return arr;
	}
	
	public static int[] mergeSort(int[] arr) {
		// TODO Auto-generated method stub
		return arr;
	}
	
	public static String[] insertionSortString(String[] arr) {
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
		return 0;
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
