package java_language;

public class UseFinally {

	/**
	 * finally is actually used in try catch block
	 */
	
	public static String test(){
		System.out.println("in test");
		return "haha";
	}
	
	public static String tryCatch(){
		try{
			int a = 3 / 0;
			System.out.println("in try");
			return "";
		}catch(Exception e){
			System.out.println("in catch");
			return test() + " return from catch";
		}finally{
			System.out.println("in finally");
		}
	}
	
	public static void main(String[] args) {
		System.out.println(tryCatch());
	}

}
