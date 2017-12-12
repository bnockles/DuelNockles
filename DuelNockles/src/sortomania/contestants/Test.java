package sortomania.contestants;

import sortomania.Contestant;

public class Test {
	
	public static void main(String[] args) {
		Contestant a = new AndrewKevin();
		
		double avg = 0;
		for(int i = 0; i < 200; i ++) {
			avg += testSort(a,unsortedArray());
		}
		
		System.out.println((avg/200)/100000);
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
}
