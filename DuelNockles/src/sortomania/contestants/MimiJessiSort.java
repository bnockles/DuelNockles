package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class MimiJessiSort extends Contestant{
	
	private int[] random;
    private int number;

	@Override
	public Color getColor() {
		return new Color(201, 170, 254);
	}

	@Override
	public String getSpriteName() {
		return CHUN_LI;
	}

	@Override
	public double sortAndGetMedian(int[] random) {
		if (random == null || random.length==0){
            return ;
        }
        this.random = random;
        number = random.length;
        quickSort(0, number - 1);
        
        
        if(random.length % 2 == 0) {
        	
        }
        else if (random.length % 2 == 1) {
        	return random[random.length/2];
        }
	}

	/**
	 * helper method for sortAndGetMedian
	 * @return
	 */
	public void quickSort(int low, int high) {
		int i = low;
		int j = high;
		//  
		int pivot = random[low + (high - low)/2];
		
		while(i <= j) {
			while(random[i] < pivot) {
				i++;
			}
			while(random[j] > pivot) {
				j--;
			}
			if ( i <= j) {
				exchange(i,j);
				i++;
				j--;
			}
		}
		if (low < j)
            quickSort(low, j);
        if (i < high)
            quickSort(i, high);
	}

	private void exchange(int i, int j) {
		int temp = random[i];
        random[i] = random[j];
        random[j] = temp;
	}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		
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
