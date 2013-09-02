package mircrosoft;

import java.util.ArrayList;

public class FindIntersectionIn2SortedArray {

	/**
	 * try to find a method to find intersection in 2 sorted array
	 */
	public static void main(String[] args) {
		int[] data1 = {1,3,5,6,8,12};
		int[] data2 = {2,5,6,9,13};
		ArrayList<Integer> store = getIntersection(data1,data2);
		for(int val : store){
			System.out.print(val + " ");
		}
		System.out.println();
	}
	
	
	public static ArrayList<Integer> getIntersection(int[] data1, int[] data2){
		ArrayList<Integer> store = new ArrayList<Integer>();
		for(int i = 0, j = 0; i < data1.length && j < data2.length;){
			if(data1[i] < data2[j])
				i++;
			else if(data1[i] > data2[j])
				j++;
			else{
				store.add(data1[i]);
				i++;
				j++;
			}
		}
		return store;
	}
	
	
	public static ArrayList<Integer> getIntersection2(int[] data1, int[] data2){
		ArrayList<Integer> store = new ArrayList<Integer>();
		int startIndex = 0;
		for(int i = 0; i < data1.length && startIndex < data2.length; i++){
			startIndex = setIntersection(data2,startIndex,data1[i],store);
		}
		return store;
	}

	public static int setIntersection(int[] data, int startIndex, int value, ArrayList<Integer> store){
		int i = startIndex;
		int j = data.length - 1;
		
		while(i <= j){
			int mid = (i + j) / 2;
			if(value < data[mid])
				j = mid - 1;
			else if (value > data[mid])
				i = mid + 1;
			else{
				store.add(data[mid]);
				return j;
			}
		}
		return j;
	}
	
}
