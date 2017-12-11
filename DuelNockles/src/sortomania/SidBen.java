package sortomania;

import java.awt.Color;

public class SidBen extends Contestant{

	private int[] numbers;
	private int number;
	
	public static void dort() {
		int[] temp = {5,1,4,7,3,3};
		MyQuickSort s = new MyQuickSort();
		s.sort(temp);
	}
	
	
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return new Color(255,255,255);
	}
	
	
	@Override
	public String getSpriteName() {
		// TODO Auto-generated method stub
		return DEE_JAY;
	}

	
	@Override
	public double sortAndGetMedian(int[] random) {
		MyQuickSort s = new MyQuickSort();
		s.sort(random);
		
		int l = random.length;
		
		if(l %2 == 0) {
			return (random[l/2] + random[l+1/2])/2;
		}else {
			return random[l/2];
		}
		
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
	
	
	//------------------------------------------------------------------------------------
	
	
	
	
}
