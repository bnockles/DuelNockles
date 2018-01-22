package sortomania.contestants;

import java.awt.Color;
import java.util.ArrayList;

import sortomania.Contestant;

public class Sisiame extends Contestant {

	@Override
	public Color getColor() {
		
		return new Color(107, 63, 160);
		
	}

	@Override
	public String getSpriteName() {
		
		return CAMMY;
		
	}

	@Override
	public double sortAndGetMedian(int[] random) {
		
		random = quicksort(random);
		return median(random);
		
	}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		
		strings = quicksort(strings);
		return binarySearch(strings, 0, strings.length, toFind);
		
	}

	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		
		mostlySorted = insertionSort(mostlySorted);
		return median(mostlySorted);
		
	}

	@Override
	public double sortMultiDim(int[][] grid) {
		
		double[] medians = new double[grid.length];
		
		for(int i = 0; i < medians.length; i++) {
			medians[i] = median(quicksort(grid[i]));
		}
		
		return median(medians);
		
		
	}

	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		
		arr = quicksort(arr);
		return binarySearch(arr, 0, arr.length, toFind);
		
	}
	
///////////////////////////////Integers/////////////////////////////////////
	public int[] insertionSort(int[] arr) {
		
		int temp;
		
		for(int i = 1; i < arr.length; i++) {
			
			for(int n = i; n > 0; n--) {
				
				if(arr[n] < arr[n - 1]) {
					temp = arr[n];
                    arr[n] = arr[n - 1];
                    arr[n - 1] = temp;
				}
				
			}
			
		}
		
		return arr;
		
	}
	
	public int[] quicksort(int[] arr) {
		
		if(arr.length > 43) {
		
			ArrayList<Integer> list = intArrayToArrayList(arr);
					
			int pivot = list.get((int)(Math.random() * list.size()));
					
			ArrayList<Integer> lower = new ArrayList<Integer>();
			ArrayList<Integer> upper = new ArrayList<Integer>();
					
			for(int i = 0; i < list.size(); i++) {
						
				if(list.get(i) <= pivot) {
					
					if(i == list.indexOf(pivot)) {
						continue;
					}
					
					lower.add(list.get(i));
				} else {
					upper.add(list.get(i));
				}
						
			}
				
			return join(quicksort(arrayListToIntArray(lower)), pivot, quicksort(arrayListToIntArray(upper)));
		
		} else {
			return insertionSort(arr);
		}
		
	}
	
	private int[] join(int[] lower, int pivot, int[] upper) {
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		for(int num: lower) {
			temp.add(num);
		}
		
		temp.add(pivot);
		
		for(int num: upper) {
			temp.add(num);
		}
		
		return arrayListToIntArray(temp);
		
	}

	private double median(int[] arr) {
		
		if(arr.length % 2 == 1) {
			return average(arr[(int)(arr.length/2)], arr[(int)(arr.length/2)] + 1);
		}
		
		return arr[(int)(arr.length / 2)];
		
	}

	private double median(double[] arr) {
		
		if(arr.length % 2 == 1) {
			return average(arr[(int)(arr.length/2)], arr[(int)(arr.length/2)] + 1);
		}
		
		return arr[(int)(arr.length / 2)];
		
	}
	
	private double average(double a, double b) {
		
		return (a + b) / 2;
		
	}
	
	public ArrayList<Integer> intArrayToArrayList(int[] arr) {
		
		ArrayList<Integer> intList = new ArrayList<Integer>();
		
		for(int num: arr) {
			intList.add(num);
		}
		
		return intList;
		
	}
	
	public int[] arrayListToIntArray(ArrayList<Integer> list) {
		
		int[] intArr = new int[list.size()];
		
		for(int i = 0; i < intArr.length; i++) {
			intArr[i] = list.get(i);
		}
		
		return intArr;
		
	}
	
//////////////////////////////Comparables/////////////////////////////////////
	
	public Comparable[] insertionSort(Comparable[] arr) {
		
		Comparable temp;
		
		for(int i = 1; i < arr.length; i++) {
			
			for(int n = i; n > 0; n--) {
				
				if(arr[n].compareTo(arr[n - 1]) < 0) {
					temp = arr[n];
                    arr[n] = arr[n - 1];
                    arr[n - 1] = temp;
				}
				
			}
			
		}
		
		return arr;
		
	}
	
	public Comparable[] quicksort(Comparable[] arr) {
		
		if(arr.length > 43) {
		
			ArrayList<Comparable> list = comparableArrayToArrayList(arr);
					
			Comparable pivot = list.get((int)(Math.random() * list.size()));
					
			ArrayList<Comparable> lower = new ArrayList<Comparable>();
			ArrayList<Comparable> upper = new ArrayList<Comparable>();
					
			for(int i = 0; i < list.size(); i++) {
						
				if(list.get(i).compareTo(pivot) <= 0) {
				
					if(i == list.indexOf(pivot)) {
						continue;
					}
					
					lower.add(list.get(i));
				} else {
					upper.add(list.get(i));
				}
						
			}
				
			return join(quicksort(arrayListToComparableArray(lower)), pivot, quicksort(arrayListToComparableArray(upper)));
		
		} else {
			return insertionSort(arr);
		}
		
	}
	
	private Comparable[] join(Comparable[] lower, Comparable pivot, Comparable[] upper) {
		
		ArrayList<Comparable> temp = new ArrayList<Comparable>();
		
		for(Comparable comp: lower) {
			temp.add(comp);
		}
		
		temp.add(pivot);
		
		for(Comparable comp: upper) {
			temp.add(comp);
		}
		
		return arrayListToComparableArray(temp);
		
	}
	
	public ArrayList<Comparable> comparableArrayToArrayList(Comparable[] arr) {
		
		ArrayList<Comparable> compList = new ArrayList<Comparable>();
		
		for(Comparable comp: arr) {
			compList.add(comp);
		}
		
		return compList;
		
	}
	
	public Comparable[] arrayListToComparableArray(ArrayList<Comparable> list) {
		
		Comparable[] compArr = new Comparable[list.size()];
		
		for(int i = 0; i < compArr.length; i++) {
			compArr[i] = list.get(i);
		}
		
		return compArr;
		
	}

	public static int binarySearch(Comparable[] searchThis, int startIndex, int endIndex, Comparable toFind) {
		
		int midIdx = (int)((endIndex + startIndex) / 2);
		
		if(endIndex > 0) { 
			
			if(searchThis[midIdx].equals(toFind)) {
				return midIdx;
			}
			
			if(searchThis[midIdx].compareTo(toFind) < 0) {
				return binarySearch(searchThis, midIdx + 1, endIndex, toFind);
			}
			
			return binarySearch(searchThis, startIndex, midIdx - 1, toFind);
			
		}
		
		return -1;
		
	}///////////////////////////////Strings/////////////////////////////////////
	
	public String[] insertionSort(String[] arr) {
		
		String temp;
		
		for(int i = 1; i < arr.length; i++) {
			
			for(int n = i; n > 0; n--) {
				
				if(arr[n].compareTo(arr[n - 1]) < 0) {
					temp = arr[n];
                    arr[n] = arr[n - 1];
                    arr[n - 1] = temp;
				}
				
			}
			
		}
		
		return arr;
		
	}
	
	public String[] quicksort(String[] arr) {
		
		if(arr.length > 43) {
		
			ArrayList<String> list = stringArrayToArrayList(arr);
					
			String pivot = list.get((int)(Math.random() * list.size()));
					
			ArrayList<String> lower = new ArrayList<String>();
			ArrayList<String> upper = new ArrayList<String>();
					
			for(int i = 0; i < list.size(); i++) {
						
				if(list.get(i).compareTo(pivot) <= 0) {
				
					if(i == list.indexOf(pivot)) {
						continue;
					}
					
					lower.add(list.get(i));
				} else {
					upper.add(list.get(i));
				}
						
			}
				
			return join(quicksort(arrayListToStringArray(lower)), pivot, quicksort(arrayListToStringArray(upper)));
		
		} else {
			return insertionSort(arr);
		}
		
	}
	
	private String[] join(String[] lower, String pivot, String[] upper) {
		
		ArrayList<String> temp = new ArrayList<String>();
		
		for(String num: lower) {
			temp.add(num);
		}
		
		temp.add(pivot);
		
		for(String num: upper) {
			temp.add(num);
		}
		
		return arrayListToStringArray(temp);
		
	}
	
	public ArrayList<String> stringArrayToArrayList(String[] arr) {
		
		ArrayList<String> intList = new ArrayList<String>();
		
		for(String string: arr) {
			intList.add(string);
		}
		
		return intList;
		
	}
	
	public String[] arrayListToStringArray(ArrayList<String> list) {
		
		String[] strArr = new String[list.size()];
		
		for(int i = 0; i < strArr.length; i++) {
			strArr[i] = list.get(i);
		}
		
		return strArr;
		
	}

	public static int binarySearch(String[] searchThis, int startIndex, int endIndex, String toFind) {
		
		int midIdx = (int)((endIndex + startIndex) / 2);
		
		if(endIndex > 0) { 
			
			if(searchThis[midIdx].equals(toFind)) {
				return midIdx;
			}
			
			if(searchThis[midIdx].compareTo(toFind) < 0) {
				return binarySearch(searchThis, midIdx + 1, endIndex, toFind);
			}
			
			return binarySearch(searchThis, startIndex, midIdx - 1, toFind);
			
		}
		
		return -1;
		
	}
	
}
