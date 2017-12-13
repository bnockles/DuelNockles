package sortomania.contestants;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import sortomania.Contestant;

public class VincentNRaymond extends Contestant {

	public static void main(String[] args) {
		VincentNRaymond test = new VincentNRaymond();
		int[] arr = { 4, 7, 10, 2, 18, 12, 34, 42, 23, 40, 56, 31, 8, 9, 124, 562, 26 };
		System.out.println("The median is: " + test.sortAndGetMedian(arr));

		System.out.println("And the sorted array is: \n" + Arrays.toString(sort(arr)));

	}

	public VincentNRaymond() {
		int[][] darr = new int[2][2];
		darr[0][0] = 5;
		darr[0][1] = 6;
		darr[1][0] = 6;
		darr[1][1] = 3;
		System.out.println("DOUBLE MEDIAN: " + sortMultiDim(darr));
		
	}

	@Override
	public Color getColor() {
		return new Color(0, 0, 255);
	}

	@Override
	public String getSpriteName() {
		return RYU;
	}

	public static int[] sort(int[] input) {

		// Largest place for a 32-bit int is the 1 billion's place
		for (int place = 1; place <= 1000000000; place *= 10) {
			// Use counting sort at each digit's place
			input = countingSort(input, place);
		}

		return input;
	}

	private static int[] countingSort(int[] input, int place) {
		int[] out = new int[input.length];

		int[] count = new int[10];

		for (int i = 0; i < input.length; i++) {
			int digit = getDigit(input[i], place);
			count[digit] += 1;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		for (int i = input.length - 1; i >= 0; i--) {
			int digit = getDigit(input[i], place);

			out[count[digit] - 1] = input[i];
			count[digit]--;
		}

		return out;

	}

	private static int getDigit(int value, int digitPlace) {
		return ((value / digitPlace) % 10);
	}

	@Override
	public double sortAndGetMedian(int[] random) {
		
		int[] arr = { 4, 7, 10, 2, 18, 12, 34, 42, 23, 40, 56, 31, 8, 9, 124, 562, 26 };
		System.out.println("MOSTLY SORTED:" + mostlySortAndGetMedian(arr));

		String[] strings = { "zz", "ab", "aa" };
		System.out.println(sortAndGetResultingIndexOf(strings, "ab"));

		// TODO Auto-generated method stub
		int[] sortedArray = sort(random);
		return getMedian(sortedArray);

	}

	public double getMedian(int[] sortedArray) {
		if (sortedArray.length % 2 == 1) {
			return sortedArray[(sortedArray.length - 1) / 2];
		} else {
			return ((sortedArray[sortedArray.length / 2]) + (sortedArray[(sortedArray.length / 2) - 1])) / 2;
		}
	}

	public static int partition(String[] stringArray, int idx1, int idx2) {
		String pivotValue = stringArray[idx1];
		while (idx1 < idx2) {
			String value1;
			String value2;
			while ((value1 = stringArray[idx1]).compareTo(pivotValue) < 0) {
				idx1 = idx1 + 1;
			}
			while ((value2 = stringArray[idx2]).compareTo(pivotValue) > 0) {
				idx2 = idx2 - 1;
			}
			stringArray[idx1] = value2;
			stringArray[idx2] = value1;
		}
		return idx1;
	}

	public static void QuicksortString(String[] stringArray, int idx1, int idx2) {
		if (idx1 >= idx2) {
			// we are done
			return;
		}
		int pivotIndex = partition(stringArray, idx1, idx2);
		QuicksortString(stringArray, idx1, pivotIndex);
		QuicksortString(stringArray, pivotIndex + 1, idx2);
	}

	public static void QuicksortString(String[] stringArray) {
		QuicksortString(stringArray, 0, stringArray.length - 1);
	}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		QuicksortString(strings);
		if (toFind.substring(0, 1).compareTo("A") > -1000) {
			// start from the end
			for (int i = strings.length - 1; i >= 0; i--) {
				if (strings[i].compareTo(toFind) == 0) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < strings.length - 1; i++) {
				if (strings[i].compareTo(toFind) == 0) {
					return i;
				}
			}
		}
		return -1;
	}

	public void insertionSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		insertionSort(mostlySorted);
		return getMedian(mostlySorted);
	}

	@Override
	public double sortMultiDim(int[][] grid) {
		// TODO Auto-generated method stub
		int count = 0;
		double[] medianHolder = new double[(grid.length - 1 )]; 
		for(int r = 0; r < grid.length - 1; r++) {
			int[] medianHolder2 = new int[grid.length-1];
			int counter2 = 0;
			for(int c = 0; c < grid[r].length - 1; c ++) {
				medianHolder2[counter2] = grid[r][c];
				counter2++;
			}
			medianHolder[count] = sortAndGetMedian(medianHolder2);	
			count++;
		}
		boolean sorted=true;
	  	double temp = 0;

	  while (sorted){
	     sorted = false;
	     for (int i=0; i < medianHolder.length-1; i++) 
	        if (medianHolder[i] > medianHolder[i+1]) {                      
	           temp       = medianHolder[i];
	           medianHolder[i]       = medianHolder[i+1];
	           medianHolder[i+1]     = temp;
	           sorted = true;
	        }     
	  }
		return getMedian(medianHolder);
	}
	private double getMedian(double[] sortedArray) {
		if (sortedArray.length % 2 == 1) {
			return sortedArray[(sortedArray.length - 1) / 2];
		} else {
			return ((sortedArray[sortedArray.length / 2]) + (sortedArray[(sortedArray.length / 2) - 1])) / 2;
		}
	}
	
	public static void sortCom(Comparable[] a) {
		quicksortCom(a, 0, a.length-1);
    }
	
    private static void quicksortCom(Comparable[] a, int low, int high) {
        if(low >= high) {
        	return;
        }
        int part = partitionA(a, low, high);
        quicksortCom(a, low, part-1);
        quicksortCom(a, part+1, high);
    }
    
    private static int partitionA(Comparable[] a, int low, int high) {
        int i = low + 1;
        int j = high;

        while(i <= j) {
            if(a[i].compareTo(a[low]) <= 0) { 
                i++; 
            }
            else if(a[j].compareTo(a[low]) > 0) { 
                j--;
            }
            else if(j < i) {
                break;
            }
            else {
            	 exchange(a, i, j);
            }
               
        }
        exchange(a, low, j);
        return j;
    }

    private static void exchange(Object[] a, int i, int j) {
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    

	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		sortCom(arr);
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].equals(toFind)) return i;
		}
		return -1;
	}

}
