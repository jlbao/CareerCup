package search;

public class FindLargestSubArray {

	/**
	 * Find the largest sub array sum in one array
	 */
	public static void main(String[] args) {
		int[] data = {2, -3, 6, 8};
		int max = findLargestSubArray(data, 0, data.length - 1);
		System.out.println(max);
	}

	//divide and conquer T(n) = T(n / 2) + n
	public static int findLargestSubArray(int[] data, int i, int j){
		if(i == j)
			return data[i];
		
		int mid = (i + j) / 2;
		int leftMax = findLargestSubArray(data, i, mid);
		int rightMax = findLargestSubArray(data, mid + 1, j);
		
		int leftFromMid = data[mid];
		int sum = data[mid];
		for(int k = mid - 1; k >= i; k--){ // find the left sequential max include the mid
			leftFromMid += data[k];
			if(leftFromMid > sum)
				sum = leftFromMid;
		}
		leftFromMid = sum;
		sum = data[mid];
		int rightFromMid = sum;
		
		for(int k = mid + 1; k <= j; k++){
			rightFromMid += data[k];
			if(rightFromMid >= sum)
				sum = rightFromMid;
		}
		int midMax = leftFromMid + rightFromMid - data[mid];
	
		if(leftMax < rightMax){
			if(rightMax < midMax)
				return midMax;
			else
				return rightMax;
		}else{
			if(leftMax < midMax)
				return midMax;
			else
				return leftMax;
		}
	}
	

}
