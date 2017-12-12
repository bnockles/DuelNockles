package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class JessicaJi extends Contestant {

	public static void main(String[] args) {
		JessicaJi test = new JessicaJi();
		int[] arr = {4, 7, 10, 2, 8, 12, 100, 34, 42, 23, 40, 56, 31, 8};
		String[] arr2 = {"Jessica", "Ji", "Bob", "Sam", "Amanda", "Panda"};
		int[][] arr3 = { {1,2,5,7} , {7,5,9,0} };
	//	System.out.println("The median is: " + test.sortAndGetMedian(arr));
	//	System.out.println("And the sorted array is: \n" + Arrays.toString(insertionSort(arr)));
	//	System.out.println("And the sorted array is: \n" + Arrays.toString(mergeSort(arr, 0, arr.length - 1)));
	//	System.out.println("The sorted string array is: \n" + Arrays.toString(mergeSortString(arr2)));
	//	System.out.println("The sorted string array is: \n" + Arrays.toString(insertionSortString(arr2)));
		System.out.println("The sorted 2D array is: \n" + Arrays.deepToString(sortMultiInt(arr3)));
		System.out.println("The index of the sorted string array is: \n" + Integer.toString(test.sortAndGetResultingIndexOf(arr2,"Ji")));
		System.out.println("The sorted 2D array's median is: \n" + Double.toString( test.sortMultiDim(arr3)));
	}
	public static int[] insertionSort(int[] arr) {
        for (int i=1; i<arr.length; i++)
        {
            int idx = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] > idx)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = idx;
        }
		return arr;
	}

	public static int[] mergeSort(int[] arr, int lower, int higher) {
		int[] tempMergArr = new int[arr.length];
		if (lower < higher) {
	            int middle = lower + (higher - lower) / 2;
	            // Below step sorts the left side of the array
	            mergeSort(arr, lower, middle);
	            // Below step sorts the right side of the array
	            mergeSort(arr, middle + 1, higher);
				//mergeParts(lowerIndex, middle, higherIndex);
	            
	            for (int i = lower; i <= higher; i++) {
		        tempMergArr[i] = arr[i];
		        }
		        int i = lower;
		        int j = middle + 1;
		        int k = lower;
		        while (i <= middle && j <= higher) {
		            if (tempMergArr[i] <= tempMergArr[j]) {
		                arr[k] = tempMergArr[i];
		                i++;
		            } else {
		                arr[k] = tempMergArr[j];
		                j++;
		            }
		            k++;
		        }
		        while (i <= middle) {
		            arr[k] = tempMergArr[i];
		            k++;
		            i++;
		        }
	        }
		return arr;
	
	}
	
	public static String[] insertionSortString(String[] arr) {
		int i,j;
		  String idx;
		  for (j = 1; j < arr.length; j++) {
			  idx = arr[j];
		    i = j - 1;
		    while (i >= 0) {
		      if (idx.compareTo(arr[i]) > 0) {
		        break;
		      }
		      arr[i + 1] = arr[i];
		      i--;
		    }
		    arr[i + 1] = idx;
		  }		
		  return arr;
	}
	
	public static String[] mergeSortString(String[] arr) {
        if (arr.length >= 2) {
            String[] left = new String[arr.length / 2];
            String[] right = new String[arr.length-arr.length / 2];

            for (int i = 0; i < left.length; i++)
            {
                left[i] = arr[i];
            }
            for (int i = 0; i < right.length; i++)
            {
                right[i] = arr[i + arr.length / 2];
            }

            mergeSortString(left);
            mergeSortString(right);

            merge(arr, left, right);
        }
        return arr;
    }
	//helper method for mergeSortString
	 public static void merge(String[] result, String[] left, String[] right) {
	        int i1 = 0;
	        int i2 = 0;
	        for (int i = 0; i < result.length; i++) {
	            if (i2 >= right.length || (i1 < left.length &&
	                                 left[i1].compareToIgnoreCase(right[i2])<0)) {
	                      result[i] = left[i1];
	                      i1++;
	                 } else {
	                      result[i] = right[i2];
	                      i2++;
	                 }
	            }
	    }
	
	public JessicaJi() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Color getColor() {
		return new Color(174, 198, 208);
	}

	@Override
	public String getSpriteName() {
		return RYU;
	}

	@Override
	public double sortAndGetMedian(int[] random) {
		random = mergeSort(random, 0, random.length - 1);
		return getMedian(random);
	}

	
	public double getMedian(int[] x)	
	{
		double median;
		if (x.length % 2 == 0)//even 
		{
		    median = ((double)x[x.length/2] + (double)x[x.length/2 - 1])/2; //two numbers in middle adding then dividng by 2
		}
		else //odd
		{
		    median = (double) x[x.length/2];
		}//middle num
		
		return median;
	}
	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		strings = mergeSortString(strings);
		int low = 0;
		int high = strings.length - 1;
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;

		    if (strings[mid].compareTo(toFind) < 0) {
		    	low = mid + 1;
		    } else if (strings[mid].compareTo(toFind) > 0) {
		    	high = mid - 1;
		        } else {
		            return mid;
		        }
		    }

		    return -1;
		//linear search
		/*
		int index = -1;
		for (int i=0; i<strings.length; i++) {
		    if (strings[i].equals(toFind)) {
		        index = i;
		        break;
		    }
		}
		return index;
		*/
	}

	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		mostlySorted = insertionSort(mostlySorted);
		return getMedian(mostlySorted);
	}


	
	@Override
	public double sortMultiDim(int[][] grid) {
		grid = sortMultiInt(grid);
		return medianMulti(grid); //give wrong answer
		
	}
	public double medianMulti(int[][] grid) //median of median so each array gets median and divide by median
	{
	    int[] list = new int[grid.length * grid[0].length];

	    int listPos = 0;
	    for (int i = 0; i < grid.length; i++) 
	    {
	      for (int j = 0; j < grid[0].length; j++) 
	      {
	        list[listPos++] = grid[i][j];
	      }
	    }
	    
	    return (getMedian(grid[0]) + getMedian(grid[1])) / grid.length;
	 //   return getMedian(list);
	  
	  
	}
	public static int[][] sortMultiInt(int[][] grid) 
	{
		int m = grid.length;
		int n = grid[0].length;
		int t = 0;
          for(int x = 0;x < m;x++)
          {
              for(int y = 0;y < n;y++)
              {
                  for(int i = 0;i < m;i++)
                  {
                      for(int j = 0;j < n;j++)
                      {
                          if(grid[i][j] > grid[x][y])
                          {
                              t = grid[x][y];
                              grid[x][y]= grid[i][j];
                              grid[i][j] = t;
                          }
                      }
                  }
              }
          }
          return grid;
	}

	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString(){
		return "JessicaJi";
	}

}
