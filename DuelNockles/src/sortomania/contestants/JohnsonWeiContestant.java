package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class JohnsonWeiContestant extends Contestant {
	
	public static void main(String[] args) {
		int[] nums = {18,44,5,21,90,87,65,98};
		JohnsonWeiContestant test = new JohnsonWeiContestant();
		System.out.println(test.sortAndGetMedian(nums));
	}

	public JohnsonWeiContestant() {
		
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSpriteName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double sortAndGetMedian(int[] random) {
		int last = random.length -1;
		int max = random.length;
		quickSort(random, 0, last);
		
		if(last % 2 == 0) {
			return (random[max/2] + random[(max/2)-1]) / 2;
		}else return random[(max-1)/2];
	}
	
	private void quickSort(int[] array, int lowerIndex, int higherIndex) {
		int i = lowerIndex;
        int j = higherIndex;
        
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        
        while (i <= j) {
            
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
            	int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(array,lowerIndex, j);
        if (i < higherIndex)
            quickSort(array,i, higherIndex);
        
        
    }
	
	private void quickSort(Comparable[] array, int lowerIndex, int higherIndex) {
		int i = lowerIndex;
        int j = higherIndex;
        
        Comparable pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        
        while (i <= j) {
            while (array[i].compareTo(pivot) < 0) {
                i++;
            }
            while (array[i].compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j) {
            	Comparable temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
                j--;
            }
        }
        
        if (lowerIndex < j)
            quickSort(array,lowerIndex, j);
        if (i < higherIndex)
            quickSort(array,i, higherIndex);
        
        
    }
	

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		int length = strings.length - 1;
		quickSort(strings, 0, length);
		return binarySearch(strings, 0, length, toFind);
	}

	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		int n = mostlySorted.length;  
		int temp = 0;
		
		for(int i=0; i < n; i++){  
			for(int j=1; j < (n-i); j++){  
	            if(mostlySorted[j-1] > mostlySorted[j]){  
		            temp = mostlySorted[j-1];  
	                mostlySorted[j-1] = mostlySorted[j];  
	                mostlySorted[j] = temp;  
	            }  
            }  
		}
		
		if(n % 2 == 0) {
			return (mostlySorted[n/2] + mostlySorted[(n/2)-1]) / 2;
		}else return mostlySorted[(n-1)/2];
	}

	@Override
	public double sortMultiDim(int[][] grid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		int length = arr.length - 1;
		quickSort(arr, 0, length);
		return binarySearch(arr, 0, length, toFind);
	}
	
	public int binarySearch(Comparable[] arr, int lower, int upper, Comparable target) {
		if(upper >= lower) {
			int mid = lower + (upper-lower)/2;
			
			if(arr[mid].equals(target)) {
				return mid;
			}
			if(arr[mid].compareTo(target) > 0 ) {
				return binarySearch(arr, lower, mid-1, target);
			}
			else return binarySearch(arr,mid+1,upper,target);
		}
		return -1;
	}

}
