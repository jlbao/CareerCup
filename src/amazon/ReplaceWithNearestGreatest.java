package amazon;
/*
 * A array of N elements, 
 * we have to replace all the elements
 * with nearest greater 
 * which is present on the right side 
 * of that elements. O(n) is required
 */

public class ReplaceWithNearestGreatest {

	public static void main(String[] args) {
		int[] data = {1,5,3,2,9,8};
		int[] newData = getReplacement2(data);
		for(int value : newData){
			System.out.print(value + " ");
		}
	}
	
	public static int[] getReplacement(int[] data){
		int[] index = new int[data.length];
		int[] newData = new int[data.length];
		index[index.length - 1] = -1;
		for(int i = data.length - 1; i >= 1; i--){
			int j = i;
			while(true){
				if(data[i - 1] < data[j]){
					index[i - 1] = j;
					break;
				}else{
					j = index[j];
					if(j == -1){
						index[i - 1] = -1;
						break;
					}
				}
			}
		}
		
		for(int i = 0; i < newData.length; i++)
			newData[i] = index[i] == -1 ? data[i] : data[index[i]];			
		
		return newData;
	}
	
	
	public static int[] getReplacement2(int[] data){
		int[] store = new int[data.length];
		for(int i = data.length - 1; i >= 0; i--){
			store[i] = data[i];
			for(int j = i + 1; j < store.length; j++){
				if(data[i] < data[j]){
					store[i] = data[j];
					break;
				}else if(data[i] < store[j]){
					store[i] = store[j];
					break;
				}
			}
		}
		return store;
	}
	
}
