package mircrosoft;

public class ConvertBase {

	/**
	 * Convert a base 2 number to a base 4 number
	 * example: 
	 * base2: | 11 | 01 | 01 | 10 |
	 * base4: | 3 | 1 | 1 | 2 |
	 */
	public static void main(String[] args) {
		int base2 = 10;
		System.out.println(convertBase(base2));
	}
	
	public static int convertBase(int num){
		int decimalVal = 0;
		int count = 0;
		while(num >= 1){
			int last = num % 10;
			decimalVal = decimalVal + last * (int)Math.pow(2, count);
			num = num / 10;
			count++;
		}
		
		int base4 = 0;
		while(decimalVal != 0){
			base4 = base4 * 10 + decimalVal % 4;
			decimalVal = decimalVal / 4;
		}
		return base4;
	}

}
