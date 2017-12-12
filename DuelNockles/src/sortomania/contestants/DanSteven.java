package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class DanSteven extends Contestant{

	public static void main(String[] args) {
		int arr[] = new int[10000];
		DanSteven a=new DanSteven();
	     for(int i=0;i<arr.length;i++) {
	    	 arr[i]=(int)(Math.random()*10000);
	     }
	     int avg=0;
	     for(int i=0;i<500;i++) {
	    	 long startTime = System.nanoTime();
	    	 a.radixsort(arr, 10000);
	    	 long endTime = System.nanoTime();
	    	 avg+=(endTime-startTime);
	    	 for(int j=0;j<arr.length;j++) {
	        	 arr[j]=(int)(Math.random()*10000);
	         }
	     }
	     avg=avg/500;
	     System.out.println(avg);
	     
	     String[] strings = {"bee","ba", "be", "a", "]"};
	     
	     
	     a.sortAndGetResultingIndexOf(strings, "be");
	     System.out.println(a.sortAndGetResultingIndexOf(strings, "e"));
	     
	     for (int i = 0; i < strings.length; i++)
	     {
	    	 System.out.println(strings[i]);
	     }
	     
	     
	}
	@Override
	public Color getColor() {
		Color a=new Color(1,1,1);
		return a;
	}
	@Override
	public String getSpriteName() {
		return "Steven";
	}
	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind)
	{
		mergeSort(strings);
		
		for (int i = 0; i < strings.length; i++)
		{
			if (strings[i].equals(toFind))
			{
				return i;
			}
		}
		
		return -1;
	}
	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		return 0;
	}
	@Override
	public double sortMultiDim(int[][] grid) {
		int[] median=new int[grid.length];
		int count=0;
		for(int i=0;i<grid.length;i++) {
			int n=grid[i].length;
			radixsort(grid[i],n);
			median[count]=(grid[i][n/2]+grid[i][(n-1)/2])/2;
			count++;
		}
		return sortAndGetMedian(median);
	}
	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		return 0;
	}
	@Override
	public double sortAndGetMedian(int[] random) {
		int n=random.length;
		radixsort(random,random.length);
		return (random[n/2]+random[(n-1)/2])/2;
	}
	
	public int getMax(int arr[], int n)
	 {
	     int mx = arr[0];
	     for (int i = 1; i < n; i++)
	         if (arr[i] > mx)
	             mx = arr[i];
	     return mx;
	 }

	 // A function to do counting sort of arr[] according to
	 // the digit represented by exp.
	public void countSort(int arr[], int n, int exp)
	 {
	     int output[] = new int[n]; // output array
	     int i;
	     int count[] = new int[10];
	     Arrays.fill(count,0);

	     // Store count of occurrences in count[]
	     for (i = 0; i < n; i++)
	         count[ (arr[i]/exp)%10 ]++;

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
	public void radixsort(int arr[], int n)
	 {
	     // Find the maximum number to know number of digits
	     int m = getMax(arr, n);

	     // Do counting sort for every digit. Note that instead
	     // of passing digit number, exp is passed. exp is 10^i
	     // where i is current digit number
	     for (int exp = 1; m/exp > 0; exp *= 10)
	         countSort(arr, n, exp);
	 }

	public void mergeSort(String[] a) {
        if (a.length >= 2) {
            String[] left = new String[a.length / 2];
            String[] right = new String[a.length-a.length / 2];

            for (int i = 0; i < left.length; i++)
            {
                left[i] = a[i];
            }
            for (int i = 0; i < right.length; i++)
            {
                right[i] = a[i + a.length / 2];
            }

            mergeSort(left);
            mergeSort(right);

            merge(a, left, right);
        }
    }

    public void merge(String[] result, String[] left, String[] right) {
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
}
