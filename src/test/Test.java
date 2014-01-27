package test;

import java.util.ArrayList;



public class Test {

	static class ListNode{
		int val;
		ListNode next = null;
		public ListNode(int val){
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		int[][] a = new int[][]{{1}};
		System.out.println(a[0].length);
	}
	
	public static int get5Count(int n){
		int count = 0;
		while(n % 5 == 0){
			count++;
			n = n / 5;
		}
		return count;
	}
	
	
	// Design an algorithm to find all pairs of integers within an array which sum to a specified value
	public static ArrayList<int[]> getAllPairs(int[] A, int target){
		// key is the element value, value is the index
		java.util.Hashtable<Integer, Integer> table = new java.util.Hashtable<Integer, Integer>();
		ArrayList<int[]> list = new ArrayList<int[]>();
		for(int i = 0; i < A.length; i++){
			table.put(A[i], i);
		}
		for(int i = 0; i < A.length; i++){
			int val = target - A[i];
			if(table.containsKey(val) && table.get(val) != i){
				int[] pair = new int[]{A[i], val};
				list.add(pair);
				table.remove(val);
				table.remove(A[i]);
			}
		}
		return list;
	}


};