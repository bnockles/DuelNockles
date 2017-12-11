package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class AnnieJoannaSort extends Contestant {

	public static void main(String[] args){
		AnnieJoannaSort test = new AnnieJoannaSort();
		int[] arr = {4, 7, 10, 2, 18, 12, 34, 42, 23, 40, 56, 31, 8};
		System.out.println("The median is: " + test.sortAndGetMedian(arr));
		System.out.println("And the sorted array is: \n" + arr);
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
		// TODO Auto-generated method stub
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

}
