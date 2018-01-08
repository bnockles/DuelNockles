package sortomania;

import java.awt.Color;
import java.util.*;
import java.util.regex.*;
import java.math.*;
import java.io.*;
import java.util.Arrays;

public class NabeelAmanatSort extends Contestant {

	private static Comparable[] unsorted =  new Comparable[10000];
	private static Comparable[] unSorted =  new Comparable[10000];
	private int wrong = 0; 
	private static Comparable[] stringList= {"bcde","Abcd", "cdef", "Mnlo", "katie","jklmn"};
	
	public static void main(String[] args) {
		NabeelAmanatSort test = new NabeelAmanatSort();
		/*for(int i =0; i<10000; i++) {
		test.buildArray(unsorted, unSorted); 
		for(int a =0; a<50; i++) {
		test.sortAndGetMedian2(unSorted);
		test.sortAndGetMedian(unsorted);
		test.checkIfEqual(unsorted,unSorted);
		}
		}
		System.out.println(test.wrong);*/
		/*for(int i =0; i<2; i++) {
			test.build2DArray(unsorted, unSorted); 
			for(int a =0; a<5; a++) {
			System.out.println(test.sortMultiDim2(unSorted));
			System.out.println(test.sortMultiDim(unsorted));
			System.out.println(test.checkIfEqual(unsorted,unSorted));
			}
			}
		System.out.println(test.wrong);*/
		
		/*System.out.println(Arrays.toString(stringList));
		System.out.println(test.sortAndGetResultingIndexOf(stringList, "katie"));
		System.out.println(Arrays.toString(stringList));*/
		
		
		test.buildArray(unsorted, unSorted); 
		System.out.println(Arrays.toString(unSorted));
		System.out.println(test.sortAndSearch(unSorted, 43));
		System.out.println(Arrays.toString(unSorted));
		
	}
	public boolean checkIfEqual(int[][] array, int[][] array2) {
		for(int i =0 ; i<array.length; i++) {
			for(int a= 0; a<array[i].length; a++)
			if(!(array[i][a] == array2[i][a])) {
				wrong++;
				return false;
			}
		}
		return true;
	}
	public double sortMultiDim2(int[][] random) {
		double[] list = new double[random.length];
		for(int i =0; i<random.length; i++) {
			quickSortList(random[i], 0, random[i].length -1);
			list[i] =  findMedian(random[i]);
		}
		return findMedian(list);
		
	}
	public void build2DArray(int[][] array, int[][] jack) {
		for(int i =0; i<array.length; i++) {
			for(int a =0; a<array[i].length; a++) {
			array[i][a] = (int)(Math.random()*10000);
			jack[i][a] = array[i][a];
		}
		}
		
		
	}
	public void buildArray(Comparable[] array, Comparable[] jack) {
		for(int i =0; i<array.length; i++) {
			array[i] = (int)(Math.random()*10000);
			jack[i] = array[i];
		}
	}
	/*public boolean checkIfEqual(int[] array, int[] array2) {
		for(int i =0 ; i<array.length; i++) {
			if(!(array[i] == array2[i])) {
				wrong++;
				return false;
			}
		}
		return true; 
	}
	
		
	}*/
	@Override
	public Color getColor() {
		return new Color(10, 216, 182);
	}

	@Override
	public String getSpriteName() {
		
		return RYU;
	}
	
	
	//first problem
	@Override
	
	public double sortAndGetMedian(int[] random) {
		quickSortList(random, 0, random.length -1);
		int index = findMedian(random);
		return index;
	
	}
	/*public double sortAndGetMedian2(int[] random) {
		quickSortList(random, 0, random.length -1);
		int index = findMedian(random);
		return index;
	
	}*/
	public void quickSortList(int[] random, int left, int right) {
		if(left >= right) {
			return; 
		}
		else {
			int pivot = random[ (left + right) / 2 ];
			int index = partition(random, left, right, pivot);
			quickSortList(random, left, index-1);
			quickSortList(random, index, right);
		}
		
	}
	public int partition(int[] random, int left, int right, int pivot) {
		while(left<=right) {
			while(random[left] < pivot) {
				left++;
			}
			while(random[right] > pivot) {
				right--;
			}
			if(left <= right) {
				swap(random, left, right);
				left++;
				right--;
			}
		}
		return left;		
	}
	public void swap(int[] random, int left, int right) {
		int mid = random[left];
		random[left] =  random[right];
		random[right] = mid;
	}
	
	
	
	/* public void sort(int[] inputArr) {
         
	        if (inputArr == null || inputArr.length == 0) {
	            return;
	        }
	        int length = inputArr.length;
	        quickSort(inputArr, 0, length - 1);
	    }
	 
	    private void quickSort(int[] array, int lowerIndex, int higherIndex) {
	         
	        int i = lowerIndex;
	        int j = higherIndex;
	        // calculate pivot number, I am taking pivot as middle index number
	        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
	        // Divide into two arrays
	        while (i <= j) {
	            /*
	              In each iteration, we will identify a number from left side which 
	             is greater then the pivot value, and also we will identify a number 
	              from right side which is less then the pivot value. Once the search 
	              is done, then we exchange both numbers.
	             
	            while (array[i] < pivot) {
	                i++;
	            }
	            while (array[j] > pivot) {
	                j--;
	            }
	            if (i <= j) {
	                exchangeNumbers(array, i, j);
	                //move index to next position on both sides
	                i++;
	                j--;
	            }
	        }
	        // call quickSort() method recursively
	        if (lowerIndex < j)
	            quickSort(array, lowerIndex, j);
	        if (i < higherIndex)
	            quickSort(array, i, higherIndex);
	    }
	 
	    private void exchangeNumbers(int[] array, int i, int j) {
	        int temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	    }
	*/
	//Second thing 
	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		sort(strings);
		int index = -1;
		for (int i=0;i<strings.length;i++) {
		    if (strings[i].equals(toFind)) {
		        return i;
		    }
		}
		return -1; 
		
	}
    public void sort(String[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(String[] array, int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        String pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];

        while (i <= j) {
            while (array[i].compareTo(pivot) < 0) {
                i++;
            }

            while (array[j].compareTo(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                exchangeNames(array,i, j);
                i++;
                j--;
            }
        }
        //call quickSort recursively
        if (lowerIndex < j) {
            quickSort(array,lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(array,i, higherIndex);
        }
    }

    void exchangeNames(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
	//third thing
	@Override
	public double mostlySortAndGetMedian(int[] random) {
		quickSortList(random, 0, random.length -1);
		int index = findMedian(random);
		return index;
	
	}
	//fourth thing 
	@Override 
	public double sortMultiDim(int[][] grid) {
		double[] list= new double[grid.length];
		for(int i =0; i<grid.length; i++) {
			quickSortList(grid[i], 0, grid[i].length -1);
			double index = findMedian(grid[i]);
			list[i]= index;
		}
		return findMedian(list); 
	}
	//fifth task
	@Override
	
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		qsort(arr, 0, arr.length -1);
		for (int i=0; i<arr.length; i++) {
		    if (arr[i].equals(toFind)) {
		        return i;
		    }
		}
		return -1; 
	}
	public void qsort(Comparable[] arr, int a, int b) {
        if (a < b) {
            int i = a, j = b;
            Comparable x = arr[(i + j) / 2];

            do {
                while (arr[i].compareTo(x) < 0) i++;
                while (x.compareTo(arr[j]) < 0) j--;

                if ( i <= j) {
                    Comparable tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i++;
                    j--;
                }

            } while (i <= j);

            qsort(arr, a, j);
            qsort(arr, i, b);
        }
    }

	
	
	public int findMedian(int[] random) {
		if(random.length == 1) {
			return random[0];
		}
		else if(random.length%2 ==0) { 
			return (random[random.length/2]+random[random.length/2+1])/2;
		}
		else {
			return random[random.length/2];
		}
	}
	public double findMedian(double[] random) {
		if(random.length == 1) {
			return random[0];
		}
		else if(random.length%2 ==0) { 
			return (random[random.length/2]+random[random.length/2+1])/2;
		}
		else {
			return random[random.length/2];
		}
	}
}