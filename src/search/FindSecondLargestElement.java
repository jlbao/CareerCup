package search;

public class FindSecondLargestElement {

	/**
	 * Show that the second largest element can be found with
	 * n + log(n) - 2 comparisons
	 * tree model
	 * step 1: find the max number
	 * step 2: store the index that the number has beaten
	 * 	and link the number lately beaten with the previously beaten in sequence
	 */

	public static void main(String[] args) {
		int[] data = {0, 36, 6, 18, 20, 8, 18, 16, 9, 28, 58, 35};
		int i = findSecondLargestElement(data);
		System.out.println(data[i]);
	}

	public static int findSecondLargestElement(int[] data){
		int[] record = new int[data.length];
		int maxIndex = findLargestElement(data, record, 1, data.length - 1);
		int i = record[maxIndex];
		int tmp = i;
		while(i != 0){
			if(data[tmp] < data[i])
				tmp = i;
			i = record[i];
		}
		return tmp;
	}
	
	public static int findLargestElement(int[] data, int[] record, int i, int j){
		if(i >= j)
			return i;
		
		int mid = (i + j) / 2;
		int left = findLargestElement(data, record, i, mid);
		int right = findLargestElement(data, record, mid + 1, j);
		if(data[left] < data[right]){
			record[left] = record[right];
			record[right] = left;
			return right;
		}else{
			record[right] = record[left];
			record[left] = right;
			return left;
		}
	}
}
