package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class DerekDavid extends Contestant {

	

	public static void main(String[] args) {
		
		


		DerekDavid test = new DerekDavid();
		int[] arr = {1,2,3,4,5,6};
		System.out.println("The median is: " + test.sortAndGetMedian(arr));
		
		
		System.out.println("And the sorted array is: \n" + test.sort(arr));
		
	
		
		
	}

	@Override
	public Color getColor() {
		return new Color(104, 152, 225);
	}

	@Override
	public String getSpriteName() {
		return RYU;
	}

	public double sortAndGetMedian(int[] random) {
		int[] numArray = sort(random);
		double median;
		if (numArray.length % 2 == 0)
			median = ((double) numArray[numArray.length / 2] + (double) numArray[numArray.length / 2 - 1]) / 2;
		else
			median = (double) numArray[numArray.length / 2];
		return median;
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

	public int[] sort(int arr[]) {
		int n = arr.length;

		// The output character array that will have sorted arr
		int output[] = new int[n];

		// Create a count array to store count of inidividul
		// characters and initialize count array as 0
		int count[] = new int[256];
		for (int i = 0; i < 256; ++i)
			count[i] = 0;

		// store count of each character
		for (int i = 0; i < n; ++i)
			++count[arr[i]];

		// Change count[i] so that count[i] now contains actual
		// position of this character in output array
		for (int i = 1; i <= 255; ++i)
			count[i] += count[i - 1];

		// Build the output character array
		for (int i = 0; i < n; ++i) {
			output[count[arr[i]] - 1] = (int) arr[i];
			--count[arr[i]];
		}

		// Copy the output array to arr, so that arr now
		// contains sorted characters
		for (int i = 0; i < n; ++i)
			arr[i] = output[i];
		return output;
	}

}
