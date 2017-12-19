package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class Coby extends Contestant {

	private int[] numbers;
	private int[] helper;
	
	private int number;
	
	public static void main(String args[]) {
		Coby test = new Coby();
		int[] arr = {4,3,7,3,9,6,5,10};
		System.out.println("The median is: " + test.sortAndGetMedian(arr));
		System.out.println("And the sorted array is: ");
		for(int i = 0; i < arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	
	@Override
	public Color getColor() {
		return new Color(10,50,200);
	}

	@Override
	public String getSpriteName() {
		return KEN;
	}

	@Override
	public double sortAndGetMedian(int[] random) {
		sort(random);
		return getMedian(random);
	}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		quickSort(strings,0,strings.length-1);
		return bsearch(strings,toFind);
	}

	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		sort(mostlySorted);
		return getMedian(mostlySorted);
	}

	@Override
	public double sortMultiDim(int[][] grid) {
		int[] medians = new int[grid.length];
		for(int i = 0; i < grid.length; i++) {
			sort(grid[i]);
			medians[i] = (int) getMedian(grid[i]);
		}
		sort(medians);
		return (double)(getMedian(medians));
	}

	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		quickSort(arr,0,arr.length-1);
		for(int i = 0; i < arr.length;i++){
			if(arr[i].equals(toFind)){
				return i;
			}
		}
		return -1;
	} 
	
	 public void quickSort(Comparable[] a, int lo, int hi) {
	       if(lo >= hi) {
	    	   return;
	       }
	       int pi = partitionComparables(a, lo, hi);
	       quickSort(a, lo, pi-1);
	       quickSort(a, pi+1, hi);
	 }
	 
	 private int partitionComparables(Comparable[] arr, int low, int high) {
		 int i = low + 1;
	       int j = high;
	       while(i <= j) {
	           if(arr[i].compareTo(arr[low]) <= 0) { 
	               i++; 
	           } else { 
	        	   if(arr[j].compareTo(arr[low]) > 0) { 
		               j--;
	        	   }else {
	        		   if(j < i) {
	        			   break;
	        		   } else {
	     	              change(arr, i, j);
	        		   }
	        	   }
	           }
	       }
	       change(arr, low, j);
	       return j;
	 }
	 
	 private void change(Comparable[] a, int i, int j) {
		 Comparable temp = a[i];
		 a[i] = a[j];
		 a[j] = temp;
	 }

	 private void mergesort(int low, int high) {
		 if (low < high) {
			int middle = low + (high - low) / 2;
	 		mergesort(low, middle);
	 		mergesort(middle + 1, high);
	 		merge(low, middle, high);
		 }
	 }
	 public void sort(int[] grid) {
	        this.numbers = grid;
	        number = grid.length;
	        this.helper = new int[number];
	        mergesort(0, number - 1);
	 }
	 private void merge(int low, int middle, int high) {
		 for (int i = low; i <= high; i++) {
			 helper[i] = numbers[i];
		 }
	     int i = low;
	     int j = middle + 1;
	     int k = low;
	     while (i <= middle && j <= high) {
	    	 if (helper[i] <= helper[j]) {
	    		 numbers[k] = helper[i];
	             i++;
	         } else {
	             numbers[k] = helper[j];
	             j++;
	         }
	         k++;
	     }
	     while (i <= middle) {
	         numbers[k] = helper[i];
	         k++;
	         i++;
	     }
	 }
	 
	 private int bsearch(String[] arr, String word) {
		int low=0;
		int high = arr.length -1;
		int mid;
		while(low<=high) {
			mid = (low+high)/2;
			if(arr[mid].compareTo(word) < 0) {
				low = mid+1;
			} else {
				if(arr[mid].compareTo(word)>0) {
					high = mid+1;
				} else {
					return mid;
				}
			}
		}
		return -1;
	 }
	 
	 private double getMedian(int[] random) {
		if(random.length % 2 == 1) {
			return (double)(random[(random.length/2)]);
		}else {
			return (double)(random[(random.length/2)]+random[(random.length/2)-1])/2;
		}
	 }
	 
	 public static int partition(String[] stringArray, int idx1, int idx2) {
		 String pivotValue = stringArray[idx1];
		 while (idx1 < idx2) {
			 String value1;
			 String value2;
			 while ((value1 = stringArray[idx1]).compareTo( pivotValue ) < 0) {
				 idx1 = idx1 + 1;
			 }
			 while ((value2 = stringArray[idx2]).compareTo( pivotValue ) > 0) {
				 idx2 = idx2 - 1;
			 }
			 stringArray[idx1] = value2;
			 stringArray[idx2] = value1;
			 }
		 return idx1;
	 }
	 
	 private static void quickSort(String[] a, int start, int end){
		 int i = start;
		 int j = end;
		 if (j - i >= 1){
			 String pivot = a[i];
	         while (j > i){
	        	 while (a[i].compareTo(pivot) < 0 && i <= end && j > i){
	        		 i++;
	             }
	             while (a[j].compareTo(pivot) > 0 && j >= start && j >= i){
	                 j--;
	             }
	             if (j > i) {
	                 swap(a, i, j);
	             }
	         }
	             swap(a, start, j);
	             quickSort(a, start, j - 1);
	             quickSort(a, j + 1, end);
		 }
	 }
	private static void swap(String[] a, int i, int j){
	     String temp = a[i];
	     a[i] = a[j];
	     a[j] = temp;
	}
}
