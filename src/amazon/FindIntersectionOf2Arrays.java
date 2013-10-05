package amazon;

public class FindIntersectionOf2Arrays {

	/**
	 * Online assessment problem 1:
	 * Given two lists of integers, 
	 * write a function that returns a list 
	 * that contains only the intersection 
	 * (elements that occur in both lists) of the two lists. 
	 * The returned list should only contain unique integers, no duplicates.
	 * For example, [4, 2, 73, 11, -5] and [-5, 73, -1, 9, 9, 4, 7] 
	 * would return the list [-5, 4, 73] in no particular order.
	 */
	
	public static void main(String[] args) {
		int[] data1 = {0, 5, 3, 8, 15, 9, 6, 28, 16, 18};
		int[] data2 = {2, 6, 8, 15, 9};
		int[] intersections = findIntersection(data1, data2);
		for(int i = 0; i < intersections.length; i++){
			System.out.print(intersections[i] + " ");
		}
	}
	
	public static int[] findIntersection(int[] data1, int[] data2){
		int[] sortedData = mergeSort(data1, 0, data1.length - 1);
		int[] intersectionIndex = new int[data2.length];
		for(int i = 0; i < intersectionIndex.length; i++){
			intersectionIndex[i] = -1;
		}
		
		//find all intersection index and put them into an array
		for(int i = 0; i < data2.length; i++){  
			intersectionIndex[i] = binarySearch(sortedData, 0, sortedData.length - 1, data2[i]);
		}
		
		//that array may include -1 or duplications
		intersectionIndex = mergeSort(intersectionIndex, 0, intersectionIndex.length - 1);
		int intersectionCount = intersectionIndex[0] == -1 ? 0 : 1;
		for(int i = 1; i < intersectionIndex.length; i++){
			if(intersectionIndex[i] != -1)
				if(intersectionIndex[i] != intersectionIndex[i - 1])
					intersectionCount++;
				else
					intersectionIndex[i] = -1;
		}
		
		//create a new array that stores all the unified intersections
		int[] intersections = new int[intersectionCount];
		for(int i = 0, j = 0; i < intersectionIndex.length; i++){
			if(intersectionIndex[i] != -1){
				intersections[j++] = sortedData[intersectionIndex[i]];
			}
		}
		
		return intersections;
	}
	
	public static int binarySearch(int[] data, int i, int j, int value){
		while(i <= j){
			int mid = (i + j) / 2;
			if(data[mid] == value)
				return mid;
			else if(data[mid] < value)
				i = mid + 1;
			else
				j = mid - 1;
		}
		return -1;
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
