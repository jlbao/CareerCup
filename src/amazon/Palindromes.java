package amazon;

public class Palindromes {
	/**
	 * Given any string 
	 * (for e.g. "abfdRacecaRAbAorTITabcdef" 
	 * find all the palindromes	 
	 * and return the longest one. 
	 * Discuss the approach before you actually go ahead and code.
	 */
	
	public static void main(String[] args) {
		String data = "bccbabcaddd";
		int[] span = getLongestPalindrome4(data);
		System.out.println(span[0] + " " + span[1]);
		System.out.println(data.substring(span[0], span[1] + 1));
	}
	
	
	// O(n^2) time complexity, O(n^2) space complexity
	public static int[] getLongestPalindrome(String str){
		char[] data = str.toCharArray();
		boolean[][] buffer = new boolean[data.length][data.length];		
		int startIndex = 0;
		int endIndex = 0;
		
		for(int i = 0; i < buffer.length; i++){
			for(int j = 0; j < buffer[0].length; j++){
				buffer[i][j] = false;
			}
		}
		//basic set up to fill in the buffer with 1 and 2 consequent chars
		for(int i = 0; i < data.length; i++){
			buffer[i][i] = true;
		}
		for(int i = 0; i < data.length - 1; i++){
			if(data[i] == data[i + 1]){
				buffer[i][i + 1] = true;
				startIndex = i;
				endIndex = i + 1;
			}
		}
		
		//this is used to set the interval
		for(int k = 2; k < data.length; k++){ 
			//this is used to go through the whole array
			for(int i = 0; i < data.length - k; i++){ 
				int j = k + i;
				if(buffer[i + 1][j - 1] && data[i] == data[j]){
					buffer[i][j] = true;
					if(j - i > endIndex - startIndex){
						startIndex = i;
						endIndex = j;
					}
				}
			}
		}
		
		int[] range = new int[]{startIndex, endIndex};
		return range;
	}
	
	// O(n ^ 3) time complexity, O(n) space complexity
	public static int[] getLongestPalindrome2(String str){
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
	
	// O(n ^ 3) time complexity, O(1) space complexity
	public static int[] getLongestPalindrome3(String str){
			char[] data = str.toCharArray();
			int startIndex = 0, endIndex = 0;
			for(int i = 0; i < data.length; i++){
				for(int j = 0; j < data.length; j++){
					int start = i;
					int end = j;
					int mid = (start + end) / 2;
					boolean flag = true;
					while(start <= mid && end >= mid && flag){
						if(data[start] != data[end]){
							flag = false;
						}
						start++;
						end--;
					}
					if(flag && j - i > endIndex - startIndex){
						startIndex = i;
						endIndex = j;
					}
				}
			}
			int[] span = new int[]{startIndex, endIndex};
			return span;
		}
	
	// regard every element and every 2 elements as centers
	// go through the whole array
	// O(n ^ 2) time complexity, O(1) space complexity
	public static int[] getLongestPalindrome4(String str){
		char[] data = str.toCharArray();
		int startIndex = 0, endIndex = 0;
		for(int i = 0; i < data.length; i++){
			// case 1: the mid is only one data
			int start = i - 1, end = i + 1;
			while(start >= 0 && end < data.length){
				if(data[start] != data[end])
					break;
				start--;
				end++;
			}

			if(endIndex - startIndex < end - start - 2){
				startIndex = start + 1;
				endIndex = end - 1;
			}
			
			
			// case 2: the mid is 2 data
			if(i < data.length - 1 && data[i] == data[i + 1]){
				start = i - 1;
				end = i + 2;
				while(start >= 0 && end < data.length - 1){
					if(data[start] != data[end])
						break;
					start--;
					end++;
				}
				if(endIndex - startIndex < end - start - 2){
					startIndex = start + 1;
					endIndex = end - 1;
				}
			}
		}
		int[] span = new int[]{startIndex, endIndex};
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
