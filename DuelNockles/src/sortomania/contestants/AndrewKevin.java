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
		return "E_HONDA";
	}

	@Override
	public   double sortAndGetMedian(int[] random) {
		int n = random.length;
        char output[] = new char[n];
        int count[] = new int[10000];
        for (int i=0; i<10000; ++i)
            count[i] = 0;
        for (int i=0; i<n; ++i)
            ++count[random[i]];
        for (int i=1; i<=10000-1; ++i)
            count[i] += count[i-1];
        for (int i = 0; i<n; ++i)
        {
            output[count[random[i]]-1] = (char) random[i];
            --count[random[i]];
        }
        for (int i = 0; i<n; ++i)
            random[i] = output[i];
		
        if(random.length%2 == 0) {
        	return (random[random.length/2] + random[random.length/2+1])/2;
        }
        	return random[random.length/2];
	}
	
	void swap(int a, int b)
	{
	    int t = a;
	    a = b;
	    b = t;
	}
	int partition (int arr[], int low, int high)
	{
	    int pivot = arr[high];
	    int i = (low - 1);
	    for (int j = low; j <= high- 1; j++)
	    {
	        if (arr[j] <= pivot)
	        {
	            i++;
	            swap(arr[i], arr[j]);
	        }
	    }
	    swap(arr[i + 1], arr[high]);
	    return (i + 1);
	}
	void quickSort(int arr[], int low, int high)
	{
	    if (low < high)
	    {
	        int pi = partition(arr, low, high);
	        quickSort(arr, low, pi - 1);
	        quickSort(arr, pi + 1, high);
	    }
	}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		// TODO Auto-generated method stub
		return 0;
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
