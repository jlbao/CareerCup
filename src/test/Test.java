package test;

import java.util.ArrayList;

class A<T>{
	private void test(){
		System.out.println("A");
	}
	public void output(){
		test();
	}
}

public class Test {
	
	public static void main(String[] args) {
		char[] data = {'1', '2', '3', '4'};
		int len = data.length / 2;
		for(int i = 0; i < len; i++){
			// swap the 2 elements
			char tmp = data[i];
			data[i] = data[data.length - 1 - i];
			data[data.length - 1 - i] = tmp;
		}
		for(char c : data){
			System.out.print(c + " ");
		}
	}
	
	
    public ArrayList<String[]> solveNQueens(int n) {
        int[] column = new int[n];
        for(int i = 0; i < column.length; i++){
            column[i] = -1;
        }
        return nQueues(n, new int[n], 0);
    }
    
    public ArrayList<String[]> nQueues(int n, int[] column, int curRow){
        ArrayList<String[]> list = new ArrayList<String[]>();
        for(int i = 0; i < n; i++){
            if(isValid(curRow, i, column)){
                if(curRow != n - 1){
                    column[curRow] = i;
                    ArrayList<String[]> prevList = nQueues(n, column, curRow + 1); // get the data from the next row
                    String rowString = getString(n, i);
                    for(int j = 0; j < prevList.size(); j++){ // fill the data into the row
                        prevList.get(j)[curRow] = rowString;
                    }
                    // clear it
                    column[curRow] = -1;
                    // add to the list
                    list.addAll(prevList);
                }else{ // this is the last row, we do not need to go to next
                    String[] strList = new String[n];
                    strList[curRow] = getString(n, i);
                    list.add(strList);
                    return list;
                }
            }
        }
        return list;
    }
    
    public String getString(int n, int k){
        String str = "";
        for(int i = 0; i < n; i++){
            if(i == k){
                str += "Q";
            }else{
                str += ".";
            }
        }
        return str;
    }
    
    public boolean isValid(int i, int j, int[] column){
        // check top elements
        for(int k = i - 1; k >= 0; k--){
            if(column[k] == j){
                return false;
            }
        }
        
        // check the left-top and top-right diagnol
        int d = 1;
        for(int k = i - 1; k >= 0; d++,k--){
            if(column[k] == j - d || column[k] == j + d){
                return false;
            }
        }
        return true;
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
