package sortomania;

public class LordAchillesContestant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String toString() {
		return null;
	}

	public static void shakerSort(int[] array) {
	
		for (int i = 0; i < array.length/2; i++) {
		
		boolean swapped = false;
		for (int j = i; j < array.length - i - 1; j++) {
			if (array[j] < array[j+1]) {
				int tmp = array[j];
				array[j] = array[j+1];
				array[j+1] = tmp;
				swapped = true;
			}
		}
		for (int j = array.length - 2 - i; j > i; j--) {
			if (array[j] > array[j-1]) {
				int tmp = array[j];
				array[j] = array[j-1];
				array[j-1] = tmp;
				swapped = true;
			}
		}
		
		if(!swapped) break;

		}
	}
	
	/*# heapify
	for i = n/2:1, sink(a,i,n)
	→ invariant: a[1,n] in heap order

	# sortdown
	for i = 1:n,
	    swap a[1,n-i+1]
	    sink(a,1,n-i)
	    → invariant: a[n-i+1,n] in final position
	end

	# sink from i in a[1..n]
	function sink(a,i,n):
	    # {lc,rc,mc} = {left,right,max} child index
	    lc = 2*i
	    if lc > n, return # no children
	    rc = lc + 1
	    mc = (rc > n) ? lc : (a[lc] > a[rc]) ? lc : rc
	    if a[i] >= a[mc], return # heap ordered
	    swap a[i,mc]
	    sink(a,mc,n)
	    */
}







