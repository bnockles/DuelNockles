package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class TheoDevinBeepBoop extends Contestant {

	@Override
	public Color getColor() {
		return new Color(255,170,0);
	}

	@Override
	public String getSpriteName() {
		return BLANKA;// why no Q :(
	}

	@Override
	public double sortAndGetMedian(int[] random) {//heap for random, insertion for near
		int n = random.length;
		 
        // The output character array that will have sorted arr
        int output[] = new int[n];
 
        // Create a count array to store count of inidividul
        // characters and initialize count array as 0
        int count[] = new int[256];
        for (int i=0; i<256; ++i)
            count[i] = 0;
 
        // store count of each character
        for (int i=0; i<n; ++i)
            ++count[random[i]];
 
        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i=1; i<=255; ++i)
            count[i] += count[i-1];
 
        // Build the output character array
        for (int i = 0; i<n; ++i)
        {
            output[count[random[i]]-1] = random[i];
            --count[random[i]];
        }
 
        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i<n; ++i)
            random[i] = output[i];
		if(random.length%2==1) {
			return (double)random[random.length/2];
		}else {
			return (double)(random[random.length/2]+random[(random.length/2)-1])/2;
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

}
