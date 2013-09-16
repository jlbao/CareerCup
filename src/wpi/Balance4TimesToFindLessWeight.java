package wpi;

public class Balance4TimesToFindLessWeight {

	/**
	 * You have 81 quarters and a balance. 
	 * You know that 80 quarters have the same weight,
	 * and one weighs less than the others
	 * write a program to identify the light quarter
	 * and use the balance only 4 times in the worse case 
	 */
	public static void main(String[] args) {
		int[] data = new int[81];
		for(int i = 0; i < data.length; i++){
			data[i] = 18;
		}
		data[25] = 16;
		int result = weigh(data, 0, data.length - 1);
		System.out.println(result);
	}
	
	public static int weigh(int[] data, int i, int j){
		if(i == j)
			return i;
		int k1 = (j - i + 1) / 3 + i;
		int k2 = (j - i + 1) / 3 + k1;
		int balanceResult = balance(data, i, k1 - 1, k1, k2 - 1);
		if(balanceResult == 0)
			return weigh(data, k2, j);
		else if(balanceResult > 0)
			return weigh(data,k1, k2 - 1);
		else
			return weigh(data, i, k1 - 1);
	}
	
	public static int balance(int[] data, int l1, int h1, int l2, int h2){
		int totalWeight1 = 0;
		int totalWeight2 = 0;
		for(int k = l1; k <= h1; k++)
			totalWeight1 += data[k];
		for(int k = l2; k <= h2; k++)
			totalWeight2 += data[k];
		if(totalWeight1 > totalWeight2)
			return 1;
		else if(totalWeight1 == totalWeight2)
			return 0;
		else
			return -1;
	}
	

}
