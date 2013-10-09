package java_language;

public class UseInstanceOf {

	/**
	 * How to use Instanceof keyword
	 */
	public static void main(String[] args) {
		B b = new B();
		System.out.println(b instanceof A);
		
		A a = new A();
		System.out.println(a instanceof B);
		
	}

}

class A{
}

class B extends A{
}
