package sortomania;

import java.awt.Color;

public class GarrettRicky extends Contestant {

	public static void main(String[] args) {
		GarrettRicky test = new GarrettRicky();
		int[] random = {0,1,2,3,4,5,6,7,8,9,10};
		test.sortAndGetMedian(random);
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSpriteName() {
		return KEN;
	}

	@Override
	public double sortAndGetMedian(int[] random) {
	    if (random.length > 1) {
            // split array into two halves
            int[] left = leftHalf(random);
            int[] right = rightHalf(random);
            
            // recursively sort the two halves
            sortAndGetMedian(left);
            sortAndGetMedian(right);
            
            // merge the sorted halves into a sorted whole
            merge(random, left, right);
	    	}
	    //INSERT GETMEDIAN METHOD//
		}
	    public static int[] leftHalf(int[] array) {
	        int size1 = array.length / 2;
	        int[] left = new int[size1];
	        for (int i = 0; i < size1; i++) {
	            left[i] = array[i];
	        }
	        return left;
	    }
	    public static int[] rightHalf(int[] array) {
	        int size1 = array.length / 2;
	        int size2 = array.length - size1;
	        int[] right = new int[size2];
	        for (int i = 0; i < size2; i++) {
	            right[i] = array[i + size1];
	        }
	        return right;
	    }
	    
	    public static void merge(int[] result, int[] left, int[] right) {
	    	int i1 = 0;   // index into left array
	    	int i2 = 0;   // index into right array

	    	for (int i = 0; i < result.length; i++) {
	    		if (i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) {
	    			result[i] = left[i1];    // take from left
	    			i1++;
	    		} else {
	    			result[i] = right[i2];   // take from right
	    			i2++;
	    		}
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
