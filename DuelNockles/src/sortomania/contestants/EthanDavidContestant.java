package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class EthanDavidContestant extends Contestant {
	
	public static void main(String[] args) {
		EthanDavidContestant test = new EthanDavidContestant();
		test.testSort();
	}

	public EthanDavidContestant() {

	}

	private void testSort() {
		int[] arr = {1,5,3,4};
		sortAndGetMedian(arr);
	}

	@Override
	public Color getColor() {
		return new Color(0,0,0);
	}

	@Override
	public String getSpriteName() {
		return KEN;
	}
	
	public int partition(int arr[], int low, int high)
	    {
	        int pivot = arr[high]; 
	        int i = (low-1);
	        for (int j=low; j<high; j++)
	        {
	            if (arr[j] <= pivot)
	            {
	                i++;
	 
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
	        }
	        int temp = arr[i+1];
	        arr[i+1] = arr[high];
	        arr[high] = temp;
	 
	        return i+1;
	    }

	   public void quickSort(int arr[], int low, int high)
	    {
	        if (low < high)
	        {
	            int pi = partition(arr, low, high);
	            quickSort(arr, low, pi-1);
	            quickSort(arr, pi+1, high);
	        }
	    }
	   
	   void insertionSort(int arr[])
	    {
	        int n = arr.length;
	        for (int i=1; i<n; ++i)
	        {
	            int key = arr[i];
	            int j = i-1;
	            while (j>=0 && arr[j] > key)
	            {
	                arr[j+1] = arr[j];
	                j = j-1;
	            }
	            arr[j+1] = key;
	        }
	    }

	@Override
	public double sortAndGetMedian(int[] random) {
		quickSort(random,0,random.length-1);
		if(random.length % 2 == 0) {
			System.out.println((double)(random[random.length/2] + random[random.length/2-1])/2);
			return (double)(random[random.length/2] + random[random.length/2-1])/2;
		}else {
			System.out.println(random[random.length/2]);
			return random[random.length/2];
		}
	}
	
	public static int myStrCmp(String a,String b){
		int i=0;
		int l=0;
		int s=0;
		int r=0;
		if(b.length()<=a.length()) 
		l=b.length();
		else
		l=a.length(); 
		for(i=0;i<l;i++){
		if(a.charAt(i)>b.charAt(i)){
		r=1;        
		}
		if(a.charAt(i)<b.charAt(i)){
		r=-1;        
		}
		}            
		return r;   
		}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		for(int i=0;i<strings.length;i++){
			for(int j=0;j<(strings.length-1);j++)  { 
			if(myStrCmp(strings[j],strings[j+1])==1) {
			String temp=strings[j];
			strings[j]=strings[j+1];
			strings[j+1]=temp;    
			}
			}
			} 
			for(int i=0;i<strings.length;i++){
				if(strings[i].equals(toFind)) {
					return i;
				}
			} 
			return -1;
	}

	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		double median = 0;
		insertionSort(mostlySorted);
		if(mostlySorted.length%2 != 0) {
			median += mostlySorted[(int)(mostlySorted.length/2) - 1];
		}
		else {
			median += (mostlySorted[0 + (mostlySorted.length/2)] + mostlySorted[(mostlySorted.length - mostlySorted.length/2)])/2;
		}
		return median;
	}

	@Override
	public double sortMultiDim(int[][] grid) {
		double median = 0;
		double[] medianOfMedians = new double[grid.length];
		for(int row = 0; row < grid.length; row++) {
			medianOfMedians[row] = sortAndGetMedian(grid[row]);
		}
		if(medianOfMedians.length%2 != 0) {
			median += medianOfMedians[(int)(medianOfMedians.length/2) - 1];
		}
		else {
			median += (medianOfMedians[0 + (medianOfMedians.length/2)] + medianOfMedians[(medianOfMedians.length - medianOfMedians.length/2)])/2;
		}
		return median;
	}

	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

}
