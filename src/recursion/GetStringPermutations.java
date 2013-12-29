package recursion;

import java.util.ArrayList;

public class GetStringPermutations {

	/**
	 * write a method to compute all permutations of a string of unique characters
	 */
	public static void main(String[] args) {
		String str = "abc";
		ArrayList<String> list = getPermutations(str);
	
		for(String s: list){
			System.out.println(s);
		}
	}

	public static ArrayList<String> getPermutations(String str){
		ArrayList<String> list = new ArrayList<String>();
		list.add("");
		for(int i = 0; i < str.length(); i++){
			ArrayList<String> newList = new ArrayList<String>();
			for(int j = 0; j < list.size(); j++){
				newList.addAll(permuteString(list.get(j), str.charAt(i)));
			}
			list = newList;
		}
		return list;
	}
	
	// permute the String, using subString
	public static ArrayList<String> permuteString(String s, char c){
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < s.length() + 1; i++){
			String str1 = s.substring(0, i);
			String str2 = s.substring(i, s.length());
			String newStr = str1 + c + str2;
			list.add(newStr);
		}
		return list;
	}
	
	
	// permute the string
	public static ArrayList<String> permute(String s, char c){
		ArrayList<String> list = new ArrayList<String>();
		char[] oldChars = s.toCharArray();
		for(int i = 0; i < s.length() + 1; i++){ // find place to insert the new char
			char[] newChars = new char[s.length() + 1];
			newChars[i] = c; // put the insert char
			for(int j = 0, k = 0; j < oldChars.length; j++, k++){ // copy original to new string
				if(i == j){ // this slot has been inserted by the insert char
					k++; // k is in charge of the index of new char array
				}
				newChars[k] = oldChars[j];
			}
			String newStr = new String(newChars);
			list.add(newStr);
		}
		return list;
	}
}
