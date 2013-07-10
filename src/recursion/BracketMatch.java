package recursion;

import java.util.HashSet;

public class BracketMatch {

	public static void main(String[] args) {
		HashSet<String> set = bracketMatch(3);
		for(String data : set)
			System.out.print(data + " ");
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
	
	
}
