package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class SamJenny extends Contestant{

	public static void main(String[] args) {
		//int[] test = {3,5,1,4,2,6,10};
		int[][] test = {{1,6,4,3,2},{7,12,5,70,8}, {1,2,3,4,5}, {6,7,8,9,10}};
		System.out.println(sortMultiDim(test));
		System.out.println("".compareTo("b"));
	}
	
	public Color getColor() {
		return new Color(142,202,255);
	}


	public String getSpriteName() {
		return CHUN_LI;
	}


	public static double sortAndGetMedian(int[] random) {
		    sort(random);
		    if(random.length%2 == 0) {
		    	return (double)(random[random.length/2-1]+random[random.length/2])/2;
		    }
		    return random[random.length/2];
	}
	
	public static double sortAndGetMedian(double[] random) {
	    sort(random);
	    if(random.length%2 == 0) {
	    	return (double)(random[random.length/2-1]+random[random.length/2])/2;
	    }
	    return random[random.length/2];
}
	
	public static void sort(int arr[])
    {
        int n = arr.length;
 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
	
	public static void sort(double arr[])
    {
        int n = arr.length;
 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = (int) arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void heapify(int arr[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
    static void heapify(double arr[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i)
        {
            int swap = (int) arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
	
	public static void swap(int i, int j) {
		int temp = i;
		i = j;
		j = temp;
		
	}


	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		
	}


	public static double mostlySortAndGetMedian(int[] mostlySorted) {
		sort2(mostlySorted);
		if(mostlySorted.length%2 == 0) {
	    	return (double)(mostlySorted[mostlySorted.length/2-1]+mostlySorted[mostlySorted.length/2])/2;
	    }
	    return mostlySorted[mostlySorted.length/2];
	}

	 static void sort2(int arr[])
	    {
	        int n = arr.length;
	        for (int i=1; i<n; ++i)
	        {
	            int key = arr[i];
	            int j = i-1;
	 
	            /* Move elements of arr[0..i-1], that are
	               greater than key, to one position ahead
	               of their current position */
	            while (j>=0 && arr[j] > key)
	            {
	                arr[j+1] = arr[j];
	                j = j-1;
	            }
	            arr[j+1] = key;
	        }
	    }
	

	public static double sortMultiDim(int[][] grid) {
		double[] medians = new double[grid.length];
		for(int row = 0; row < grid.length; row++) {
			medians[row] = sortAndGetMedian(grid[row]);
		}
		return sortAndGetMedian(medians);
	}


	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		return 0;
	}

}
