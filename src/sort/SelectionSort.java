package sort;

public class SelectionSort {

	/**
	 * Use insertion sort to sort an array
	 */
	public static void main(String[] args) {
		int[] data = {3,5,1,2,8,12,16,15,18,9};
		selectionSort(data);
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}
	}
	
	public static void selectionSort(int[] data){
		for(int i = 0; i < data.length; i++){
			int minIndex = i;
			for(int j = i + 1; j < data.length; j++){
				if(data[minIndex] > data[j])
					minIndex = j;
			}
			if(minIndex != i){
				int tmp = data[i];
				data[i] = data[minIndex];
				data[minIndex] = tmp;
			}
		}
	}

}
