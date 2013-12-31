package sort;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

public class GroupString {

	/**
	 * Write a method to sort an array of strings so that anagrams are next to each other
	 */
	public static void main(String[] args) {
		String[] strs = {"abc", "dsf", "cbd", "cba", "sfd", "bac"};
		group(strs);
		for(String val : strs){
			System.out.print(val + " ");
		}
	}

	public static void group(String[] A){
		Hashtable<String, LinkedList<String>> table = new Hashtable<String, LinkedList<String>>();
		for(int i = 0; i < A.length; i++){
			String sortedStr = sortedString(A[i]);
			if(!table.containsKey(sortedStr)){
				table.put(sortedStr, new LinkedList<String>());
			}
			LinkedList<String> list = table.get(sortedStr);
			list.add(A[i]);
		}
		int index = 0;
		for(LinkedList<String> list: table.values()){
			for(String val : list){
				A[index++] = val;
			}
		}
	}

	// Sort String array
	public static String sortedString(String str){
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

}
