package sortomania.contestants;

import java.awt.Color;
import java.util.Arrays;

import sortomania.Contestant;

public class YonathanDavid extends Contestant{


	public static void main(String[] args) {
		int[] a = {2, 6, 3, 6};
		YonathanDavid test = new YonathanDavid();
		double x = test.mostlySortAndGetMedian(a);
		System.out.println(Arrays.toString(a));
		System.out.println(x);
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return new Color(0,0,0);
	}

	@Override
	public String getSpriteName() {
		// TODO Auto-generated method stub
		return  CAMMY;
	}

	@Override
	public double sortAndGetMedian(int[] arr) {
		//Yonathan
		return 0;
	}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		//David
		return 0;
	}

	@Override
	public  double mostlySortAndGetMedian(int[] arr) {
		// make sure median is returned correctly
		        int n = arr.length;
		        for (int i = 0; i < n-1; i++)
		            for (int j = 0; j < n-i-1; j++)
		                if (arr[j] > arr[j+1])
		                {
		                    // swap temp and arr[i]
		                    int temp = arr[j];
		                    arr[j] =arr[j+1];
		                    arr[j+1] = temp;
		                }
		        if(arr.length%2==0) {
		        	return ((double)(arr[arr.length/2-1]+arr[arr.length/2])/2);
		        }
		        return arr[(arr.length-1)/2];
		    }
	


	@Override
	public double sortMultiDim(int[][] grid) {
		// David
		return 0;
	}

	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		
		return 0;
	}


}
