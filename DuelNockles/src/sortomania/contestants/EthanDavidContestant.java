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
		String[] stringArr = {"sdljad", "asc", "Abc"};
		int[][] arr = new int[3][2];
		int[] arr1 = {1,4,5,8,11,7};
		arr[0][0] = 50;
		arr[0][1] = 100;
		arr[1][0] = 19;
		arr[1][1] = 14;
		arr[2][0] = 21;
		arr[2][1] = 15;
		sortMultiDim(arr);
		sortAndGetMedian(arr1);
		sortAndGetResultingIndexOf(stringArr, "Abc");
		System.out.println(stringArr);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.deepToString(arr));
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
	   
	  public void insertionSort(int arr[])
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
			return (double)(random[random.length/2] + random[random.length/2-1])/2;
		}else {
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
		insertionSort(mostlySorted);
		if(mostlySorted.length % 2 == 0) {
			System.out.println((double)(mostlySorted[mostlySorted.length/2] + mostlySorted[mostlySorted.length/2-1])/2);
			return (double)(mostlySorted[mostlySorted.length/2] + mostlySorted[mostlySorted.length/2-1])/2;
		}else {
			System.out.println(mostlySorted[mostlySorted.length/2]);
			return mostlySorted[mostlySorted.length/2];
		}
	}   

	@Override
	public double sortMultiDim(int[][] grid) {
		double median = 0;
		double[] medianOfMedians = new double[grid.length];
		for(int i = 0; i < grid.length; i++) {
			medianOfMedians[i] = sortAndGetMedian(grid[i]);
		}
		if(medianOfMedians.length%2 != 0) {
			median = medianOfMedians[medianOfMedians.length/2];//medianOfMedians[(int)(medianOfMedians.length/2) - 1];
		}
		else {
			double x = (medianOfMedians[medianOfMedians.length/2] + medianOfMedians[medianOfMedians.length/2-1])/2;
			median = x;
		}
		return median;
	}

	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

}
