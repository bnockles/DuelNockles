package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class DoubleJasons extends Contestant{
	
	private int[] ISSeq;
	
	public DoubleJasons() {
		int[] temp = {1, 3, 7, 21, 48, 112, 336, 861, 1968, 4592};
		ISSeq = temp;
	}
	
	private void shellSort(String[] arr) {
		int index = 0;
		while() {
			
		}
		
	}
	
	private void shellSort(int[] random) {
		int index = 0;
		while() {
			
		}
		
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSpriteName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double sortAndGetMedian(int[] random) {	
		shellSort(random);
		return random[random.length/2];
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
