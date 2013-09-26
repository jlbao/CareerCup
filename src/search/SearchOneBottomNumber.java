package search;

public class SearchOneBottomNumber {

	/**
	 * http://www.1point3acres.com/bbs/thread-14202-1-1.html
	 * A[0] > A[1] and A[n - 1] < A[n]
	 * find the bottom point using log(n)
	 * My method is to use up trend and down trend to compare left and right
	 */
	public static void main(String[] args) {
		int[] data = {18, 15, 12, 11, 1, 5, 20};
		int index = findBottom(data, 0, data.length - 1);
		System.out.println(index);
		System.out.println(findBottom_recursion(data, 0, data.length - 1));
	}
	
	public static int findBottom(int[] data, int i, int j){
		while(j - i >= 2){
			int mid = (i + j) / 2;
			if(mid + 1 >= data.length - 1 || mid - 1 < 0)
				return -1;
			if(data[mid] <= data[mid + 1] && data[mid] <= data[mid - 1])
				return mid;
			if(data[mid] >= data[mid + 1] && data[mid] >= data[mid - 1])
				return mid;
			if(data[mid - 1] >= data[mid])
				i = mid;
			else
				j = mid;
		}
		return -1;
	}
	
	public static int findBottom_recursion(int[] data, int i, int j){
		if(j - i < 2)
			return -1;
		int mid = (i + j) / 2;
		if(mid - 1 < 0 || mid + 1 > data.length - 1)
			return -1;
		if(data[mid] <= data[mid - 1] && data[mid] <= data[mid + 1])
			return mid;
		if(data[mid] >= data[mid - 1] && data[mid] >= data[mid + 1])
			return mid;
		if(data[mid - 1] >= data[mid])
			return findBottom_recursion(data, mid, j);
		else
			return findBottom_recursion(data, i, mid);
	}
	
}
