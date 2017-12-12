package sortomania.contestants;

import sortomania.Contestant;

public class Test {
	
	public static void main(String[] args) {
		Contestant a = new AndrewKevin();
		
		double avg = 0;
		for(int i = 0; i < 200; i ++) {
			int[] arr = unsortedArray();
			avg += testSort(a,arr);
			if(!isSorted(arr) )
				System.out.println("Something is wrong");
		}
		
		System.out.println((avg/200)/1000000);
	}
	
	public static long testSort(Contestant a, int[] test) {
		long startTime = System.nanoTime();
			a.sortAndGetMedian(test);
		long endTime = System.nanoTime();
		return endTime - startTime;
	}
	
	public static int[] unsortedArray() {
		int[] test = new int [10000];
		for(int i = 0; i < test.length; i++) {
			test[i] = (int)(Math.random()*10000);
		}
		return test;
	}
	
	public static boolean isSorted(int[] sortedArray) {
		int prev = sortedArray[0];
		for(int i = 1; i<sortedArray.length; i++) {
			if(sortedArray[i] < prev) {
				return false;
			}
			prev = sortedArray[i];
		}
		return true;
	}
}
