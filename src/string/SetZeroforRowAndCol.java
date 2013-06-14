package string;

public class SetZeroforRowAndCol {

	public static void main(String[] args) {
		
		int a[][] = {{1,2,3},{2,0,6}};
		int b[][] = setZeroForRowAndCol(a);
		print(b);

	}
	
	public static int[][] setZeroForRowAndCol(int a[][]){
		int m = a.length;
		int n = a[0].length;
		
		int row[] = new int[m];
		int col[] = new int[n]; 
		
		for(int i = 0; i < m; i ++){ //set row and col
			for(int j = 0; j < n; j++){
				if(a[i][j] == 0){
					row[i] = 1;
					col[j] = 1;
				}
			}
		}
		
		//set row
		for(int i = 0; i < m; i++){
			if(row[i] == 1){
				for(int j = 0; j < n; j++){
					a[i][j] = 0;
				}
			}
		}
		
		//set col
		for(int j = 0; j < n; j++){
			if(col[j] == 1){
				for(int i = 0; i < m; i++){
					a[i][j] = 0;
				}
			}
		}
		return a;
	}

	
	// print the 2-d array
	public static void print(int a[][]){
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[i].length; j ++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

}
