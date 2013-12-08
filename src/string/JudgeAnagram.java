package string;

public class JudgeAnagram {


	public static void main(String[] args) {
		String str1 = "helloworld";
		String str2 = "ehllwoodlr";
		System.out.println(isAnagram(str1,str2));
	}
	
	public static boolean isAnagram(String str1, String str2){
		if(str1.length() != str2.length())
			return false;
		
		int buffer[] = new int[256];
		
		for(int i = 0; i < str1.length(); i++){
			buffer[(int)str1.charAt(i)]++;
		}
		
		for(int i = 0; i < str2.length(); i++){
			buffer[(int)str2.charAt(i)]--;
			if(buffer[(int)str2.charAt(i)] < 0){
				return false;
			}
		}
		return true;
	}

}
