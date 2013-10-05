package amazon;

public class FindMostFrequentNumInArray {

	/**
	 * Find the most frequent number in an array
	 */
	public static void main(String[] args) {
		int[] data = new int[]{2, 3, 18, 18, 2, 19, 18, 18, 2, 18};
		int mostFrequentNum = find2(data);
		System.out.println(mostFrequentNum);
	}
	
	//solution 1: search in O(n^2)
	public static int find(int[] data){
		int maxCount = 0;
		int index = 0;
		for(int i = 0; i < data.length; i++){
			int count = 1;
			for(int j = i + 1; j < data.length; j++){
				if(data[j] == data[i])
					count++;
			}
			if(count >= maxCount){
				maxCount = count;
				index = i;
			}
		}
		return data[index];
	}
	
	//solution 2: first merge sort, then find the most frequent
	//O(nlogn)
	public static int find2(int[] data){
		data = mergeSort(data, 0, data.length - 1);
		int maxCount = 1;
		int index = 0;
		for(int i = 1, count = 1; i < data.length; i++){
			if(data[i] == data[i - 1]){
				count++;
				if(count > maxCount){
					maxCount = count;
					index = i;
				}
			}else{
				count = 1;
			}
		}
		return data[index];
	}
	
	//bad solution: dynamic programming to store temp results
	//not applicable in this situation
	public static int find3(int[] data){
		int[] store = new int[data.length];
		for(int i = data.length - 1; i >= 0; i--){
			boolean flag = true;
			for(int j = i + 1; j < store.length; j++){
				if(data[i] == data[j]){
					store[i] = j;
					flag = false;
					break;
				}
			}
			if(flag)
				store[i] = -1;
		}

		int mostFrequentTimes = 0;
		int index = 0;
		for(int i = 0; i < store.length; i++){
			int count = 1;
			int startIndex = i;
			for(int next = i; next != -1; next = store[next]){
				int tmp = next;
				next = store[next];
				store[tmp] = -1; //clear the current store
				count++;
				if(next == -1)
					break;
			}
			if(count > mostFrequentTimes){
				mostFrequentTimes = count;
				index = startIndex;
			}
		}
		return data[index];
	}

	public static int[] mergeSort(int[] data, int i, int j){
		if(i >= j)
			return new int[]{data[i]};
		int mid = (i + j) / 2;
		int[] left = mergeSort(data, i, mid);
		int[] right = mergeSort(data, mid + 1, j);
		int[] sortedData = new int[left.length + right.length];
		for(int l = 0, r = 0; l + r < sortedData.length;){
			if(l < left.length && r < right.length){
				if(left[l] < right[r]){
					sortedData[l + r] = left[l];
					l++;
				}else{
					sortedData[l + r] = right[r];
					r++;
				}
			}else if(l < left.length){
				sortedData[l + r] = left[l];
				l++;
			}else{
				sortedData[l + r] = right[r];
				r++;
			}
		}
		return sortedData;
	}
}
