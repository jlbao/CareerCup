package recursion;

public class FindMagicIndex {

	/**
	 * Find the magic index for A[i] = i in increasing sorted array 
	 * may have duplicate elements
	 */
	public static void main(String[] args) {
		int[] A = {0, 1, 1, 2, 3, 5, 6, 7, 8};
		int idx = find(A, 0, A.length - 1);
		System.out.println(idx);
	}

	public static int find(int[] A, int l, int r){
		if(l > r){
			return -1;
		}
		int mid = (l + r) / 2;
		if(mid == A[mid]){
			return mid;
		}else if(mid < A[mid]){
			if(A[mid] <= r){
				int idx = find(A, A[mid], r);
				if(idx != -1){
					return idx;
				}
			}
			int idx = find(A, l, mid - 1);
			return idx;
		}else{
			if(A[mid] >= l){
				int idx = find(A, l, A[mid]);
				if(idx != -1){
					return idx;
				}
			}
			int idx = find(A, mid + 1, r);
			return idx;
		}
	}
	
}
