package designPattern;

public class StrategyPattern {

	/**
	 * Strategy pattern
	 */
	public static void main(String[] args) {
		Work a = new A();
		a.work();
		Work b = new B();
		b.work();
	}
}

interface Work{
	public void work();
}

class A implements Work{
	@Override
	public void work() {
		System.out.println("A work");
	}
}

class B implements Work{
	@Override
	public void work() {
		System.out.println("B work");
	}
}
