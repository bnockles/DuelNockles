package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class VincentNRaymond extends Contestant {

	public static void main(String[] args) {
		VincentNRaymond test = new VincentNRaymond();
		int[] arr = {4, 7,10, 2,18,12, 34, 42, 23, 40, 56, 31, 8};
		System.out.println("The median is: " + test.sortAndGetMedian(arr));
		System.out.println("And the sorted array is: \n" + Arrays.toString(sort(arr)));
	}
	
	public VincentNRaymond() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Color getColor() {
		return new Color(0,0,255);
	}

	@Override
	public String getSpriteName() {
		return RYU;
	}
	
	public static int[] sort(int[] old) {
	    // Loop for every bit in the integers
	    for (int shift = Integer.SIZE - 1; shift > -1; shift--) {
	        // The array to put the partially sorted array into
	        int[] tmp = new int[old.length];
	        // The number of 0s
	        int j = 0;
	 
	        // Move the 0s to the new array, and the 1s to the old one
	        for (int i = 0; i < old.length; i++) {
	            // If there is a 1 in the bit we are testing, the number will be negative
	            boolean move = old[i] << shift >= 0;
	 
	            // If this is the last bit, negative numbers are actually lower
	            if (shift == 0 ? !move : move) {
	                tmp[j] = old[i];
	                j++;
	            } else {
	                // It's a 1, so stick it in the old array for now
	                old[i - j] = old[i];
	            }
	        }
	 
	        // Copy over the 1s from the old array
	        for (int i = j; i < tmp.length; i++) {
	            tmp[i] = old[i - j];
	        }
	 
	        // And now the tmp array gets switched for another round of sorting
	        old = tmp;
	    }
	 
	    return old;
	}
	
	@Override
	public double sortAndGetMedian(int[] random) {
		// TODO Auto-generated method stub
		int[] sortedArray= sort(random);
		if(sortedArray.length % 2 == 0) {
			return sortedArray[(sortedArray.length-1)/2];
		} else {
			return ((sortedArray[sortedArray.length/2])+(sortedArray[(sortedArray.length/2)-1]))/2;	
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
