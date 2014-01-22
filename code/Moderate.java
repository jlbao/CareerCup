// Given an array of integers , write a method to find indices m and n,
// such that if you sort elements m through n, the entire array will be sorted
// minimize n - m
// example: Input 1 2 4 7 10 11 7 12 6 7 16 18 19
// output (3, 9)

// the problem can be divided to find the max from the left side
// and find the min from the right side
public static int[] findIndexRange(int[] A){
	int[] leftMax = new int[A.length];
	int[] rightMin = new int[A.length];
	leftMax[0] = A[0];
	rightMin[rightMin.length - 1] = A[A.length - 1];
	for(int i = 1; i < A.length; i++){
		leftMax[i] = Math.max(A[i], leftMax[i - 1]);
		rightMin[A.length - 1 - i] = Math.min(A[A.length - 1 - i], rightMin[A.length - i]);
	}
	int minIndex = -1;
	int maxIndex = -1;
	for(int i = 0; i < A.length; i++){
		if(A[i] > rightMin[i] && minIndex == -1){
			minIndex = i;
		}
		if(A[A.length - i - 1] < leftMax[A.length - 1 - i] && maxIndex == -1){
			maxIndex = A.length - i - 1;
		}
		if(minIndex != -1 && maxIndex != -1){
			break;
		}
	}
	return new int[]{minIndex, maxIndex};
}

public int find1stMisOrder_begin(int[] A){
	for(int i = 0; i < A.length - 1; i++){
		if(A[i] > A[i + 1]){
			return i;
		}
	}
	return A.length - 1;
}

public int find1stMisOrder_end(int[] A){
	for(int i = A.length - 2; i >= 0; i--){
		if(A[i] > A[i + 1]){
			return i;
		}
	}
	return 0;
}

public int[] findIndexRange(int[] A){
	int begin = find1stMisOrder_begin(A);
	int end = find1stMisOrder_end(A);
	if(begin = A.length - 1){ // this is already sorted
		return new int[]{-1, -1};
	}

	for(int i = begin; i < end; i++){ // find the max index, and 
		
	}

}













