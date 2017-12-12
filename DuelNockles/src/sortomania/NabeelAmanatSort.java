package sortomania;

import java.awt.Color;
import java.util.Arrays;

public class NabeelAmanatSort extends Contestant {

	private static int[] unsorted = {2,555,3,67,9999,45,32,34,576};
	private static String[] stringList= {"b","A", "c", "M", "k","j"};
	private int index =0; 
	public static void main(String[] args) {
		NabeelAmanatSort test = new NabeelAmanatSort(); 
		/*First test
		 * 
		 * 
		
		System.out.println(Arrays.toString(unsorted));
		double x = test.sortAndGetMedian(unsorted);
		System.out.println(x);
		System.out.println(Arrays.toString(unsorted));*/
		//Second test
		System.out.println(Arrays.toString(stringList));
		int x = test.sortAndGetResultingIndexOf(stringList, "K");
		System.out.println(x);
	}
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
	int low= 9999;
	int high =0;
	for(int i=0; i<random.length;i++) {
		if(random[i] > high) {
			high = i;
		}
		if(random[i] < low) {
			low = i;
		}
	}
		
	return quickSort(random, low, high);
	}
	public double quickSort(int[] arr, int low, int high) {
		double median =0;
		
		int i = low;
		int j = high;
        
        int pivot = arr[(int)(Math.random()*(arr.length-1))];


        while (i <= j) {
           
            while (arr[i] < pivot) {
                i++;
            }
           
            while (arr[j] > pivot) {
                j--;
            }

            
            if (i <= j) {
                exchange(arr,i, j);
                i++;
                j--;
            }
        }
 
        if (low < j)
            quickSort(arr,low, j);
        if (i < high)
            quickSort(arr, i, high);
		
		if(arr.length%2 == 0) {
			return (arr[(int)(arr.length/2)] + arr[(int)(arr.length/2)-1])/2;
		}
		else
			return arr[(int)(arr.length/2)];
	}
	public void exchange(int[] arr, int i, int j) {
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }
	/*public void testQuickSort() {
	        for (Integer i : unsorted) {
	            System.out.println(i + " ");
	        }
	        long startTime = System.currentTimeMillis();

	        NabeelAmanatSort sorter = new NabeelAmanatSort();
	        
	        long stopTime = System.currentTimeMillis();
	        long elapsedTime = stopTime - startTime;
	        System.out.println("Quicksort " + elapsedTime);

	        if (!validate(unsorted)) {
	            System.out.println("Should not happen");
	        }
	    }
	private boolean validate(int[] numbers) {
	        for (int i = 0; i < numbers.length - 1; i++) {
	            if (numbers[i] > numbers[i + 1]) {
	                return false;
	            }
	        }
	        return true;
	    }
	*/
	//Second thing 
	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		strings = sort(strings, toFind);
		return index-1;
	}

	public String[] sort(String[] strings, String toFind) {
		String[] list = new String[strings.length];
		String[] alphabet = new  String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		int b = 0; 
		for(int i = 0; i<alphabet.length; i++) {
			for(int a=0; a<strings.length;a++) {
				if(alphabet[i].equals(strings[a].toLowerCase())){
					list[b] = strings[a];
					b++;
				}
				if(strings[a].toLowerCase().equals(toFind.toLowerCase())) {
					index =b-1;
				}
			}
		}
		return list;
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
