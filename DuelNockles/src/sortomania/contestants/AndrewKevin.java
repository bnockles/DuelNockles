package sortomania.contestants;

import java.awt.Color;

import sortomania.Contestant;

public class AndrewKevin extends Contestant{

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return new Color(205,197,191);
	}

	@Override
	public String getSpriteName() {
		// TODO Auto-generated method stub
		return "E_HONDA";
	}

	@Override
	public double sortAndGetMedian(int[] random) {
		int n = random.length;
        char output[] = new char[n];
        int count[] = new int[256];
        for (int i=0; i<256; ++i)
            count[i] = 0;
        for (int i=0; i<n; ++i)
            ++count[random[i]];
        for (int i=1; i<=255; ++i)
            count[i] += count[i-1];
        for (int i = 0; i<n; ++i)
        {
            output[count[random[i]]-1] = (char) random[i];
            --count[random[i]];
        }
        for (int i = 0; i<n; ++i)
            random[i] = output[i];
        
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
