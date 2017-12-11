package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class EthanDavidContestant extends Contestant {
	
	private static int[] arr;

	public EthanDavidContestant() {
		sortAndGetMedian(arr);
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

	   public void sort(int arr[], int low, int high)
	    {
	        if (low < high)
	        {
	            int pi = partition(arr, low, high);
	            sort(arr, low, pi-1);
	            sort(arr, pi+1, high);
	        }
	    }

	@Override
	public double sortAndGetMedian(int[] random) {
		double median = 0;
		System.out.println(random + " non-sorted");
		sort(random,0,random.length);
		System.out.println(random + " sorted");
		if(random.length%2 != 0) {
			median += random[(int)(random.length/2) - 1];
		}
		else {
			median += (random[0 + (random.length/2)] + random[(random.length - random.length/2)])/2;
		}
		return median;
	}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		int index = 0;
		
		return index;
	}

	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		double median = 0;
		//insertion is the quickest
		return median;
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

	public static void main(String[] args) {
		int[] arr = {4, 7,10, 2,18,12, 34, 42, 23, 40, 56, 31, 8};
		EthanDavidContestant test = new EthanDavidContestant();
		
	}

}
