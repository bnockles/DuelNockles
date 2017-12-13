package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class VickieAreej extends Contestant{

	private double median;
	
	public VickieAreej() {
	}

	public static void main(String[] args) {
		VickieAreej run = new VickieAreej();
		
		int[] arr = {4, 7, 35,234,68,8765};
		int[][] arr2 = {{2,1,3,98,9},{23,54,23,8,3}};
		//multiArraySort2(arr2);
		//heapSort(arr);
		//bubbleSort(arr);
		//System.out.print(Arrays.toString(run.multiArraySort2(arr2)));//1d arr
		//System.out.print(Arrays.deepToString(arr2)); //2d arr
		System.out.print("TEST 1:\n");
		System.out.println("	The median is: " + run.sortAndGetMedian(arr));
		System.out.print("	"+Arrays.toString(arr));//1d arr
		System.out.println("\n----------------------------------------------------------------------------------------");
		
		/*
		System.out.print("TEST 2:\n");
		System.out.println("	The median is: " + run.sortAndGetMedian(arr));
		System.out.print("	"+Arrays.toString(arr));//1d arr
		System.out.println("\n----------------------------------------------------------------------------------------");
		*/
		
		int[] ar = {4, 7,10, 2,18,12, 34, 42, 23, 40, 56, 31, 8, 56,234,56,35,234,67,5,23,4,345,4,5,24,23,4};
		System.out.print("TEST 3:\n");
		run.mostlySortAndGetMedian(ar);
		System.out.println("	The median is: " + run.median);
		System.out.print("	"+Arrays.toString(ar));//1d arr
		System.out.println("\n----------------------------------------------------------------------------------------");
		
		System.out.print("TEST 4:\n");
		System.out.println("	The median is: " + run.sortMultiDim(arr2));
		System.out.print("	"+Arrays.toString(run.multiArraySort2(arr2)));//1d arr
		System.out.println("\n----------------------------------------------------------------------------------------");
		
		
    }  

	@Override
	public Color getColor() {
		 return new Color(218,112,214);
	}

	@Override
	public String getSpriteName() {
		return FEI_LONG;
	}

	public void heapSort(int arr[]){
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i=n-1; i>=0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            heapify(arr, i, 0);
        }
    }
 
    public void heapify(int arr[], int n, int i){
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2

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
    
    // Driver program
	public double sortAndGetMedian(int[] random) {
		//heap sort
		heapSort(random);
		//get median
		if(random.length%2 ==0) {
			median = ((double)random[random.length/2]+(double)random[(random.length/2)-1])/2;
		}else {
			median = (double)random[(int) ((random.length/2)+.5)];
		}
		return median;
	}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int[] bubbleSort(int[] mostlySorted) {
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
         return mostlySorted;
	}
	
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		//bubble sort
		bubbleSort(mostlySorted);
		//get median
		if(mostlySorted.length%2 ==0) {
			median = ((double)mostlySorted[mostlySorted.length/2]+(double)mostlySorted[(mostlySorted.length/2)-1])/2;
		}else {
			median = (double)mostlySorted[(int) ((mostlySorted.length/2)+.5)];
		}
		return median;
	}

	@Override
	public double sortMultiDim(int[][] grid) {
		//multiArraySort(grid);
		int[] list = multiArraySort2(grid);
		//getMedian
		if(list.length%2 ==0) {
			median = ((double)list[list.length/2]+(double)list[(list.length/2)-1])/2;
		}else {
			median = (double)list[(int) ((list.length/2)+.5)];
		}
		return median;
	}

	private int[] multiArraySort2(int[][] grid) {
		 // Create a new list to store the items
	    int[] list = new int[grid.length*grid[0].length];
	    // keep track of where we are.
	    int listPos = 0;
	    // iterate over the entire 2d array adding each integer
	    for(int i = 0 ; i < grid.length; i++) {
	        for(int j = 0; j < grid[i].length; j++) {
	            list[listPos++] = grid[i][j];
	        }
	    }

	   // System.out.print("	"+Arrays.toString(list));
	    heapSort(list);
	    return list;
	}

	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString() {
		return "A & V";
		
	}

}
