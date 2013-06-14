package string;

// write code to reverse a C-Style String(with a '\0' at the end of the string)
public class ReverseString {

	public static void main(String[] args) {
		String a = "helloworld\0";
		System.out.println(getReverseString(a));

	}

	public static String getReverseString(String str){
		char[] c = str.toCharArray();
		for (int i = 0; i < (c.length - 1)/2; i++){
			char temp = c[c.length - 2 - i];
			c[c.length - 2 - i ] = c[i];
			c[i] = temp;
		}
		return new String(c);
	}
	
}
