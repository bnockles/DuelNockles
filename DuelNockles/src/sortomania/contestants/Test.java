package sortomania.contestants;

import sortomania.Contestant;

public class Test {
	
	public static void main(String[] args) {
		int[] test = new int [10000];
		for(int i = 0; i < test.length; i++) {
			test[i] = (int)(Math.random()*10000);
		}
		Contestant a = new AndrewKevin();
		long startTime = System.nanoTime();
		a.sortAndGetMedian(test);
		long endTime = System.nanoTime();
		System.out.println("It took " + (endTime - startTime) + " nanoseconds");
		for(int i: test) {
			System.out.println(i);
		}
	}
	
}
