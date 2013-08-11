package dp;

public class ApplePlate {

	public static int count = 0;
	
	public static void main(String[] args) {
		int m = 7; // apples
		int n = 3; // plates
		System.out.println(put(m,n));
	}

	
	//put(m - n, n) means every plate has an apple, the rest decide which plate to put
	//put(m, n - 1) means one plate has no apple, the rest decide
	public static int put(int m, int n){
		 if(m < 0)
			 return 0;
		 if(m == 0||n == 1)
			 return 1;
		 return put(m - n, n) + put(m,n - 1);
	}

	//no sequence
	public static int put2(int m, int n){
		if(m == 0 || n == 1)
			return 1;
		int count = 0;
		for(int i = 0; i <= m; i++){
			count += put2(m - i, n - 1);
		}
		return count;
	}
	
	
}
