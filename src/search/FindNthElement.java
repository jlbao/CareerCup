package search;

public class FindNthElement {

	/**
	 * Find the nth element in an array
	 */
	public static void main(String[] args) {
		int[] data = {3, 5, 2, 6, 25, 12, 18, 9, 23, 66, 12, 24, 25, 19, 18};
		int result = findNthElement(data, 0, data.length - 1, data.length - 1);
		System.out.println(result);	
	}
	
	public static int findNthElement(int[] data, int i, int j, int n){
		if(i >= j)
			return data[i];
		
		//left of mid is smaller, right side is bigger
		int mid = partition(data, i , j);  

		// the kth value
		int k = mid - i + 1;
		
		if(k == n)
			return data[mid];
		else if(n < k)
			return findNthElement(data, i, mid - 1, n);
		else
			return findNthElement(data, mid + 1, j, n - k);
	}
	
	public static int partition(int[] data, int i, int j){
		int pivot = j;
		int left = i - 1;
		int right = i;
		while(right < pivot){
			if(data[pivot] > data[right]){
				int tmp = data[++left];
				data[left] = data[right];
				data[right] = tmp;
			}
			right++;
		}
		int mid = left + 1;
		int tmp = data[mid];
		data[mid] = data[pivot];
		data[pivot] = tmp;
		return mid;
	}
	
	
}
