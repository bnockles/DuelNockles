package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class Coby extends Contestant {

	private int[] numbers;
	private int[] helper;
	
	private int number;
	
	public static void main(String args[]) {
		Coby test = new Coby();
		int[] arr = {4,6,1,2,8,9,5,3,7};
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
//		sort(strings);
		return bsearch(toFind,strings,0,strings.length-1);
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
		return getMedian(medians);
	}

	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		return 0;
	}

	 private void mergesort(int low, int high) {
		 if (low < high) {
			int middle = low + (high - low) / 2;
	 		mergesort(low, middle);
	 		mergesort(middle + 1, high);
	 		merge(low, middle, high);
		 }
	 }
	 public void sort(int[] values) {
	        this.numbers = values;
	        number = values.length;
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
	 
	 private int bsearch(String word, String [] words, int a, int b) {
		if(b <= a) {
			return -1;
		}
		if(b - a == 1) {
			return words[a].equals(word) ? a : -1;
		}
		int pivot = (a + b)/2;
		if(word.compareTo(words[pivot]) < 0) {
			return bsearch(word, words, 0, pivot);
		} else {
			if(word.compareTo(words[pivot]) > 0) {
				return bsearch(word, words, pivot, b);
			}
		}
		return pivot;
	 }
	 
	 private double getMedian(int[] random) {
		if(random.length % 2 == 1) {
			return random[(int)(random.length/2)];
		}else {
			return (random[(int)(random.length/2)]+random[(int)(random.length/2)-1])/2;
		}
	 }
}
