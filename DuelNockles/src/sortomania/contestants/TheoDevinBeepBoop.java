package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class TheoDevinBeepBoop extends Contestant {
		public static void main (String[]args) {
			TheoDevinBeepBoop test = new TheoDevinBeepBoop();
			int [] arr = {0, 9, 2, 4, 8, 1, 3, 5, 7, 6};
		
			System.out.println(test.sortAndGetMedian(arr));
			System.out.println(Arrays.toString(arr));
			
		}

	@Override
	public Color getColor() {
		return new Color(255,170,0);
	}

	@Override
	public String getSpriteName() {
		return BLANKA;// why no Q :(
	}

	@Override
	public double sortAndGetMedian(int[] random) {//heap for random, insertion for near
		int numCounts[] = new int[random.length];

	    // populate numCounts
	    for (int num : random) {
	        numCounts[num]++;
	    }

	    // populate the final sorted array
	    int[] sortedArray = new int[random.length];
	    int currentSortedIndex = 0;

	    // for each num in numCounts
	    for (int num = 0; num < numCounts.length; num++) {
	        int count = numCounts[num];

	        // for the number of times the item occurs
	        for (int i = 0; i < count; i++) {

	            // add it to the sorted array
	            sortedArray[currentSortedIndex] = num;
	            currentSortedIndex++;
	        }
	    }
	    random = sortedArray;
		if(random.length%2==1) {
			return (double)sortedArray[random.length/2];
		}else {
			return (double)(sortedArray[random.length/2]+sortedArray[(random.length/2)-1])/2;
		}
	}
	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		return 0;

	}

	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		int numCounts[] = new int[mostlySorted.length];

	    // populate numCounts
	    for (int num : mostlySorted) {
	        numCounts[num]++;
	    }

	    // populate the final sorted array
	    int[] sortedArray = new int[mostlySorted.length];
	    int currentSortedIndex = 0;

	    // for each num in numCounts
	    for (int num = 0; num < numCounts.length; num++) {
	        int count = numCounts[num];

	        // for the number of times the item occurs
	        for (int i = 0; i < count; i++) {

	            // add it to the sorted array
	            sortedArray[currentSortedIndex] = num;
	            currentSortedIndex++;
	        }
	    }
	    mostlySorted = sortedArray;
		if(mostlySorted.length%2==1) {
			return (double)sortedArray[mostlySorted.length/2];
		}else {
			return (double)(sortedArray[mostlySorted.length/2]+sortedArray[(mostlySorted.length/2)-1])/2;
		}
	}

	@Override
	public double sortMultiDim(int[][] grid) {
		for(int i =0;i<grid.length;i++) {
			grid[i]= countingSort(grid[i]);
		}
		
		return 0;
	}
	  public int[] countingSort(int[] theArray) {

		    // array of 0's at indices 0...maxValue
		    int numCounts[] = new int[theArray.length];

		    // populate numCounts
		    for (int num : theArray) {
		        numCounts[num]++;
		    }

		    // populate the final sorted array
		    int[] sortedArray = new int[theArray.length];
		    int currentSortedIndex = 0;

		    // for each num in numCounts
		    for (int num = 0; num < numCounts.length; num++) {
		        int count = numCounts[num];

		        // for the number of times the item occurs
		        for (int i = 0; i < count; i++) {

		            // add it to the sorted array
		            sortedArray[currentSortedIndex] = num;
		            currentSortedIndex++;
		        }
		    }

		    return sortedArray;
		}
	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

}
