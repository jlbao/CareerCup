package designPattern;


/**
 * singleton design pattern
 */


class MyClass{
	private static MyClass uniqueInstance;
	
	private MyClass(){
		
	}
	
	public static MyClass getInstance(){
		if(uniqueInstance == null)
			uniqueInstance = new MyClass();
		return uniqueInstance;
	}
}

public class Singleton{
	public static void main(String[] args) {
		MyClass a = MyClass.getInstance();
	}

}
