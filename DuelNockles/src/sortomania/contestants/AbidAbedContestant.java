package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class AbidAbedContestant extends Contestant
{

	public static void main(String[] args)
	{
		AbidAbedContestant ab = new AbidAbedContestant();
		int[] x = { 9, 2, 4, 7, 3, 7, 10 };
		System.out.println(Arrays.toString(x));
 
		int low = 0;
		int high = x.length - 1;
 
		ab.insertionSort(x);
		System.out.println(Arrays.toString(x));
		System.out.println(ab.mostlySortAndGetMedian(x));
		
	}
	@Override
	public Color getColor() 
	{
		return new Color(255,0,182);
	}

	@Override
	public String getSpriteName() 
	{
		return DEE_JAY;
	}
	
	@Override
	public double sortAndGetMedian(int[] random) 
	{
		quickSort(random,0,random.length-1);
		return median(random);
		
	}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) 
	{
		insertionSort(mostlySorted);
		return median(mostlySorted);
	}

	@Override
	public double sortMultiDim(int[][] grid) 
	{
		double medians[] = new double[grid[0].length];
		for(int i=0;i < grid[0].length;i++) {
			for(int j=0; j<grid.length;j++) {
				sortAndGetMedian(int)
			}
		}
	}

	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) 
	{
		// TODO Auto-generated method stub
		return 0;
	} 
	public void insertionSort(int array[]) 
	{
        int n = array.length;
        for (int j = 1; j < n; j++) 
        {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) 
            {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
            
        }
    }
	public  void quickSort(int[] arr, int low, int high) 
	{
		
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low;
		int j = high;
		while (i <= j) 
		{
			while (arr[i] < pivot) 
			{
				i++;
			}
 
			while (arr[j] > pivot)
			{
				j--;
			}
 
			if (i <= j) 
			{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}	
    
    private  double median(int[] random)
    {
    	if(random.length % 2 == 1)
		{
			return random[(random.length-1)/2];
		}
		else if(random.length % 2 == 0)
		{
			int x = (random.length)/2;
			return (double)(random[x] + random[x-1])/2;
		}
		else
		{
			return -1;
		}
    	
    }

}
