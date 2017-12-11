package sortomania;

import java.awt.Color;

public class SidBen extends Contestant{

	private int[] numbers;
	private int number;
	
	public static void main(String[] args) {
		int[] temp = {5,1,4,7,3,3};
		
		sort(temp);
	}
	
	
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return new Color(255,255,255);
	}
	
	
	
	
	
	
	
	@Override
	public String getSpriteName() {
		// TODO Auto-generated method stub
		return DEE_JAY;
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
	
	
	//------------------------------------------------------------------------------------
	 public static void sort(int[] values) {
		 	
	        // check for empty or null array
	        if (values ==null || values.length==0){
	            return;
	        }
	        this.numbers = values;
	        number = values.length;
	        quicksort(0, number - 1);
	    }

	    private static void quicksort(int low, int high) {
	        int i = low, j = high;
	        // Get the pivot element from the middle of the list
	        int pivot = numbers[low + (high-low)/2];

	        // Divide into two lists
	        while (i <= j) {
	            // If the current value from the left list is smaller than the pivot
	            // element then get the next element from the left list
	            while (numbers[i] < pivot) {
	                i++;
	            }
	            // If the current value from the right list is larger than the pivot
	            // element then get the next element from the right list
	            while (numbers[j] > pivot) {
	                j--;
	            }

	            // If we have found a value in the left list which is larger than
	            // the pivot element and if we have found a value in the right list
	            // which is smaller than the pivot element then we exchange the
	            // values.
	            // As we are done we can increase i and j
	            if (i <= j) {
	                exchange(i, j);
	                i++;
	                j--;
	            }
	        }
	        // Recursion
	        if (low < j)
	            quicksort(low, j);
	        if (i < high)
	            quicksort(i, high);
	    }

	    private static void exchange(int i, int j) {
	        int temp = numbers[i];
	        numbers[i] = numbers[j];
	        numbers[j] = temp;
	    }
}
