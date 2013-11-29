package search;

public class CheckPrimeNumber {

	/**
	 * Check a number is prime number or now
	 * the defination of prime number, a number can only be divided by it self or 1.
	 */
	public static void main(String[] args) {
		//boolean result = isPrimeNumber(131);
		//System.out.println(result);
		int[] primeNums = findNPrimeNums(100);
		for(int i = 0; i < primeNums.length; i++){
			System.out.print(primeNums[i] + " ");
		}
	}
	
	// find top n prime numbers
	public static int[] findNPrimeNums(int n){
		int[] nums = new int[n];
		int j = 2;
		for(int i = 0; i < nums.length; i++){
			while(!isPrimeNumber(j)){
				j++;
			}
			nums[i] = j;
			j++;
		}
		return nums;
	}
	
	// check if the number is prime number or not
	public static boolean isPrimeNumber(int n){
		if(n == 2)
			return true;
		for(int i = 2; i * i <= n; i++){
			if(n % i == 0)
				return false;
		}
		return true;
	}

}
