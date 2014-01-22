package test;



public class Test {

	static class ListNode{
		int val;
		ListNode next = null;
		public ListNode(int val){
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		int[] A = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
		int[] range = findIndexRange(A);
		System.out.println(range[0] + " " + range[1]);
	}
	
	public static int[] findIndexRange(int[] A){
		int[] leftMax = new int[A.length];
		int[] rightMin = new int[A.length];
		leftMax[0] = A[0];
		rightMin[rightMin.length - 1] = A[A.length - 1];
		for(int i = 1; i < A.length; i++){
			leftMax[i] = Math.max(A[i], leftMax[i - 1]);
			rightMin[A.length - 1 - i] = Math.min(A[A.length - 1 - i], rightMin[A.length - i]);
		}
		int minIndex = -1;
		int maxIndex = -1;
		for(int i = 0; i < A.length; i++){
			if(A[i] > rightMin[i] && minIndex == -1){
				minIndex = i;
			}
			if(A[A.length - i - 1] < leftMax[A.length - 1 - i] && maxIndex == -1){
				maxIndex = A.length - i - 1;
			}
			if(minIndex != -1 && maxIndex != -1){
				break;
			}
		}
		return new int[]{minIndex, maxIndex};
	}
};