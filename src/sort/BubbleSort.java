package sort;

public class BubbleSort {

	/**
	 * Use bubble sort to sort an array
	 */
	public static void main(String[] args) {
		int[] data = {3,5,1,2,8,12,16,15,18,9};
		bubbleSort(data);
		
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}
	}
	
	public static void bubbleSort(int[] data){
		for(int i = 0; i < data.length; i++){
			for(int j = data.length - 1; j > i; j--){
				if(data[j] < data[j - 1]){
					int tmp = data[j];
					data[j] = data[j - 1];
					data[j - 1] = tmp;
				}
			}
		}
	}

}
