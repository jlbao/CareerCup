package amazon;

public class Divide2Array {

	/**
	 * Given a array of size n. 
	 * Divide the array in to two arrays of size n/2,n/2. 
	 * such that average of two arrays is equal.
	 */
	public static void main(String[] args) {
		int[] data = {2,2,4,4,6,6,8,8,12,16};
		boolean[] store = new boolean[data.length];
		int sum = 0;
		for(int i = 0; i < data.length; i++){
			sum += data[i];
		}
		if(sum % 2 == 0 && data.length % 2 == 0){
			boolean[] results = divide(data, 0, store, sum / 2);
			if(results != null){
				for(int i = 0; i < store.length; i++){
					if(results[i])
						System.out.print(data[i] + " ");
				}
				System.out.println();
			}else
				System.out.println("impossible");
		}else
			System.out.println("impossible");
	}
	
	public static boolean[] divide(int[] data, int startIndex, boolean[] store, int total){
		for(int i = 0; i < store.length; i++){
			if(store[i] == false){
				if(total - data[i] > 0 && getTrueCount(store) < data.length / 2){
					store[i] = true;
					boolean[] pre = divide(data, i + 1 , store, total - data[i]);
					if(pre != null)
						return store;
					else
						store[i] = false;
				}else if(total - data[i] == 0 && getTrueCount(store) == data.length / 2 - 1){
					store[i] = true;
					return store;
				}
			}			 	
		}
		return null;
	}
	
	public static int getTrueCount(boolean[] store){
		int count = 0;
		for(int i = 0; i < store.length; i++){
			if(store[i] == true)
				count++;
		}
		return count;
	}

}
