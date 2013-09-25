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
		int left = i - 1;
		int right = i;
		int pivot = j;
		while(right < pivot){
			if(data[pivot] < data[right]){
				right++;
			}else{
				int tmp = data[++left];
				data[left] = data[right];
				data[right++] = tmp;
			}
		}
		int tmp = data[++left];
		data[left] = data[pivot];
		data[pivot] = tmp;
		
		quickSort(data, i, left - 1);
		quickSort(data, left + 1, j);
	}
	
}
