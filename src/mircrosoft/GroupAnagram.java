package mircrosoft;

import java.util.ArrayList;

public class GroupAnagram {

	/**
	 * Given array of words, group the anagrams 
	 * IP:{tar,rat,banana,atr} 
	 * OP:{[tar,rat,atr],[banana]}
	 */
	public static void main(String[] args) {
		String[] data = {"tar","rat","banana","atr","abanna"};
		String[][] returnValue = groupAnagrams(data);
		for(int i = 0; i < returnValue.length; i++){
			for(int j = 0; j < returnValue[i].length; j++){
				System.out.print(returnValue[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	public static String[][] groupAnagrams(String[] data){
		ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < data.length; i++){
			if(data[i] != null){
				ArrayList<String> list = new ArrayList<String>();
				list.add(data[i]);
				for(int j = i + 1; j < data.length; j++){
					if(data[j] != null && isAnagram(data[i],data[j])){
						list.add(data[j]);
						data[j] = null;
					}
				}
				all.add(list);
			}
		}

		String[][] group = new String[all.size()][];
		for(int i = 0; i < group.length; i++){
			group[i] = new String[all.get(i).size()];
			for(int j = 0; j < all.get(i).size(); j++){
				group[i][j] = all.get(i).get(j);
			}
		}
		return group;
	}
	
	
	
	private static boolean isAnagram(String data1, String data2){
		if(data1.length() != data2.length())
			return false;
		int[] buffer = new int[256];
		for(int i = 0; i < data1.length(); i++){
			buffer[data1.charAt(i)]++;
		}
		for(int i = 0; i < data1.length(); i++){
			buffer[data2.charAt(i)]--;
		}
		for(int i = 0; i < buffer.length; i++){
			if(buffer[i] != 0)
				return false;
		}
		return true;
	}

}
