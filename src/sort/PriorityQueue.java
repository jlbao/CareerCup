package sort;

public class PriorityQueue {

	/**
	 * Create a priority queue
	 * 4 main functions:
	 * get max element in the array
	 * extract max element in the array
	 * increase key in the array
	 * change key in the array
	 */
	
	public int[] data;
	public int heapSize;
	
	public static void main(String[] args) {
		int[] data = {-1,2,8,3,9,18,16,-1,-1,-1,-1,-1};
		PriorityQueue queue = new PriorityQueue(data, 6);
		test_increase_key(queue, 4, 1000);
		test_heap_extract_max(queue);
		
		
	}
	
	//test methods
	public static void test_heap_extract_max(PriorityQueue queue){
		while(queue.heapSize > 0){
			System.out.print(queue.heap_extract_max() + " ");
		}
	}
	
	public static void test_increase_key(PriorityQueue queue, int i, int key){
		queue.heap_increase_key(i, key);
	}

	
	
	public PriorityQueue(int[] data, int heapSize){
		this.data = data;
		this.heapSize = heapSize;
		build_max_heap();
	}
	
	public void build_max_heap(){
		for(int i = heapSize / 2; i > 0; i--){
			max_heapify(data,i);
		}
	}
	
	public int heap_max(){
		return data[1];
	}
	
	public boolean heap_increase_key(int i, int key){
		if(key <= data[i])
			return false;
		data[i] = key;
		int parent = i / 2;
		while(parent > 0 && data[parent] < data[i]){
			exchange(data, parent, i);
			i = parent;
			parent = parent / 2;
		}
		return true;
	}
	
	
	public boolean max_heap_insert(int key){
		if(heapSize >= data.length - 1)
			return false;
		data[++heapSize] = Integer.MIN_VALUE;
		return heap_increase_key(heapSize, key);
	}
	
	public int heap_extract_max(){
		int max = data[1];
		data[1] = data[heapSize--];
		max_heapify(data,1);
		return max;
	}
	
	//max heapify: move the certain value to the right place in the array
	//kinda different from the max_heapify in heapsort in implementation
	//but the concept is the same
	public void max_heapify(int i){
		int left = 2 * i;
		int right = 2 * i + 1;
		int largest = i;
		while(left <= heapSize || right <= heapSize){
			if(left <= heapSize && data[i] < data[left])
				largest = left;
			if(right <= heapSize && data[largest] < data[right])
				largest = right;
			if(largest != i){
				exchange(data, i, largest);
				i = largest;
				left = 2 * i;
				right = 2 * i + 1;
			}else // already in the correct place
				return;
		}
	}
	
	//recursion of max heapify
	public void max_heapify(int[] data, int i){
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
	
	protected void exchange(int[] data, int i, int j){
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}


}
