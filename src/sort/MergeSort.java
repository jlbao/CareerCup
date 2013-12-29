package sort;

public class MergeSort {

	public static void main(String[] args) {
		int[] data = new int[]{8,1,3,5,2,9,7,6};
		//data = mergeSort(data, 0, data.length - 1);
		mergeSort(data, new int[data.length], 0, data.length - 1);
		
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
	
	// complex way of doing the merge sort
	public static void mergeSort(int[] A, int[] helper, int l, int r){
		if(l >= r){
			return;
		}
		int mid = (l + r) / 2;
		mergeSort(A, helper, l, mid);
		mergeSort(A, helper, mid + 1, r);
		merge(A, helper, l, mid, r);
	}

	public static void merge(int[] A, int[] helper, int l, int mid, int r){
		for(int i = l; i <= r; i++){
			helper[i] = A[i];
		}
		int i = l;
		int j = mid + 1;
		int k = l; // k keep track of the index in helper array
		while(i <= mid || j <= r){
			if(i <= mid && j <= r){
				if(helper[i] < helper[j]){
					A[k] = helper[i];
					i++;
				}else{
					A[k] = helper[j];
					j++;
				}
			}else if(i <= mid){
				A[k] = helper[i];
				i++;
			}else{
				A[k] = helper[j];
				j++;
			}
			k++;
		}
	}
	
	
	// easy way to do the merge sort, but need to return value
	public static int[] mergeSort(int[] data,int pre, int after){
		
		if(pre == after){
			return new int[]{data[pre]};
		}
		
		int mid = (pre + after) / 2;
		int[] left = mergeSort(data, pre, mid);
		int[] right = mergeSort(data, mid + 1, after);
		
		int[] sortedData= new int[left.length + right.length];
		
		for(int i = 0, j = 0, k = 0; k < sortedData.length; k++){
			if(i < left.length && j < right.length){ //index does not exceed
				if(left[i] < right[j])
					sortedData[k] = left[i++];
				else
					sortedData[k] = right[j++];
			}else{ // at least one index exceed the array range
				if(i < left.length)
					sortedData[k] = left[i++];
				else
					sortedData[k] = right[j++];
			}
		}

		return sortedData;
		
	}
	

}
