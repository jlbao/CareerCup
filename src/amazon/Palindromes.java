package amazon;

public class Palindromes {
	/**
	 * Given any string 
	 * (for e.g. "abfdRacecaRAbAorTITabcdef" 
	 * find all the palindromes	 
	 * and return the longest one. 
	 * Discuss the approach before you actually go ahead and code.
	 */
	public static int count = 0;
	
	public static void main(String[] args) {
		String data = "abccbaaaaddd";
		int[] span = getLongest(data);
		System.out.println(span[0] + " " + span[1]);
		System.out.println(data.substring(span[0], span[1] + 1));
	}
	
	public static int[] getLongest(String str){
		char[] data = str.toCharArray();
		int[] index = new int[data.length];
		int[] buffer = new int[256]; //store pre index
		int max = 0;
		int[] span = new int[2];
		
		for(int i = data.length - 1; i >= 0; i--){
			index[i] = buffer[data[i]] == 0 ? -1 : buffer[data[i]];
			buffer[data[i]] = i;
		}
		
		for(int i = 0; i < index.length && index[i] != -1 ; i++){
			int cur = i;
			int j = index[i];
			while(j != -1){
				for(; j != -1; j = index[j]){
					if(isPaloindromes(data,cur,j) == true){
						if(max < j - cur + 1){
							max = j - cur + 1;
							span[0] = cur;
							span[1] = j;
						}
					}
				}
				int tmp = cur;
				index[tmp] = -1;
				cur = index[cur];
				j = cur == -1 ? -1 : index[cur];
			}
		}
		return span;
	}
	
	public static boolean isPaloindromes(char[] data, int i, int j){
		int count = j - i == 1 ? 1 : (j - i) / 2;
		for(int k = 0; k < count; k++){
			if(data[i + k] != data[j - k])
				return false;
		}
		return true;
	}
	
}
