package sortomania.contestants;

import sortomania.Contestant;

public class KevinAndrewTest {
	
public static void main(String a[]){
        
        AndrewKevin sorter = new AndrewKevin();
        //int[] input = new int [10000];
        //for(int i = 0; i < input.length; i++) {
        //	input[i] = (int) (Math.random()*10001);
        //}
        int[] input = {24,2,45,20,56,75,2,56,53,12};
        final long startTime = System.nanoTime();
        sorter.sort(input);
        final long duration = System.nanoTime() - startTime;
        for(int i:input){
            System.out.println(i);
        }
        System.out.println ("\n" + duration + " nanoseconds");
        System.out.println (input.length/2);
        System.out.println(input[input.length/2]);
        System.out.println(sorter.sortAndGetMedian(input));
    }

}
