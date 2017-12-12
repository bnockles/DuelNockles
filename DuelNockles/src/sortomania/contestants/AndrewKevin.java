package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class AndrewKevin extends Contestant{
	
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return new Color(205,197,191);
	}

	@Override
	public String getSpriteName() {
		// TODO Auto-generated method stub
		return "CHUN_LI";
	}
	private int array[];
    private int length;
    
    /**------------------------------------------**/
	@Override
	public   double sortAndGetMedian(int[] random) {
		sort(random);
		if(random.length%2 ==0) {
			return ((random[random.length/2]+random[(random.length/2)+1])/2);
		}
		return random[(int)((random.length/2))];
	}
	 public void sort(int[] inputArr) {
         
	        if (inputArr == null || inputArr.length == 0) {
	            return;
	        }
	        this.array = inputArr;
	        length = inputArr.length;
	        quickSort(0, length - 1);
	    }
	
	private void quickSort(int lowerIndex, int higherIndex) {
        
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
                exchangeNumbers(i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
  /**------------------------------------------**/
	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		mergeSort(strings);
		for(int i = 0; i < strings.length; i++) {
			if(strings[i].equals(toFind)) {
				return i;
			}
		}
		return -1;
	}
	
    public static void mergeSort(String[] names) {
        if (names.length >= 2) {
            String[] left = new String[names.length / 2];
            String[] right = new String[names.length - names.length / 2];

            for (int i = 0; i < left.length; i++) {
                left[i] = names[i];
            }

            for (int i = 0; i < right.length; i++) {
                right[i] = names[i + names.length / 2];
            }

            mergeSort(left);
            mergeSort(right);
            merge(names, left, right);
        }
    }

    public static void merge(String[] names, String[] left, String[] right) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < names.length; i++) {
            if (b >= right.length || (a < left.length && left[a].compareToIgnoreCase(right[b]) < 0)) {
                names[i] = left[a];
                a++;
            } else {
                names[i] = right[b];
                b++;
            }
        }
    }
    /**------------------------------------------**/
	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		 int n = mostlySorted.length;
	        for (int i=1; i<n; ++i)
	        {
	            int key = mostlySorted[i];
	            int j = i-1;
	            while (j>=0 && mostlySorted[j] > key)
	            {
	                mostlySorted[j+1] = mostlySorted[j];
	                j = j-1;
	            }
	            mostlySorted[j+1] = key;
	        }
		return 0;
	}
	 /**------------------------------------------**/
	@Override
	public double sortMultiDim(int[][] grid) {
		// TODO Auto-generated method stub
		return 0;
	}
	 /**------------------------------------------**/
	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

}
