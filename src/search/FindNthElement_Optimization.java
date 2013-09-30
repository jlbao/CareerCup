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
		int result = findElement(data, 0, data.length - 1, 2);
		System.out.println(result);
	}
	
	public static int findElement(int[] data, int i, int j, int n){
		if(i >= j)
			return data[i];
		int[] medians;
		if((j - i + 1) % 5 != 0)
			medians = new int[(j - i + 1) / 5 + 1];
		else
			medians = new int[(j - i + 1) / 5];
		
		for(int k = i, p = 0; k <= j; k = k + 5, p++){ //sort 5 data each time
			if(k + 4 > j){
				insertionSort(data, k, j);
				medians[p] = data[(k + j) / 2];
			}else{
				insertionSort(data, k, k + 4);
				medians[p] = data[k + 2];
			}
		}
		// find the median in the medians
		int midMedian = findElement(medians, 0, medians.length - 1, (medians.length + 1 )/ 2);
		
		// find the median 's position, left side is smaller, right side is bigger
		int mid = partition(data, i, midMedian);
		
		int pos = mid - i + 1;
		if(n == pos)
			return data[mid];
		else if(n < pos)
			return findElement(data, i, mid - 1, n);
		else
			return findElement(data, mid + 1, j, n - pos);
		
	}
	
	//kinda different partition compared with quick sort. the pivot is from input parameter
	//because we do not know the index of the pivot
	//we just know the value is in the array
	public static int partition(int[] data, int i, int pivot){
		int left = i - 1;
		int right = i;
		while(right < data.length){
			if(pivot >= data[right]){
				int tmp = data[++left];
				data[left] = data[right];
				data[right] = tmp;
			}
			right++;
		}
		return left;
	}
	
	//insert sort, because there is only 5 numbers(constant) in the array, so complexity is O(1)
	public static void insertionSort(int[] data, int i, int j){
		for(int k = i; k <= j && k < data.length; k++){
			int minIndex = k;
			for(int s = k + 1; s <= j && s < data.length; s++){
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
