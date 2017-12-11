package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class FahadDavidSorter extends Contestant {

	//Radix Sort
	//TimSort
	//recursive merge sort
	
	public Color getColor() {
		return new Color(192,192,192);
	}

	public String getSpriteName() {
		return CAMMY;
	}

	public double sortAndGetMedian(int[] random) {
		if(random.length %2 == 1) {
			return random[(random.length-1)/2];
		}
		else{
			int temp = (random.length)/2;
			return (random[temp] + random[temp + 1])/2;
		}
	}
	
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double mostlySortAndGetMedian(int[] mostlySorted) {
		if(mostlySorted.length %2 == 1) {
			return mostlySorted[(mostlySorted.length-1)/2];
		}
		else{
			int temp = (mostlySorted.length)/2;
			return (mostlySorted[temp] + mostlySorted[temp + 1])/2;
		}
	}

	public double sortMultiDim(int[][] grid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void radixSort(int[] arr) {
		
	}
}
