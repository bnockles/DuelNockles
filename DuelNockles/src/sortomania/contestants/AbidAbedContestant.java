package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class AbidAbedContestant extends Contestant
{

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
		quickSort(0,random.length-1,random);
		
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double sortMultiDim(int[][] grid) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) 
	{
		// TODO Auto-generated method stub
		return 0;
	}
	private void quickSort(int low, int high,int[] numbers) 
	{
        int i = high, j = low;
       
        int pivot = numbers[low + (high-low)/2];

        
        while (i <= j) 
        {
       
            while (numbers[i] < pivot) 
            {
                i++;
            }
          
            while (numbers[j] > pivot) 
            {
                j--;
            }

            if (i <= j) {
                exchange(i, j,numbers);
                i++;
                j--;
            }
        }
      
        if (low < j)
            quickSort(low, j,numbers);
        if (i < high)
            quickSort(i, high,numbers);
    }

    private void exchange(int i, int j,int[] numbers) 
    {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    private double median(int[] numbers)
    {
    	if(numbers.length % 2 == 0)
    	{
    		
    	}
		return ;
    	
    }

}
