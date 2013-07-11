package recursion;

import java.util.HashSet;

public class BracketMatch {

	public static void main(String[] args) {
		/* method 1, use pre result to insert */
		HashSet<String> set = bracketMatch(3);
		for(String data : set)
			System.out.print(data + " ");
		
		System.out.println();
		
		/* method 2, insert to match bracket, revese to method 1 */
	
		printMatchedBracket("", 3, 3);
	}

	public static HashSet<String> bracketMatch(int n){
		if(n == 1){
			HashSet<String> data = new HashSet<String>();
			data.add("()");
			return data;
		}
		HashSet<String> preResult = bracketMatch(n - 1);
		HashSet<String> newResult = new HashSet<String>();
		for(String data:preResult){
			data = "(" + data;
			int left = 0;
			int right = 0;
			for(int i = 0; i < data.length(); i++){
				if(data.charAt(i) == ')')
					right++;
				else
					left++;
				if(left > right)
					newResult.add(insertString(data, ")", i + 1));
			}
		}
		return newResult;
	}
	
	public static String insertString(String str, String data, int index){
		String str1 = str.substring(0, index);
		String str2 = str.substring(index);
		return str1 + data + str2;
	}
	
	
	//another method to concat
	public static void printMatchedBracket(String result, int left, int right){
		if(left == 0 && right == 0)
			System.out.print(result + " ");
		else if(left < right && left > 0){
			printMatchedBracket(result + "(", left - 1, right);
			printMatchedBracket(result + ")", left, right - 1);
		}else if(left == right)
			printMatchedBracket(result + "(", left - 1, right);
		else if(left == 0 && right > 0)
			printMatchedBracket(result + ")", left, right - 1);
	}
}
