package amazon;

import java.util.ArrayList;

public class OutputUniqueElementsInArray {

	/**
	 * Given an array a, output all unique elements in the array
	 * and output the count of unique elements
	 */
	public static void main(String[] args) {
		int[] data = new int[]{1, 3, 5, 5, 2, 2, 3, 8, 23, 12, 22, 66};
		//output1(data);
		output2(data);
		//output3(data);
	}

	// look at left and right to see if they are the same
	public static void output1(int[] data){
		data = mergeSort(data, 0, data.length - 1);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < data.length; i++){
			if(i > 0 && i < data.length - 1){
				if(data[i] != data[i - 1] && data[i] != data[i + 1])
					list.add(data[i]);
			}else if(i > 0 && data[i] != data[i - 1]){
				list.add(data[i]);
			}else if(i < data.length - 1 && data[i] != data[i + 1]){
				list.add(data[i]);
			}else
				list.add(data[i]);
		}
		for(int val : list){
			System.out.print(val + " ");
		}
	}
	
	// j go through the array and put it into the next potential index
	public static void output2(int[] data){
		data = mergeSort(data, 0, data.length - 1);
		int j = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < data.length; i = j){
			for(j = i + 1; j < data.length && data[i] == data[j]; j++);
			if(j - i == 1)
				list.add(data[i]);
		}
		for(int val : list){
			System.out.print(val + " ");
		}
	}
	
	public static void output3(int[] data){
		data = mergeSort(data, 0, data.length - 1);
		int cur = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < data.length; i++){
			if(i == 0){
				list.add(data[cur]);
			}else if(data[cur] != data[i]){
				cur = i;
				list.add(data[cur]);
			}
		}
		for(int val : list){
			System.out.print(val + " ");
		}
	}
	
	
	
	public static int[] mergeSort(int[] data, int i, int j){
		if(i == j)
			return new int[]{data[i]};
		int mid = (i + j) / 2;
		int[] left = mergeSort(data, i, mid);
		int[] right = mergeSort(data, mid + 1, j);
		int[] sortedData = new int[j - i + 1];
		for(int l = 0, r = 0; l < left.length || r < right.length; ){
			if(l < left.length && r < right.length){
				if(left[l] < right[r]){
					sortedData[l + r] = left[l];
					l++;
				}else{
					sortedData[l + r] = right[r];
					r++;
				}
			}else if(l < left.length){
				sortedData[l + r] = left[l];
				l++;
			}else{
				sortedData[l + r] = right[r];
				r++;
			}
		}
		return sortedData;
	}
	
}
