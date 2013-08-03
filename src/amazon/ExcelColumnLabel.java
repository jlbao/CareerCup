package amazon;

/*
 * Excel columns are labelled alphabetically in length-lexicographic order, i.e., A, B, C, ..., Z, AA, AB, .... 
 * Given the 1-based numeric index of a column, return the corresponding label. 
 * Example 1: 
 * 1 
 * Output 1: 
 * A 
 * 
 * Example 2: 
 * 54 
 * Output 2: 
 * BB
 */

public class ExcelColumnLabel {

	public static void main(String[] args) {
		System.out.println(output(55));
		System.out.println(output2(55));
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
