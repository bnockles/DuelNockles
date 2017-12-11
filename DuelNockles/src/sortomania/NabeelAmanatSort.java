package sortomania;

import java.awt.Color;

public class NabeelAmanatSort extends Contestant {

	
	@Override
	public Color getColor() {
		return new Color(10, 216, 182);
	}

	@Override
	public String getSpriteName() {
		
		return RYU;
	}

	@Override
	public double sortAndGetMedian(int[] random) {
	return quickSort(random, random[0], random[random.length-1]);
	}
	public double quickSort(int[] arr, int low, int high) {
		double median =0;
		
		// pick the pivot
		int middle = (int)(Math.random()*arr.length);
		int pivot = arr[middle];
 
		
	if(arr.length%2 == 0) {
		return (arr[(int)(arr.length/2)] + arr[(int)(arr.length/2)+1])/2;
	}
	else
		return arr[(int)(arr.length/2)]
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
