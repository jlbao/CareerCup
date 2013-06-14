package string;

// judge whether a string have different chars
public class JudgeUniqueString {

	public static void main(String[] args) {
		System.out.println(isUniqueChars2("abc"));
	}
	
	public static boolean isUniqueChars2(String str) {
		boolean char_sets[] = new boolean[256];
		for (int i = 0; i < str.length(); i++){
			int c = str.charAt(i);
			if(char_sets[c])
				return false;
			char_sets[c] = true;
		}
		return true;
	}

}
