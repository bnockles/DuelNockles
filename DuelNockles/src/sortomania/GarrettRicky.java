package sortomania;

import java.awt.Color;

public class GarrettRicky extends Contestant {

	public static void main(String[] args) {
		GarrettRicky test = new GarrettRicky();
		int[] random = {0,1,2,3,4,5,6,7,8,9,10};
		test.sortAndGetMedian(random);
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSpriteName() {
		return KEN;
	}

	@Override
	public double sortAndGetMedian(int[] random) {
			Comparable[] tmp = new Comparable[random.length];
			mergeSort(random, tmp,  0,  random.length - 1);
		}


		private static void mergeSort(int[] random, Comparable [ ] tmp, int left, int right)
		{
			if( left < right )
			{
				int center = (left + right) / 2;
				mergeSort(random, tmp, left, center);
				mergeSort(random, tmp, center + 1, right);
				merge(random, tmp, left, center + 1, right);
			}
	}

		 private static void merge(int[] random, Comparable[ ] tmp, int left, int right, int rightEnd )
		    {
		        int leftEnd = right - 1;
		        int k = left;
		        int num = rightEnd - left + 1;

		        while(left <= leftEnd && right <= rightEnd)
		            if(random[left].compareTo(random[right]) <= 0)
		                tmp[k++] = random[left++];
		            else
		                tmp[k++] = random[right++];

		        while(left <= leftEnd)    // Copy rest of first half
		            tmp[k++] = random[left++];

		        while(right <= rightEnd)  // Copy rest of right half
		            tmp[k++] = random[right++];

		        // Copy tmp back
		        for(int i = 0; i < num; i++, rightEnd--)
		            random[rightEnd] = tmp[rightEnd];
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
