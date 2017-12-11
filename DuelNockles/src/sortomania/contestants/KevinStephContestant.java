package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class KevinStephContestant extends Contestant {

	public KevinStephContestant() {
		KevinStephContestant test = new KevinStephContestant();
		int[] arr = {4, 7,10, 2,18,12, 34, 42, 23, 40, 56, 31, 8};
		System.out.println("The median is: " + test.sortAndGetMedian(arr));
		System.out.println("And the sorted array is: \n" + arr);
	}

	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSpriteName() {
		// TODO Auto-generated method stub
		return null;
	}

	public double sortAndGetMedian(int[] random) {
		int m = 0;
		int n = random.length;
			// One by one move boundary of unsorted subarray
	        for (int i = 0; i < n-1; i++)
	        {
	        	// Find the minimum element in unsorted array
	        	int min_idx = i;
	        	for (int j = i+1; j < n; j++)
	                if (random[j] < random[min_idx])
	                    min_idx = j;
	 
	            // Swap the found minimum element with the first element
	            int temp = random[min_idx];
	            random[min_idx] = random[i];
	            random[i] = temp;
	        }
	        
	        if (random.length % 2 == 1) {
	        	m = random[(random.length+1)/2];
	        } else if (random.length % 2 == 0){
	        	m = (random[random.length/2] + random[(random.length/2)+1])/2;
	        }
	      
	        return m;
	}

	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		int temp;
        for (int i = 1; i < mostlySorted.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(mostlySorted[j] < mostlySorted[j-1]){
                    temp = mostlySorted[j];
                    mostlySorted[j] = mostlySorted[j-1];
                    mostlySorted[j-1] = temp;
                }
            }
        }
        return 0;
	}

	@Override
	public double sortMultiDim(int[][] grid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		//sort comparable and return index of comparable.
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {

	}

}
