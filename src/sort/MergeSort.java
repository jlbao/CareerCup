package sort;

public class MergeSort {

	public static void main(String[] args) {
		int[] data = new int[]{8,1,3,5,2,9,7,6};
		int[] sortedData = mergeSort(data, 0, data.length - 1);
		
		for(int i = 0; i < sortedData.length; i++){
			System.out.print(sortedData[i] + " ");
		}
		System.out.println();
	}
	
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
