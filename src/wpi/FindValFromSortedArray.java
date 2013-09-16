package wpi;

public class FindValFromSortedArray {

	/**
	 * we are given a sorted array of distinct integers A[1,...,n]
	 * and we want to decide whether there is a index i for A[i] = i
	 */
	public static void main(String[] args) {
		int[] data = {-3, -1, 1, 2, 3, 4, 6};
		boolean result = isExistTheIndex(data);
		System.out.println(result);
	}
	
	public static boolean isExistTheIndex(int[] data){
		int i = 1;
		int j = data.length;
		while(i <= j){
			int mid = (i + j) / 2;
			if(data[mid] == mid)
				return true;
			else if(data[mid] > mid)
				j = mid - 1;
			else
				i = mid + 1;
		}
		return false;
	}

}
