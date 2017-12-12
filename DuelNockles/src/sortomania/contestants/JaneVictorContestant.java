package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class JaneVictorContestant extends Contestant{
	public static void main(String[] args) {
		JaneVictorContestant test= new JaneVictorContestant();
		int[] arr = {4, 5,6, 7,8, 12, 34, 35, 8, 40, 56, 61, 8, 68};
		System.out.println("The median is: " + test.mostlySortAndGetMedian(arr));
		System.out.println("And the sorted array is: \n" + Arrays.toString(arr));
		
	}

	@Override
	public Color getColor() {
		return new Color(149, 215, 237);
	}

	@Override
	public String getSpriteName() {
		return DEE_JAY;
	}

	@Override
	public double sortAndGetMedian(int[] random) {
		sortM(random, 0, random.length-1);
		if(random.length % 2 == 0) {
			return (random[random.length/2] + random[random.length/2-1])/2;
		}else {
			return random[random.length/2];
		}
	}	
	void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void sortM(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            sortM(arr, l, m);
            sortM(arr , m+1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
	
	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		char[][] charArr = new char[strings.length][];
		for(int i = 0; i < strings.length; i++) {
			char[] arr = strings[i].toCharArray();
			charArr[i] = arr;
		}
		//use radix sort?
		//go through each char array in the 2d arr. 
		//compare first letters anbd sorrt acordingly into seperate arrays. 
		//Sort those arrays.
		//keep going until a certain point. Then merge array.
		//turn string into charArr. Find index where it is equal.
		char[] selArr = toFind.toCharArray();
		for(int i = 0; i < charArr.length; i++) {
			if(charArr[i] == selArr) {
				return i;
			}
		}
		return -1;
	}

	static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ arr[i]/exp%10 ]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
 
    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = 101;
 
        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

	
	@Override
	public double mostlySortAndGetMedian(int[] arr) {
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
        
        if(arr.length % 2 == 0) {
			return (arr[arr.length/2] + arr[arr.length/2-1])/2;
		}else {
			return arr[arr.length/2];
		}
        
	}

	  
	@Override
	public double sortMultiDim(int[][] grid) {
		int[] medians = new int[grid.length];
		for(int i = 0; i < grid.length; i++) {
			medians[i] = (int)sortAndGetMedian(grid[i]);
		}
		return sortAndGetMedian(medians);
	}

	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		sortComparable(arr, 0, arr.length-1);
		for(int i =0; i<arr.length; i++) {
			if(arr[i]==toFind) {
				return i;
			}
		}
		return -1;

	}

	private void sortComparable(Comparable[] arr, int lo, int hi) {
		if (hi <= lo) return;

        // make sure a[lo] <= a[hi]
        if (less(arr[hi], arr[lo])) exch(arr, lo, hi);

        int lt = lo + 1, gt = hi - 1;
        int i = lo + 1;
        while (i <= gt) {
            if       (less(arr[i], arr[lo])) exch(arr, lt++, i++);
            else if  (less(arr[hi], arr[i])) exch(arr, i, gt--);
            else                         i++;
        }
        exch(arr, lo, --lt);
        exch(arr, hi, ++gt);

        // recursively sort three subarrays
        sortComparable(arr, lo, lt-1);
        if (less(arr[lt], arr[gt])) sortComparable(arr, lt+1, gt-1);
        sortComparable(arr, gt+1, hi);

		
	}

	private boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private void exch(Comparable[] a, int i, int j) {
		  Comparable swap = a[i];
	        a[i] = a[j];
	        a[j] = swap;
		
	}

	

	
}
