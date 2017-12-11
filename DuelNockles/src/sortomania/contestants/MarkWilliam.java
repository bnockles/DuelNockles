package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class MarkWilliam extends Contestant {

	
	public static void main (String[] args) {
		MarkWilliam test = new MarkWilliam();
		int[] arr = {4, 7, 10, 2, 18, 12, 34, 42, 23, 40, 56, 31,51};
		
		System.out.println("The median is: " + test.sortAndGetMedian(arr));
		System.out.println("And the sorted array is: \n");
		printArr(arr, arr.length);
	}
	
	@Override
	public Color getColor() {
		return new Color(0,200,255);
	}

	@Override
	public String getSpriteName() {
		
		return CAMMY;
	}

	@Override
	public double sortAndGetMedian(int[] random) {
		int arrLen = random.length;
		radixSort(random,arrLen);
		if(random.length%2==0)
			return ((random[arrLen/2] + random[(arrLen/2)-1])/2);
		return random[arrLen/2];
	}
	
	static void printArr(int arr[], int n)
	{
	    for (int i=0; i<n; i++)
	        System.out.print(arr[i]+" ");
	}
	
	// A utility function to get maximum value in arr[]
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
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
    static void radixSort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);
 
        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
	
	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getMaxString(String arr[], int n){
	    int max = arr[0].size();
	    for (int i = 1; i < n; i++){
	        if (arr[i].size()>max)
	            max = arr[i].size();
	    }
	    return max;
	}

	public void countSortString(String a[], int size, int k){
	    String b = new String[size];
	    int c = new int[257];



	    for (int i = 0; i <257; i++){
	        c[i] = 0;
	       
	    }
	    for (int j = 0; j <size; j++){   
	        c[k < a[j].size() ? (int)(unsigned char)a[j][k] + 1 : 0]++;            //a[j] is a string
	        //cout << c[a[j]] << endl;
	    }

	    for (int f = 1; f <257; f++){
	        c[f] += c[f - 1];
	    }

	    for (int r = size - 1; r >= 0; r--){
	        b[c[k < a[r].size() ? (int)(unsigned char)a[r][k] + 1 : 0] - 1] = a[r];
	        c[k < a[r].size() ? (int)(unsigned char)a[r][k] + 1 : 0]--;
	    }

	    for (int l = 0; l < size; l++){
	        a[l] = b[l];
	    }

	    // avold memory leak
	    delete[] b;
	    delete[] c;
	}


	void radixStringSort(String b[], int r){
	    size_t max = getMax(b, r);
	    for (size_t digit = max; digit > 0; digit--){ // size_t is unsigned, so avoid using digit >= 0, which is always true
	        countSort(b, r, digit - 1);
	    }

	}
	
	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		// TODO Auto-generated method stub
		return 0;
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

}
