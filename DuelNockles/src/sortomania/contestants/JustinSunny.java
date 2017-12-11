package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class JustinSunny {

	public static void main(String[] args) {
		int[] arr = new int[10000];
		populate(arr);
		
		long startTime =  System.currentTimeMillis();
		sortAndGetMedian(arr);
		long endTime =  System.currentTimeMillis();

		long duration = (endTime - startTime);
		System.out.println(duration + " " + mostlySortAndGetMedian(arr));
	}
	
	public static void populate(int[] arr) {
		/*
		for(int i = 0; i < arr.length; i++) {
			if(Math.random() > 0.75)
			{
				arr[i] = i;
			}
			else {
				arr[i] = (int) (Math.random() * 9999);
			}
		}
		*/
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 9999);
		}
	}
	
	public Color getColor() {
		// TODO Auto-generated method stub
		return new Color(153, 255, 153);
	}

	public String getSpriteName() {
		// TODO Auto-generated method stub
		return "RYU";
	}

	public static double sortAndGetMedian(int[] random) {
		sort(random);
		int halfWayMarker = (int) random.length/2;
		return (random.length % 2 != 0)?((random[halfWayMarker] + random[halfWayMarker + 1])/2):random[halfWayMarker];
	}

	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		sort(strings);
		return binarySearch(strings, 0, strings.length - 1, toFind);
	}

	public static double mostlySortAndGetMedian(int[] mostlySorted) {
		insertionSort(mostlySorted, mostlySorted.length);
		int halfWayMarker = (int) mostlySorted.length/2;
		return (mostlySorted.length % 2 != 0)?((mostlySorted[halfWayMarker] + mostlySorted[halfWayMarker + 1])/2):mostlySorted[halfWayMarker];
	}

	public double sortMultiDim(int[][] grid) {
		double[] newArr = new double[grid.length];
		for(int i = 0; i < newArr.length; i++) {
			newArr[i] = sortAndGetMedian(grid[i]);
		}
		int halfWayMarker = (int) newArr.length/2;
		return (newArr.length % 2 != 0)?((newArr[halfWayMarker] + newArr[halfWayMarker + 1])/2):newArr[halfWayMarker];
	}

	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		// TODO Auto-generated method stub
		return 0;
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
	
	/* Function to sort an array using insertion sort*/
	public static void insertionSort(int A[], int size)
	{
	   int i, key, j;
	   for (i = 1; i < size; i++)
	   {
	       key = A[i];
	       j = i-1;
	 
	       /* Move elements of A[0..i-1], that are greater than key, to one 
	          position ahead of their current position.
	          This loop will run at most k times */
	       while (j >= 0 && A[j] > key)
	       {
	           A[j+1] = A[j];
	           j = j-1;
	       }
	       A[j+1] = key;
	   }
	}
	
	public static void sort(String arr[])
    {
        int n = arr.length;
 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            String temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
	
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    public static void heapify(int arr[], int n, int i)
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
    
    public static void heapify(String arr[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l].compareTo(arr[largest]) > 0)
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r].compareTo(arr[largest]) > 0)
            largest = r;
 
        // If largest is not root
        if (largest != i)
        {
            String swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
	
    public static int binarySearch(int arr[], int l, int r, int x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;
 
            // If the element is present at the middle itself
            if (arr[mid] == x)
               return mid;
 
            // If element is smaller than mid, then it can only
            // be present in left subarray
            if (arr[mid] > x)
               return binarySearch(arr, l, mid-1, x);
 
            // Else the element can only be present in right
            // subarray
            return binarySearch(arr, mid+1, r, x);
        }
 
        // We reach here when element is not present in array
        return -1;
    }
    
    public static int binarySearch(String arr[], int l, int r, String x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;
            int compareValue = arr[mid].compareTo(x);
            
            // If the element is present at the middle itself
            if (compareValue == 0)
               return mid;
 
            // If element is smaller than mid, then it can only
            // be present in left subarray
            if (compareValue > 0)
               return binarySearch(arr, l, mid-1, x);
 
            // Else the element can only be present in right
            // subarray
            return binarySearch(arr, mid+1, r, x);
        }
 
        // We reach here when element is not present in array
        return -1;
    }
    
}
