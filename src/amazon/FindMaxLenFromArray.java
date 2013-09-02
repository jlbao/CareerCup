package amazon;

public class FindMaxLenFromArray {

	/**
	 * Given an array of n numbers with repetition of numbers. 
	 * You need to find the max length of 
	 * continuous sub array with at max 3 unique elements. 
	 * For eg 
	 * array: 1 2 3 1 4 3 4 1 2 
	 * ans: 6 (3 1 4 3 4 1) 
	 * Solution: Time complexity O(n) 
	 * Extra Space O(1)
	 */
	public static void main(String[] args) {
		int[] data = {1,2,3,1,4,3,4,1,2};
		System.out.println(findLen(data));		
	}

	public static int findLen(int[] data){
		int[] done = new int[3];
		int[] count = new int[3];
		int maxLen = 0;
		
		int i = 0;
		done[0] = data[0];
		for(int j = 0; i < data.length && j < 3; i++){ 
			//put all first 3 data into the done and count
			boolean flag = true;
			for(int k = 0; k <= j && flag == true; k++){
				if(done[k] == data[i]){
					count[k]++;
					flag = false;
				}
			}
			if(flag && ++j < 3){
				done[j] = data[i];
				count[j] = 1;
			}else if(j == 3)
				break;
		}	
		maxLen = i;
		int len = maxLen;
		
		//move to back one by one, and clear the count to add a new one
		for(int k = 0; k < data.length && i < data.length; k++){
			for(int t = 0; t < done.length; t++){
				if(done[t] == data[k] && count[t] > 0){
					count[t]--;
					len--;
					break;
				}
			}
			for( ; i < data.length; i++){
				int inDone = isInDone(done,count,data[i]);
				int isEmpty = isEmpty(count);
				if(inDone != -1){
					count[inDone]++;
					len++;
				}else if(isEmpty != -1){
					done[isEmpty] = data[i];
					count[isEmpty] = 1;
					len++;
				}else if(inDone == -1){
					break;
				}
				if(len > maxLen)
					maxLen = len;
			}
		}
		return maxLen;
	}

	
	public static int isInDone(int[] done, int[] count, int val){
		for(int i = 0; i < done.length; i++){
			if(done[i] == val && count[i] > 0){
				return i;
			}
		}
		return -1;
	}
	
	public static int isEmpty(int[] count){
		for(int i = 0; i < count.length; i++){
			if(count[i] == 0)
				return i;
		}
		return -1;
	}

}
