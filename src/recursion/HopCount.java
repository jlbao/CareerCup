package recursion;

public class HopCount {
/*
 * a child is running a staircase with n steps, 
 * and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 */
	public static void main(String[] args) {
		int n = 4;
		int[] store = new int[n + 1];
		int hopCount = getHopCount(n, store);
		System.out.println(hopCount);
	}
	
	public static int getHopCount(int n, int[] store){
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}
		if(n == 3){
			return 4;
		}
		if(store[n] != 0){
			return store[n];
		}
		store[n] = getHopCount(n - 1, store) + getHopCount(n - 2, store) + getHopCount(n - 3, store);
		return store[n];
	}
}
