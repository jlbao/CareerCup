package recursion;

public class EightQuenes {


	public static void main(String[] args) {
		System.out.println(displayPattern(new boolean[8][8], 0, -2));
	}

	
	public static int displayPattern(boolean[][] pattern, int row, int col){
		int rowLen = pattern.length;
		int colLen = pattern[0].length;
		int count = 0;
		
		if(row == rowLen - 1)
			return 1;
		

		if(row < rowLen){
			boolean flag = true;
			
			for(int j = 0; j < colLen; j++){
				// find if this position can be inserted
				for(int i = 0; i < rowLen; i++){
					if(j > 0 && j < colLen && pattern[i][j] == true){
						flag = false;
						break;
					}
				}
				if(row - 1 > 0 && row - 1 < rowLen && j - 1 > 0 && j - 1 < colLen){
					if(pattern[row - 1][j - 1] == true){
						flag = false;
					}
				}
				
				if(row - 1 > 0 && row - 1 < rowLen && j + 1 > 0 && j + 1 < colLen){
					if(pattern[row - 1][j + 1] == true){
						flag = false;
					}
				}
				
				if(flag){
					pattern[row][j] = true;
					count = count + displayPattern(pattern,row + 1, j + 1);
					pattern[row][j] = false;
				}
			}	
		}
		return count;
	}
}
