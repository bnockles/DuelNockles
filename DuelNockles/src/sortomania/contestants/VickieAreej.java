package sortomania.contestants;

import java.awt.Color;
import sortomania.Contestant;

public class VickieAreej extends Contestant{

	public VickieAreej() {
	}

	public static void main(String[] args) {
		int[] arr = {4, 7,10, 2,18,12, 34, 42, 23, 40, 56, 31, 8};
		System.out.println("The median is: " + mostlySortAndGetMedian(arr));
		System.out.println("And the sorted array is: \n" + arr);
    }  

	@Override
	public Color getColor() {
		 return new Color(218,112,214);
	}

	@Override
	public String getSpriteName() {
		return FEI_LONG;
	}

	@Override
	public double sortAndGetMedian(int[] random) {
		//heap sort
		
		//get median
		double median = random[random.length/2];
		return median;
	
	}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double mostlySortAndGetMedian(int[] mostlySorted) {
		//bubble sort
		int n = mostlySorted.length;  
        int temp = 0;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(mostlySorted[j-1] > mostlySorted[j]){  
                                 //swap elements  
                                 temp = mostlySorted[j-1];  
                                 mostlySorted[j-1] = mostlySorted[j];  
                                 mostlySorted[j] = temp;  
                         }  
                          
                 }  
         }  
		
		/*//get median
		int median = mostlySorted[mostlySorted.length/2];
		return median;*/
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
	public String toString() {
		return null;
		
	}

}
