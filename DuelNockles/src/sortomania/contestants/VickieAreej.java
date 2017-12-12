package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class VickieAreej extends Contestant{

	private double median;
	
	public VickieAreej() {
	}

	public static void main(String[] args) {
		int[] arr = {4, 7,10, 2,18,12, 34, 42, 23, 40, 56, 31, 8, 56,234,56,35,234,67};
		int[][] arr2 = {{2,1,3},{23,54,23}};
		multiArraySort(arr2);
		heapSort(arr);
		//bubbleSort(arr);
		System.out.print(Arrays.toString(arr));
		//System.out.println("The median is: " + sortAndGetMedian(arr));
		//System.out.println("And the sorted array is: \n" + arr);
    }  

	@Override
	public Color getColor() {
		 return new Color(218,112,214);
	}

	@Override
	public String getSpriteName() {
		return FEI_LONG;
	}

		public static void heapSort(int arr[])
	    {
	        int n = arr.length;
	        for (int i = n / 2 - 1; i >= 0; i--)
	            heapify(arr, n, i);
	        for (int i=n-1; i>=0; i--)
	        {
	            int temp = arr[0];
	            arr[0] = arr[i];
	            arr[i] = temp;
	 
	            heapify(arr, i, 0);
	        }
	    }
	 
	    public static void heapify(int arr[], int n, int i)
	    {
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
	 
	    /* A utility function to print array of size n */
	    static void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i]+" ");
	        System.out.println();
	    }
 
    // Driver program
	public double sortAndGetMedian(int[] random) {
		//heap sort
		heapSort(random);
		//get median
		if(random.length%2 ==0) {
			median = (random[random.length/2]+random[(random.length/2)-1])/2;
		}else {
			median = random[(int) ((random.length/2)+.5)];
		}
		return median;
	}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

			public static  int[] bubbleSort(int[] mostlySorted) {
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
			median = (mostlySorted[mostlySorted.length/2]+mostlySorted[(mostlySorted.length/2)-1])/2;
		}else {
			median = mostlySorted[(int) ((mostlySorted.length/2)+.5)];
		}
		return median;
	}

	@Override
	public double sortMultiDim(int[][] grid) {
		multiArraySort(grid);
		return 0;
	}

	private static void multiArraySort(int[][] grid) {
		//int A[][]=new int[m][n]; //creating a 2D array
        int m = grid.length;
        int n = grid[m].length;
        /* Inputting the 2D Array */

       /* for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print("Enter the elements: ");
                A[i][j]=Integer.parseInt(br.readLine());
            }
        }    */    
 
        /* Printing the original 2D Array */

        System.out.println("The original array:");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(grid[i][j]+"\t");
            }
            System.out.println();
        }

        /* Sorting the 2D Array */

        int t=0;
        for(int x=0;x<m;x++)
        {
            for(int y=0;y<n;y++)
            {
                for(int i=0;i<m;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        if(grid[i][j]>grid[x][y])
                        {
                            t=grid[x][y];
                            grid[x][y]=grid[i][j];
                            grid[i][j]=t;
                        }
                    }
                }
            }
        }

        /* Printing the sorted 2D Array */

        System.out.println("The Sorted Array:");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(grid[i][j]+"\t");
            }
            System.out.println();
        }
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
