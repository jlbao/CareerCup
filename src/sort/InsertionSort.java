package sort;

public class InsertionSort {

	/**
	 * Use insertion sort to sort an array
	 */
	public static void main(String[] args) {
		int[] data = {3,5,1,2,8,12,16,15,9,23,18};
		insertionSort(data);
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}
	}
	
	// this is the exact insertion sort in U.S
	public static void insertionSort(int[] data){
		for(int i = 1; i < data.length; i++){
			for(int j = i; j > 0; j--){
				if(data[j] < data[j - 1]){ // exchange the values
					data[j] ^= data[j - 1];
					data[j - 1] ^= data[j];
					data[j] ^= data[j - 1];
				}else{
					break;
				}
			}
		}
	}
	
	// Actually this is not a insertion sort based on U.S standard
	public static void insertionSort2(int[] data){
		for(int i = 1; i < data.length; i++){
			for(int j = i; j >= 1 && data[j] < data[j - 1]; j--){
				int tmp = data[j];
				data[j] = data[j - 1];
				data[j - 1] = tmp;
			}
		}
	}
}
