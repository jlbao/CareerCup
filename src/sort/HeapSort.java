package sort;

public class HeapSort {

	/**
	 * Use heap sort to sort an array
	 */
	
	public static int[] data = {0, 5, 3, 8, 15, 9, 6, 28, 16, 18};
	public static int heapSize = data.length - 1;
	
	public static void main(String[] args) {
		sort_heap(data);
		for(int i = 1; i < data.length; i++){
			System.out.print(data[i] + " ");
		}
	}

	public static void sort_heap(int[] data){
		build_max_heap(data);
		while(heapSize > 0){
			exchange(data, 1, heapSize);
			heapSize--;
			max_heapify(data, 1);
		}
	}
	
	public static void build_max_heap(int[] data){
		for(int i = heapSize / 2; i > 0; i--){
			max_heapify(data,i);
		}
	}
	
	public static void max_heapify(int[] data, int i){
		int leftChild = 2 * i;
		int rightChild = 2 * i + 1;
		int largest = i;
		if(leftChild <= heapSize && data[i] < data[leftChild])
			largest = leftChild;
		if(rightChild <= heapSize && data[largest] < data[rightChild])
			largest = rightChild;
		if(largest != i){
			exchange(data, i, largest);
			max_heapify(data,largest);
		}
	}
	
	public static void exchange(int[] data, int i, int j){
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
}
