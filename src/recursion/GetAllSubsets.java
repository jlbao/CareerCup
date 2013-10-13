package recursion;

import java.util.ArrayList;

public class GetAllSubsets {

	/**
	 * Write a method that returns all subsets
	 */
	
	public static void main(String[] args) {
		int[] data = new int[]{1, 2, 3, 4, 5};
		ArrayList<ArrayList<Integer>> subsets = getAllSubsets(data);
		
		for(ArrayList<Integer> one : subsets){
			for(int val : one){
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
	
	public static ArrayList<ArrayList<Integer>> getAllSubsets(int[] data){
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		subsets.add(new ArrayList<Integer>());
		for(int i = 0; i < data.length; i++){
			int len = subsets.size();
			for(int j = 0; j < len; j++){
				ArrayList<Integer> one = new ArrayList<Integer>();
				one.addAll(subsets.get(j));
				one.add(data[i]);
				subsets.add(one);
			}
		}
		return subsets;
	}

}
