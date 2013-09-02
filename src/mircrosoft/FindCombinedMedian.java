package mircrosoft;

public class FindCombinedMedian {
	/*
	 * Given Two separate integer arrays,
	 * find the combined median of the two arrays 
	 * without using any extra array
	 */

	public static void main(String[] args) {
		int[] a = new int[]{1,2,5,6};
		int[] b = new int[]{8,9,10,12,18,20};
		System.out.println(getMedian(a, b));
	}

	public static int getMedian(int[] a, int[] b){
		a = mergeSort(a, 0, a.length - 1);
		b = mergeSort(b, 0, b.length - 1);

		int len = (a.length + b.length) / 2;
		int i = 0, j = 0;
		boolean isIna = false;
		while(i + j < len){ // i + j equals to current length
			if(i < a.length && j < b.length && a[i] < b[j])
				isIna = true;
			else if(i < a.length && j < b.length && a[i] >= b[j])
				isIna = false;
			else if(i < a.length)
				isIna = true;
			else
				isIna = false;
			
			if(isIna){
				if(++i >= a.length)
					isIna = false;
			}
			else{
				if(++j >= b.length)
					isIna = false;
			}
		}
		return isIna == true ? a[i] : b[j];
	}
	
	public static int[] mergeSort(int[] data, int i, int j){
		if(i == j)
			return new int[]{data[i]};
		int mid = (i + j) / 2;
		int[] left = mergeSort(data, i, mid);
		int[] right = mergeSort(data, mid + 1, j);
		int[] sortedData = new int[left.length + right.length];
		for(int l = 0, r = 0, k = 0; k < sortedData.length; k++){
			if(l < left.length && r < right.length && left[l] < right[r])
				sortedData[k] = left[l++];
			else if(l < left.length && r < right.length && left[l] >= right[r])
				sortedData[k] = right[r++];
			else if(l < left.length)
				sortedData[k] = left[l++];
			else 
				sortedData[k] = right[r++];
		}
		return sortedData;
	}
	
}
