package acre;

public class RecursionFindMaxIndex {

	/**
	 * Use recursion to find the index of max value in an array
	 */
	public static void main(String[] args) {
		int[] data = {16,12,25,22,26,28,88,36,86,66};
		int result = findIndex(data,0);
		System.out.println(result);
	}
	
	public static int findIndex(int[] data, int i){
		if(data.length - 1 == i)
			return i;
		int preMaxIndex = findIndex(data, i + 1);
		return data[i] > data[preMaxIndex] ? i : preMaxIndex;
	}

}
