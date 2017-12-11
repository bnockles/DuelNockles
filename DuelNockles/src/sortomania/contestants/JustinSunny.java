package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class JustinSunny extends Contestant {

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return new Color(153, 255, 153);
	}

	@Override
	public String getSpriteName() {
		// TODO Auto-generated method stub
		return "RYU";
	}

	@Override
	public double sortAndGetMedian(int[] random) {
		sort(random);
		int halfWayMarker = (int) random.length/2;
		return (random.length % 2 != 0)?(random[halfWayMarker] + random[halfWayMarker + 1])/2:random[halfWayMarker];
	}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		return 0;
	}

	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double sortMultiDim(int[][] grid) {
		double[] newArr = new double[grid.length];
		for(int i = 0; i < newArr.length; i++) {
			newArr[i] = sortAndGetMedian(grid[i]);
		}
		int halfWayMarker = (int) newArr.length/2;
		return (newArr.length % 2 != 0)?(newArr[halfWayMarker] + newArr[halfWayMarker + 1])/2:newArr[halfWayMarker];
	}

	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void sort(int arr[])
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
	
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
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
	
}
