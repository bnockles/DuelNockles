package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class AbidAbedContestant extends Contestant
{

	public static void main(String[] args)
	{
		AbidAbedContestant ab = new AbidAbedContestant();
		int[] numbers = new int[1000];
		String[] toppings = {"Cheese", "Pepperoni", "Black Olives"};
		quicksort(toppings,0,toppings.length-1);
		Sysyem.out.println(Arrays.toString(topppings));
		
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
	public int sortAndSearch(Comparable[] arr, Comparable toFind) 
	{
		
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
		double medians[] = new double[grid.length];
		for(int i=0;i < grid.length;i++) 
		{
			medians[i] = sortAndGetMedian(grid[i]);
		}
		return sortAndGetMedian(medians);
	}

	private double sortAndGetMedian(double[] random) 
	{
		quickSort(random,0,random.length-1);
		return median(random);
	}
	private double median(double[] random) 
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
	private void quickSort(double[] arr, int low, int high) 
	{
			
			if (low >= high)
				return;
	 
			// pick the pivot
			int middle = low + (high - low) / 2;
			int pivot = (int) arr[middle];
	 
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
					int temp = (int) arr[i];
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
 
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}	
    
    private double median(int[] random)
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
    private static void quickSort(String[] a, int start, int end)
    {
            int i = start;
            int j = end;

           
            if (j - i >= 1)
            {
              
                String pivot = a[i];
              
                while (j > i)
                {
                    while (a[i].compareTo(pivot) < 0 && i <= end && j > i){
                        i++;
                    }
          
                    while (a[j].compareTo(pivot) > 0 && j >= start && j >= i){
                        j--;
                    }
                  
                    if (j > i)
                        swap(a, i, j);
                }
                swap(a, start, j);
                quickSort(a, start, j - 1);
                quickSort(a, j + 1, end);
            }
        }
        private static void swap(String[] a, int i, int j)
        {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        }

}
