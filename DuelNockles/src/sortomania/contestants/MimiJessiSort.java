package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class MimiJessiSort extends Contestant{
	
	private int[] random;
    private int number;

	@Override
	public Color getColor() {
		return new Color(201, 170, 254);
	}

	@Override
	public String getSpriteName() {
		return CHUN_LI;
	}

	public double median(int[] arr) {
	    int middle = arr.length / 2;
	       if (arr.length%2 == 1)
	        {
	           return arr[middle];
	        } else {
	        	return (arr[middle-1] + arr[middle]) / 2.0;
	        }
	}
	
	@Override
	public double sortAndGetMedian(int[] random) {
		if (random.length==0){
           return 0;
       }
        this.random = random;
        number = random.length;
        quickSort(0, number - 1);
        
        median(random);
        
      //  if(random.length % 2 == 0) {
        //	return (random[random.length-1] + random[random.length])/2.0;
        //}
        //else if (random.length % 2 == 1) {
        //	return random[random.length/2];
       // }
		return number;
	
	}

	/**
	 * helper method for sortAndGetMedian
	 * @return
	 */
	public void quickSort(int low, int high) {
		int i = low;
		int j = high;
		int pivot = random[low + (high - low)/2];
		
		while(i <= j) {
			while(random[i] < pivot) {
				i++;
			}
			while(random[j] > pivot) {
				j--;
			}
			if ( i <= j) {
				swap(i,j);
				i++;
				j--;
			}
		}
		if (low < j)
            quickSort(low, j);
        if (i < high)
            quickSort(i, high);
	}

	private void swap(int i, int j) {
		int temp = random[i];
        random[i] = random[j];
        random[j] = temp;
	}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		
		return 0;
	}
	
	public static void sortString() {
		
	}
	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		insertionSort(mostlySorted);
		//median(mostlySorted);
		return 0;
	}
	
	public void insertionSort(int arr[]) {
		int n = arr.length;
		for(int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i-1;
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j -1;
			}
			arr[j+1] = key;
		}
	}
	
	@Override
	public double sortMultiDim(int[][] grid) {
		//mergeSort();
		return 0;
	}
	
	public void merge(int arr[], int l, int m, int r) {
		int n = m - l + 1;
		int p = r - m;
		int L[] = new int [n];
		int R[] = new int [p];
		
		for(int i = 0; i < n; i++) {
			L[i] = arr[l + i];
		}
		for(int j = 0; j < p; j++) {
			R[j] = arr[m + 1 + j];
		}
		
		int i = 0;
		int j = 0;
		int k = 1;
		while(i < n && j < p) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}else {
				arr[k] = R[j];
				j++;
			}
		}
	}
	
	public void mergeSort(int arr[], int l, int r) {
		if(l < r) {
			int m = (1+r)/2;
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			merge(arr, l, m, r);
		}
	}

	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		
		return 0;
	}
	
	
	
}
