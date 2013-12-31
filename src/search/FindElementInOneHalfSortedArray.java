package search;

public class FindElementInOneHalfSortedArray {

	public static void main(String[] args) {
		int[] data = {5,8,35,39,5,5,5,5,5};
		int index = find(data, 35, 0, data.length - 1);
		System.out.println(index);
		int[] data2 = {2, 2, 2, 2, 2, 3, 4, 5, 2};
		index = find(data2, 5, 0, data.length - 1);
		System.out.println(index);
	}
	
	public static int find(int[] A, int val, int l, int r){
		if(l > r){
			return -1;
		}
		int mid = (l + r) / 2;
		if(A[mid] == val){
			return mid;
		}
		if(A[mid] > A[l]){ // left is in increasing order
			if(val > A[mid]){
				return find(A, val, mid + 1, r);
			}else if(val >= A[l]){
				return find(A, val, l, mid - 1);
			}else{
				return find(A, val, mid + 1, r);
			}
		}else if(A[mid] < A[l]){ // right is in increasing order
			if(val < A[mid]){
				return find(A, val, l, mid - 1);
			}else if(val <= A[r]){
				return find(A, val, mid + 1, r);
			}else{
				return find(A, val, l, mid - 1);
			}
		}else{ // A[mid] == A[l]
			// 2 2 2 2 2 3 4 5 6 1
			if(A[mid] != A[r]){ // search right
				return find(A, val, mid + 1, r);
			}else{ // search left first
				// 2 2 2 2 2 3 4 5 1 2
				// 2 3 4 5 2 2 2 2 2 2
				int res = find(A, val, l, mid - 1);
				if(res != -1){
					return res;
				}
				return find(A, val, mid + 1, r);
			}
		}
	}
}
