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
        sorter.mostlySortAndGetMedian(input);
        final long duration = System.nanoTime() - startTime;
        for(int i:input){
            System.out.println(i);
        }
        System.out.println ("\n" + duration + " nanoseconds");
        System.out.println(sorter.sortAndGetMedian(input));
        
        String[] fruits = {"Apple","Mango","Peach","Banana","Orange","aaaaa","Grapes","Watermelon","Tomato"};
        final long startTime2 = System.nanoTime();
        sorter.sortAndGetResultingIndexOf(fruits, "Peach");
        final long duration2 = System.nanoTime() - startTime2;
        for(String i:fruits){
            System.out.println(i);
        }
        System.out.println ("\n" + duration2 + " nanoseconds");
        System.out.println(sorter.sortAndGetResultingIndexOf(fruits,"Apple"));
    }

}
