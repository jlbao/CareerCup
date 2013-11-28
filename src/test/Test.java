package test;

import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args) {
		int a = 3;
		System.out.println(a << 19);
		
	}
	
	public static boolean find(int[] A, int val){
		int i = 0;
		int j = A.length - 1;
		while(i <= j){
			int mid = (i + j) / 2;
			if(val == A[mid])
				return true;
			else if(A[i] <= A[mid]){
				if(val < A[i])
					i = mid + 1;
				else if(val > A[mid])
					i = mid + 1;
				else
					j = mid - 1;
			}else{
				if(val < A[mid])
					j = mid - 1;
				else if(val > A[j])
					j = mid - 1;
				else
					i = mid + 1;
			}
		}
		return false;
	}

}
