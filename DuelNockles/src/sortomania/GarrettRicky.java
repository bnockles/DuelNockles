package sortomania;

import java.awt.Color;
import java.util.Arrays;

public class GarrettRicky extends Contestant {

	public static void main(String[] args) {
		GarrettRicky test = new GarrettRicky();
		int[] random = {10,1,5,8,6,2,4,7,3,9,0,12,11};
		System.out.println(Arrays.toString(random));
		System.out.println(test.sortAndGetMedian(random));
		System.out.println(Arrays.toString(random));
	}

	@Override
	public Color getColor() {
		return rgb(51, 204, 51);
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
	    if(random.length % 2 == 0) {
	    	return (double)(random[random.length/2] + random[random.length/2 - 1])/2;
	    }
	    return (double)random[(random.length-1)/2];
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
		 int n = mostlySorted.length;
	        for (int i=1; i<n; ++i)
	        {
	            int key = mostlySorted[i];
	            int j = i-1;
	 
	            /* Move elements of arr[0..i-1], that are
	               greater than key, to one position ahead
	               of their current position */
	            while (j>=0 && mostlySorted[j] > key)
	            {
	            	mostlySorted[j+1] = mostlySorted[j];
	                j = j-1;
	            }
	            mostlySorted[j+1] = key;
	        }
	        //INSERT GETMEDIAN METHOD//
			return n;
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
