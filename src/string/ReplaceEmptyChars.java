package string;

public class ReplaceEmptyChars {

	public static void main(String[] args) {
		String str = "hello world";
		System.out.println(removeEmptyChars(str));

	}
	
	public static String removeEmptyChars(String str){
		int n = 0; //empty chars appearance times
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == ' ')
				n++;
		}
		
		if(n == 0)
			return str;
		
		char[] c = new char[str.length() + 2 * n];
		int t = 0;
		
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == ' '){
				c[i + 2 * t] = '%';
				c[i + 2 * t + 1] = '2';
				c[i + 2 * t + 2] = '0';
				t++;
			}else{
				c[i + 2 * t] = str.charAt(i);
			}
		}
		return new String(c);
		
	}
	

}
