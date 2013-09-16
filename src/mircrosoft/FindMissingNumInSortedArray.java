package mircrosoft;

public class FindMissingNumInSortedArray {

	/**
	 * a sorted interger array[1, ... , N], 
	 * data range 1 ... N + 1, a number is missing
	 * find the missing number
	 */
	public static void main(String[] args) {
		int data[] = {0,1,2,3,4,5,6,7,8};
		int result = findMissingNum(data);
		System.out.println(result);

	}

	public static int findMissingNum(int[] data){
		int i = 1;
		int j = data.length - 1;
		while(i <= j){
			int mid = (i + j) / 2;
			if(data[mid] <= mid)
				i = mid + 1;
			else
				j = mid - 1;
		}
		return i;
	}
	
}
