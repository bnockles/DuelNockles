package sortomania;

import java.awt.Color;
import java.util.Arrays;

public class CarsonSort extends Contestant{

	private static int array[];
	private int length;

	public static void main(String a[]){
		int[] input = {24,2,45,20,56,75,2,56,99,53,12};
		CarsonSort.quickSort(input, 0, input.length - 1);
		sortAndGetMedian(input);
		for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
	}

	public Color getColor() {
		return new Color(123,123,123);
	}

	public String getSpriteName() {
		return "CarsonTylerSprite";
	}

	public static double sortAndGetMedian(int[] random) {
		quickSort(random, 0, random.length-1);
		System.out.println(Arrays.toString(random));
		return random[(int)random.length /2];
	}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		boolean done = false;
		while(!done)
		{
		    done=true;   
		    for(int i=0;i<organizedNames.length-1;i++)
		    {
		        if(!(organizednames[i]==null))
		        {
		            String name1=organizedNames[i]; String name2=organizedNames[i+1];
		            if(name1!=null&&name2!=null)
		            {
		                int num=name1.compareTo(name2);
		                if(num>0)
		                { 
		                    temp=organizedNames[i]; //temp is a String that was declared earlier
		                    organizedNames[i]=organizedNames[i+1];
		                    organizedNames[i+1]=temp;
		                    done=false 
		                }
		            }
		        }
		    }
		}
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

	public static void quickSort(int[] intArr, int lowerIndex, int higherIndex) {
		
		if (intArr == null || intArr.length == 0) {
			return;
		}

		int i = lowerIndex;
		int j = higherIndex;
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
		// Divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which 
			 * is greater then the pivot value, and also we will identify a number 
			 * from right side which is less then the pivot value. Once the search 
			 * is done, then we exchange both numbers.
			 */
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(i, j);
				//move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (lowerIndex < j)
			quickSort(intArr, lowerIndex, j);
		if (i < higherIndex)
			quickSort(intArr, i, higherIndex);
	}
	
	public void quickSort(String[] strArr, int lowerIndex, int higherIndex) {
		
		if (strArr == null || strArr.length == 0) {
			return;
		}

		int i = lowerIndex;
		int j = higherIndex;
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
		// Divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which 
			 * is greater then the pivot value, and also we will identify a number 
			 * from right side which is less then the pivot value. Once the search 
			 * is done, then we exchange both numbers.
			 */
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(i, j);
				//move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (lowerIndex < j)
			quickSort(strArr, lowerIndex, j);
		if (i < higherIndex)
			quickSort(strArr, i, higherIndex);
	}

	private static void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}

