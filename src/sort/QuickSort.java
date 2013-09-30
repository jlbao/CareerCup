package sort;

public class QuickSort {

	/**
	 * use quick sort to sort an array
	 * actually, this is a divide and conquer solution
	 */
	public static void main(String[] args) {
		int[] data = {3,5,1,2,8,12,16,15,18,9};
		quickSort(data, 0, data.length - 1);
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}
	}
	
	public static void quickSort(int[] data, int i, int j){
		if(i >= j)
			return;

		int mid = partition(data, i, j);
		quickSort(data, i, mid - 1);
		quickSort(data, mid + 1, j);
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
		int tmp = data[++left];
		data[left] = data[pivot];
		data[pivot] = tmp;
		return left;
	}
}
