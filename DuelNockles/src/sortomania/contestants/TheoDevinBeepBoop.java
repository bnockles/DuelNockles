package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class TheoDevinBeepBoop extends Contestant {

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
