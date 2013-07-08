package recursion;

public class EightQuenes {

	public static void main(String[] args) {
		System.out.println(displayPattern(new boolean[8][8], 0));
	}
	
	public static int displayPattern(boolean[][] pattern, int row){
		int rowLen = pattern.length;
		int colLen = pattern[0].length;
		int count = 0;
		
		for(int j = 0; j < colLen; j++){
			// find if this position can be inserted	
			boolean flag = true;
			int leftDiagonal = j - 1;
			int rightDiagonal = j + 1;
			for(int i = row - 1; i >= 0; i--){
				if(pattern[i][j] == true){ //upper
					flag = false;
					break;
				}
				else if(leftDiagonal >= 0 && pattern[i][leftDiagonal--] == true){
					//left diagonal
					flag = false;
					break;
				}
				else if(rightDiagonal < colLen && pattern[i][rightDiagonal++] == true){
					//right diagonal
					flag = false;
					break;
				}
			}

			if(flag){
				if(row == rowLen - 1)
					return 1;
				pattern[row][j] = true;
				count = count + displayPattern(pattern,row + 1);
				pattern[row][j] = false;
			}
		}	
		
		return count;
	}
}
