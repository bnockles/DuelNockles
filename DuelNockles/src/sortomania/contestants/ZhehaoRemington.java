package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class ZhehaoRemington extends Contestant {
	
	
	private int[] numbers;
	private int[] test;
	private int number;

	public static void main(String[] args) {
		int[] test=new int[100];
		ZhehaoRemington testing= new ZhehaoRemington();
		populate(test);
		System.out.println("median: "+ testing.mostlySortAndGetMedian(test)+" average time is "+getTime(test));
	for(int i=0;i<test.length;i++) {
			System.out.println(test[i]);
		}
		//getTime(test);
	//	printArray(test);
		
	}
	private static long getTime(int[] arr) {
		long num=0;
		//for(int i=0;i<200;i++) {
			ZhehaoRemington useless=new ZhehaoRemington();
			long startTime= System.nanoTime();
			double med=useless.mostlySortAndGetMedian(populate(arr));
			long endTime=System.nanoTime();
			long duration=(endTime-startTime)/100000;
			num+=duration;
		//}
		return (long) num;//Math.sqrt(num/201);
		
		 
		
	}
	private static int[] populate(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			arr[i]= (int)(Math.random()*99);
		}
		return arr;
	}
	

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return new Color(69,69,69);
	}

	@Override
	public String getSpriteName() {
		// TODO Auto-generated method stub
		return DEE_JAY;
	}
	public void sort(int[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            return;
        }
        this.numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }
    public int[] insertionSort(int[] arr) {
    	int temp;
        for (int i = 1; i < arr.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

	public double sortAndGetMedian(int[] random) {
		sort(random);
		if(random.length%2==0) {
			return (double) (random[random.length/2]+ random[random.length/2-1])/2;
		}else {
			return (double) random[random.length/2];
		}
		
	
		
	}

	@Override
	public int sortAndGetResultingIndexOf(String[] strings, String toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double mostlySortAndGetMedian(int[] mostlySorted) {
		insertionSort(mostlySorted);
		if(mostlySorted.length%2==0) {
			return (double) (mostlySorted[mostlySorted.length/2]+ mostlySorted[mostlySorted.length/2-1])/2;
		}else {
			return (double) mostlySorted[mostlySorted.length/2];
		}
	}

	@Override
	public double sortMultiDim(int[][] grid) {
		int medofmed=0;
		for(int i=0;i<grid[0].length;i++) {
			medofmed+=sortAndGetMedian(grid[i]);
		}
		return medofmed/grid[0].length;
	}

	@Override
	public int sortAndSearch(Comparable[] arr, Comparable toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

}

