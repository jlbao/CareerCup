package string;

public class RemoveDuplicateChars {

	public static void main(String[] args) {
		String a = "abbbc";
		System.out.println(removeDuplicateChars(a));

	}
	
	public static String removeDuplicateChars(String str){
		char[] c = str.toCharArray();
		int k = 0;
		for(int i = 0; i < c.length; i ++){
			
			int j = 0;
			for( ; j < k; j++){
				if(c[j] == c[i])
					break;
			}
			if (j == k){ // not equal
				c[k] = c[i];
				k ++;
			}			
		}
		
		if (k < c.length){
			c[k] = '\0';
		}
		
		return new String(c);
		
	}

}
