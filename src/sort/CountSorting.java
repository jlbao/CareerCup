package sort;

public class CountSorting {

	/**
	 * Counting sort from introduction to algorithms
	 * usually used for a range of number
	 * in this example, it give the range from 0 to k
	 */
	public static void main(String[] args) {
		int[] data = {3,5,2,2,1,2,0,3,2,5,6};
		data = countSort(data, 6);
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}
	}
	
	public static int[] countSort(int[] data, int k){
		int[] tmp = new int[k + 1];
		int[] output = new int[data.length];
		for(int i = 0; i < data.length; i++)
			tmp[data[i]]++;
		for(int i = 1; i < tmp.length; i++){
			if(i == 1 && tmp[0] != 0)
				tmp[i] = tmp[i] + tmp[i - 1] - 1;
			else
				tmp[i] = tmp[i] + tmp[i - 1];
		}
		for(int i = data.length - 1; i >= 0; i--){
			output[tmp[data[i]]] = data[i];
			tmp[data[i]]--;
		}
		return output;
	}
}
