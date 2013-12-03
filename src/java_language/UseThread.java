package java_language;

public class UseThread {

	/**
	 * implement a thread class in java
	 * see how java works with thread
	 * Synchronized keyword is very important
	 * if you put synchronized keyword on a non-static function
	 * different objects can still run at the same time because they have different references
	 */
	
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();
		System.out.println("hello");
	}
}

class MyThread implements Runnable{

	public static int count = 50;
	
	@Override
	public void run() {
		while(count > 0){
			count--;
			System.out.println("count is now: " + count);
		}
	}
	
}
