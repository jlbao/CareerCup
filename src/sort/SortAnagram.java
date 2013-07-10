package sort;

public class SortAnagram {

	public static void main(String[] args) {
		String data[] = {"lleho", "oob", "eholl", "boo","abc","xxy","hello","obo", "cba"};
		data = sortAnagram(data);
		for(String str:data){
			System.out.print(str + " ");
		}
	}
	
	public static String[] sortAnagram(String data[]){
		
		for(int i = 0; i < data.length; ){
			boolean flag = true;
			for(int j = i + 1; j < data.length; j++){
				if(isAnagram(data[i],data[j])){ //if this is the anagram, swap
					String temp = data[++i];
					data[i] = data[j];
					data[j] = temp;
					flag = false;
				}
			}
			if(flag) //decide whether should move to next
				i++;
		}
		return data;
	}
	
	public static boolean isAnagram(String a, String b){
		if(a.length() != b.length())
			return false;
			
		int[] buffer = new int[256];
		for(int i = 0; i < a.length(); i++){
			buffer[(int)a.charAt(i)]++;
		}
		for(int i = 0; i < b.length(); i++){
			buffer[(int)b.charAt(i)]--;
		}
		
		for(int i = 0; i < buffer.length; i++){
			if(buffer[i] != 0)
				return false;
		}
		return true;
	}
}
