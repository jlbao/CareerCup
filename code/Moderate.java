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

// method 2, no need to have space cost
public static int find1stMisOrder_begin(int[] A){
		for(int i = 0; i < A.length - 1; i++){
			if(A[i] > A[i + 1]){
				return i;
			}
		}
		return A.length - 1;
	}
	
	public static int find1stMisOrder_end(int[] A){
		for(int i = A.length - 2; i >= 0; i--){
			if(A[i] > A[i + 1]){
				return i;
			}
		}
		return 0;
	}

	public static int slideToLeft(int[] A, int minIndex, int begin){
		int val = A[minIndex];
		for(int i = begin - 1; i >= 0; i--){
			if(A[i] < val){
				return i + 1;
			}
		}
		return 0;
	}
	
	public static int slideToRight(int[] A, int maxIndex, int end){
		int val = A[maxIndex];
		for(int i = end + 1; i < A.length; i++){
			if(A[i] > val){
				return i - 1;
			}
		}
		return A.length - 1;
	}
	
	public static int[] findIndexRange(int[] A){
		int begin = find1stMisOrder_begin(A);
		int end = find1stMisOrder_end(A);
		if(begin == A.length - 1){ // this is already sorted
			return new int[]{-1, -1};
		}
		int minIndex = begin + 1;
		int maxIndex = end - 1;
		for(int i = begin; i < end; i++){ // find the index with max and min value
			if(A[minIndex] > A[i]){
				minIndex = i;
			}
			if(A[maxIndex] < A[i]){
				maxIndex = i;
			}
		}
		minIndex = slideToLeft(A, minIndex, begin);
		maxIndex = slideToRight(A, maxIndex, end);
		return new int[]{minIndex, maxIndex};
	}


// Given any integer, print an English phrase that describes the integer
// (e.g "One thousand, two Hundred Thirty Four")


// You are given an array of integers(both positive and negative).
// Find the contiguous with the largest Sum. Return the sum.
// Example: input: 2 -8 3 -2 4 -10
// output: 5 (3, -2, 4)

// this can be solved by dynamic programming
// rightMax[i] = max(A[i], A[i] + rightMax[i]);
// rightMax[i] stores the max sum starting from i
public static int findMaxSum(int[] A){
	int[] rightMax = new int[A.length];
	rightMax[A.length - 1] = A[A.length - 1];
	int max = rightMax[A.length - 1];
	for(int i = A.length - 2; i >= 0; i--){
		rightMax[i] = Math.max(rightMax[i + 1] + A[i], A[i]);
		max = Math.max(max, rightMax[i]);
	}
	return max;
}

// design a method to find the frequency of occurebnces of any given word in a book

// just put all words into the hashtable
public static int getFrequency(String[] list, String str){
	java.util.Hsahtable<String, Integer> table = new java.util.Hashtable<String, Integer>();
	for(String s : list){
		s = s.toLowerCase();
		if(table.containsKey(s)){
			table.put(s, table.get(s) + 1);
		}else{
			table.put(s, 1);
		}
	}
	return table.get(str);
}

// Design an algorithm to find all pairs of integers within an array which sum to a specified value
public static ArrayList<int[]> getAllPairs(int[] A, int target){
	// key is the element value, value is the index
	java.util.Hashtable<Integer, Integer> table = new java.util.Hashtable<Integer, Integer>();
	ArrayList<int[]> list = new ArrayList<int[]>();
	for(int i = 0; i < A.length; i++){
		table.put(A[i], i);
	}
	for(int i = 0; i < A.length; i++){
		int val = target - A[i];
		if(table.containsKey(val) && table.get(val) != i){
			int[] pair = new int[]{A[i], val};
			list.add(pair);
			table.remove(val);
			table.remove(A[i]);
		}
	}
	return list;
}

// Write an algorithm which computes the number of trailing zeros in n factorial.

// only 2 and 5 will come up with a 10

public int get5Count(int n){
	int count = 0;
	while(n % 5 == 0){
		count++;
		n = n / 5;
	}
	return count;
}

public int getZeroCount(int n){
	int count = 0;
	for(int i = 1; i <= n; i++){
		count += get5Count(i);
	}
	return count;
}

public int countFactorZeros(int n){
	int count = 0;
	for(int i = 5; n / i > 0; i = i * 5){
		count += n / i;
	}
	return count;
}






