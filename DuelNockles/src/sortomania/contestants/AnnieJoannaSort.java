package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class AnnieJoannaSort extends Contestant {

	public static void main(String[] args){
		AnnieJoannaSort test = new AnnieJoannaSort();
		int[] arr = {4, 7, 10, 2, 18, 12, 34, 42, 23, 40, 56, 31, 8};
		System.out.println("The median is: " + test.sortAndGetMedian(arr));
		System.out.println("And the sorted array is: \n" + Arrays.toString(arr));
	}
	
	public AnnieJoannaSort() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Color getColor() {
		return new Color(211, 233, 248);
	}

	@Override
	public String getSpriteName() {
		return CHUN_LI ;
	}

	@Override
	public double sortAndGetMedian(int[] random) {

		mergeSort(random);
		
		return getMedian(random);
	}
	
	
	public  int[] mergeSort(int[] array){
	    if(array.length==1)return array;
	    int half = array.length/2;//rounds down
	    int[] firstHalf = new int[half];
	    int[] secondHalf = new int[array.length - half];
	    for(int i=0; i<firstHalf.length; i++){
	        firstHalf[i]=array[i];
	    }
	    for(int i=0; i<secondHalf.length; i++){
	        secondHalf[i]=array[i+firstHalf.length];
	    }
	    return merge(mergeSort(firstHalf),mergeSort(secondHalf));
	}
	 
	public  int[] merge(int[] a, int[] b){
		int[] c = new int[a.length + b.length];
        int i = 0, j = 0;
        for (int k = 0; k < c.length; k++) {
            if      (i >= a.length) c[k] = b[j++];
            else if (j >= b.length) c[k] = a[i++];
            else if (a[i] <= b[j])  c[k] = a[i++];
            else                    c[k] = b[j++];
        }
        return c; 
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
	
	public int getMedian(int[] sorted) {
		int half = sorted.length / 2;
		if(sorted.length % 2 == 0)
			return (sorted[half] + sorted[half - 1]) / 2;
		else
			return sorted[half];
	}

}
