package sort;

public class SortTwoSortedArray { //a has enough buffer to hold b's value

	public static void main(String[] args) {
		int[] a = {5,8,15,19,20,27,39,60,0,0,0,0,0,0,0,0,0}; 
		int[] b = {18,25,89};
		a = sortTwoArray(a,b,8);
		for(int i:a){
			System.out.print(i + " ");
		}	
	}
	
	public static int[] sortTwoArray(int a[], int b[], int len_a){
		int i = len_a - 1; //len_a is valid length for a
		int j = b.length - 1;
		int k = i + j + 1;
		
		while(i >= 0 && j >= 0){
			if(a[i] > b[j]){
				a[k--] = a[i--];
			}else{
				a[k--] = b[j--];
			}
		}
		while(j >= 0){
			a[k--] = b[j--];
		}
		
		return a;
	}
}
