package wpi;

public class MergeKSortedArray {

	/**
	 * use O(nlogk) to merge k sorted arrays
	 * idea: the same as the merge sort
	 */
	
	static int k = 5;
	
	public static void main(String[] args) {
		int[][] data = new int[k][];
		data[0] = new int[]{2, 6, 16, 28, 35};
		data[1] = new int[]{5, 12, 29, 85};
		data[2] = new int[]{1, 25, 38, 56, 99, 120};
		data[3] = new int[]{3, 35, 36, 50, 55};
		data[4] = new int[]{8, 32, 33};
		//int[] sortedData = mergeSort(data);
		int[] sortedData = sort(data, 0, data.length - 1);
		for(int i = 0; i < sortedData.length; i++){
			System.out.print(sortedData[i] + " ");
		}
	}

	//method 1
	public static int[] sort(int[][] data, int pre, int after){
		if(pre >= after)
			return data[pre];
		int mid = (pre + after) / 2;
		int[] left = sort(data, pre , mid);
		int[] right = sort(data, mid + 1, after);
		int[] sortedData = new int[left.length + right.length];
		for(int i = 0, j = 0; i + j < sortedData.length;){
			if(i < left.length && j < right.length){
				if(left[i] < right[j]){
					sortedData[i + j] = left[i];
					i++;
				}else{
					sortedData[i + j] = right[j];
					j++;
				}
			}else if(i < left.length){
				sortedData[i + j] = left[i];
				i++;
			}else{
				sortedData[i + j] = right[j];
				j++;
			}
		}
		return sortedData;
	}
	
	
	//method 2
	public static int[] mergeSort(int[][] data){
		int result[][] = data;
		while(result.length > 1){
			int pairNum;
			if(result.length % 2 == 0)
				pairNum = result.length / 2;
			else
				pairNum = result.length / 2 + 1;
			int[][] tmp = new int[pairNum][];
			for(int i = 0; i < pairNum && 2 * i + 1 < result.length; i++){
				tmp[i] = sort(result[2 * i], result[2 * i + 1]);
			}
			if(result.length % 2 != 0)
				tmp[tmp.length - 1] = result[result.length - 1];
			result = tmp;
		}
		return result[0];
	}
	
	public static int[] sort(int[] data1, int[] data2){
		int[] data = new int[data1.length + data2.length];
		for(int i = 0, j = 0; i + j < data.length;){
			if(i < data1.length && j < data2.length){
				if(data1[i] < data2[j]){
					data[i + j] = data1[i];
					i++;
				}else{
					data[i + j] = data2[j];
					j++;
				}
			}else if(i < data1.length){
				data[i + j] = data1[i];
				i++;
			}else{
				data[i + j] = data2[j];
				j++;
			}
		}
		return data;
	}
}
