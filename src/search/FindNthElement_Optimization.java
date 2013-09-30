package search;

public class FindNthElement_Optimization {

	/**
	 * Find the nth element in an array
	 * Can assure the complexity is O(n)
	 * better than FindNthElement 
	 * because that cannot decide the pivot position
	 */
	
	public static void main(String[] args) {
		int[] data = {3, 5, 2, 6, 25, 12, 18, 9, 23, 66, 12, 24, 25, 19, 18};
		int result = findElement(data, 0, data.length - 1, 5);
		System.out.println(result);
	}
	
	public static int findElement(int[] data, int i, int j, int n){
		int[] medians = new int[(j - i + 1) / 5 + (j - i + 1) % 5];
		for(int k = 0, p = 0; k <= j; k = k + 5, p++){
			insertionSort(data, k, k + 5);
			medians[p] = (k + k + 5) / 2;
		}
		int mid = findElement(medians, 0, medians.length - 1, (medians.length - 1) / 2);
		return data[mid];
	}
	
	public static void insertionSort(int[] data, int i, int j){
		for(int k = i; k < j && k < data.length; k++){
			int minIndex = k;
			for(int s = k + 1; s < j && s < data.length; s++){
				if(data[minIndex] > data[s])
					minIndex = s;
			}
			if(minIndex != k){
				int tmp = data[k];
				data[k] = data[minIndex];
				data[minIndex] = tmp;
			}
		}
	}

}
