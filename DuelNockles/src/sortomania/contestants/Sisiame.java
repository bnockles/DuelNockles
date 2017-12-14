package sortomania.contestants;

import java.awt.Color;
import java.util.ArrayList;

import sortomania.Contestant;

public class Sisiame extends Contestant {

	@Override
	public Color getColor() {
		
		return new Color(107, 63, 160);
		
	}

	@Override
	public String getSpriteName() {
		
		return CAMMY;
		
	}

	@Override
	public double sortAndGetMedian(int[] random) {
		
		//quick sort
		return 0;
		
	}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		
		//quick sort
		return 0;
		
	}

	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		
		//insertion sort
		return 0;
		
	}

	@Override
	public double sortMultiDim(int[][] grid) {
		
		//merge sort
		return 0;
		
	}

	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		
		//merge sort
		return 0;
		
	}
	
	public void insertionSort() {
		
		
		
	}
	
	public void mergeSort() {
		
		
		
	}
	
	public void quickSort(int[] arr) {
		
		int pivot = arr[(int)(Math.random() * arr.length)];
		ArrayList<Integer> temp = arr.toList();
		int idx = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			if(arr[i] < pivot) {
				temp[idx] = arr[i];
				idx++;
			}
			
		}
		
	}
	
	public boolean sorted(int[] arr) {
		
		for(int i = 0; i < arr.length - 1; i++) {
			
			if(!(arr[i] <= arr[i + 1])) {
				return false;
			}
				
		}
		
		return true;
		
	}
	
}
