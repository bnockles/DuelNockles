package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class DoubleJasons extends Contestant{
	
	private int[] ISSeq = {1,3,7,21,48,112,336,861,1968,4592};
	private static String[] names = {"Tashia","Fidela","Carley","Starla","Maisie","Elijah","Pearl","Jacquie","Zelma","Tama","Hannelore","Shaniqua","Isa","Emily","Desiree","Garnet","Lauri","Erna","Denese","Renato","Britney","Numbers","Randa","Jewel","Vincenzo","Arianna","Johnathon","Charlette","Rae","Jerald"};
	
	public DoubleJasons() {
	}
	
	public static final void main(String[] args) {
		DoubleJasons test = new DoubleJasons();
		test.shellSort(names);
	}
	
	private void shellSort(String[] arr) {
		int index = ISSeq.length-1;
		int gap = ISSeq[index];
		String holder;
		String char1;
		String char2;
			for(int i = 0; i< arr.length; i++) //iterate through arr
			{
				if(i+ gap >= arr.length)
				{
					i = -1;
					index --;
					if(index ==-1) break;
					gap = ISSeq[index];
				}
				else 
				{
					for(int idx = 0; idx< arr[i].length()-1; idx++)
					{
						char1 = arr[i].substring(idx, idx+1);
						char2 = arr[i+gap].substring(idx, idx+1);
						if(char1.compareTo(char2) > 0)
						{
							holder = arr[i];
							arr[i] = arr[i+gap];
							arr[i+gap] = holder;
							checkPreviousIndices(i,gap,arr);
							break;
						}
						else if(char1.compareTo(char2) < 0)break;
					}
				}
			}
			
		for( String name: arr)
		{
			System.out.println(name);
		}
	}
	
	private void shellSort(int[] arr) {
		int index = ISSeq.length-1;
		int gap = ISSeq[index];
		int holder;
		while( index > 0) {
			for(int i = 0; i< arr.length; i++) //iterate through arr
			{
				if(i+ gap > arr.length)
				{
					i = 0;
					index --;
					gap = ISSeq[index];
				}
				else 
				{
					if(arr[i] > arr[i+gap]) {
						holder = arr[i];
						arr[i] = arr[i+gap];
						arr[i+gap] = arr[i];
					}
					if(arr[i] == arr[i+gap]) {
						holder = arr[i+1];
						arr[i+1] = arr[i+gap];
						arr[i+gap] = holder;
					}
				}
			}
		}
		System.out.print(arr);
	}

	private void checkPreviousIndices(int index, int gap, String[] arr) {
		while(index - gap >= 0) {
			for(int secondCheck = 0; secondCheck< arr[index].length()-1; secondCheck++)
			{
				String char1 = arr[index-gap].substring(secondCheck, secondCheck+1);
				String char2 = arr[index].substring(secondCheck, secondCheck+1);
				if( char1.compareTo(char2) > 0)
				{
					String holder = arr[index-gap];
					arr[index-gap] = arr[index];
					arr[index] = holder;
					return;
				}
				if(char1.compareTo(char2) <= 0)return;
			}
		}
	}
	
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return new Color(255,0,255);
	}

	@Override
	public String getSpriteName() {
		// TODO Auto-generated method stub
		return CHUN_LI;
	}

	@Override
	public double sortAndGetMedian(int[] random) {	
		shellSort(random);
		return random[random.length/2];
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


}
