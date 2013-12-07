package acre;

import java.util.Stack;

public class SimpleCalculator {

	/**
	 * the input is a reverse polish notation
	 */
	
	public static void main(String[] args) {
		String s = "512+4*+3-";
		double res = calculate(s);
		System.out.println(res);
	}
	
	public static double calculate(String str){
		Stack<Double> stack = new Stack<Double>();
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			String s = "" + c;
			if(isOperator(c)){ // this is an operator
				double b = stack.pop();
				double a = stack.pop();
				double result = 0.0;
				if("+".equals(s)){
					result = a + b;
				}else if("-".equals(s)){
					result = a - b;
				}else if("*".equals(s)){
					result = a * b;
				}else if("/".equals(s)){
					result = a / b;
				}
				stack.push(result);
			}else{ // this is a number
				stack.push(Double.parseDouble(s));
			}
		}
		return stack.pop();
	}

	public static boolean isOperator(char c){
		if(c == '+' || c == '-' || c == '*' || c == '/')
			return true;
		return false;
	}
}
