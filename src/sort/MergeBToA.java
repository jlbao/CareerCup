package sort;

public class MergeBToA {

	/**
	 * 2 sorted arrays, A and B, where A has enough buffer at the end to hold B
	 * Merge B into A in sorted order
	 */
	public static void main(String[] args) {
		int[] A = {1, 3, 5, 6, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] B = {2, 4, 9};
		int aLen = 5;
		merge(A, B, aLen);
		
		for(int i = 0; i < aLen + B.length; i++){
			System.out.print(A[i] + " ");
		}
	}
	
	public static void merge(int[] A, int[] B, int aLen){
		int k = aLen + B.length - 1;
		int i = aLen - 1;
		int j = B.length - 1;
		while(j >= 0){
			if(i >= 0){
				if(A[i] < B[j]){
					A[k] = B[j];
					j--;
				}else{
					A[k] = A[i];
					i--;
				}
			}else{
				A[k] = B[j];
				j--;
			}
			k--;
		}
	}


}
