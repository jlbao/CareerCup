package amazon;

public class FrogJump {
	/**
	 * given an input array of integers 
	 * where each integer represent 
	 * the maximum amount of jump a frog can take.
	 * Frog has to reach the end of the array in minimum number of jumps. 
	 * Example:
	 * [1 5 4 6 9 3 0 0 1 3] answer is 3 for this. 
	 * [2 8 3 6 9 3 0 0 1 3] answer is 2 for this. 
	 * Any DP solution for this?
	 */
	public static void main(String[] args) {
		int[] data = {1, 5, 4, 6, 9, 3, 0, 0, 1, 3};
		int[] data2 = {2, 8, 3, 6, 9, 3, 0, 0, 1, 3};
		System.out.println(getMinJumpCount(data));
		System.out.println(getMinJumpCount(data2));
	}
	
	public static int getMinJumpCount(int[] data){
		int[] count = new int[data.length];
		
		for(int i = data.length - 2; i >= 0; i--){
			if(data[i] == 0)
				count[i] = 0;
			else if(i + data[i] >= data.length - 1)
				count[i] = 1;
			else{
				count[i] = data.length;
				for(int j = i + 1; j <= i + data[i] && j < data.length; j++){
					if(count[j] != 0 && count[i] >= count[j] + 1)
						count[i] = count[j] + 1;
				}
			}
		}
		return count[0];
	}
}
