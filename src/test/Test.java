package test;

public class Test {


	public static void main(String[] args) {

	        System.out.println(pow(6,0));
	}
	
    public static double pow(double x, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(x == 0)
            return 0;
        if(n == 0)
            return 1;
        double data = pow(x, n / 2);
        if(n % 2 == 0)
            return data * data;
        else
            return data * data * x;
    }
	
	public static String output(int num){
		int i = 0;
		for( ;num - 26 > 0; i++, num -= 26);
		
		return i == 0 ? Character.toString((char)('A' + num - 1))
					  : Character.toString((char)('A' + i - 1)) 
					  	+ Character.toString((char)('A' + num - 1));		
	}

	public static String output2(int num){
		int pre = num / 26;
		int after = num % 26;
		return pre == 0 ? Character.toString((char)('A' + after - 1))
						: Character.toString((char)('A' + pre - 1))
						+ Character.toString((char)('A' + after - 1));
	}
	
}
