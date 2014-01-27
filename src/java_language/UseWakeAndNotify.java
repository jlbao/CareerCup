package java_language;


public class UseWakeAndNotify {

	public static class A{
		
	}
	
	public static class Info{
		boolean flag = true;
		A a = new A();

		public void sleep(){
			synchronized(a){
				if(flag){
					try{
						Thread.sleep(1000);
						System.out.println("I am sleeping now");
						a.wait();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
			System.out.println("I am asleep");
		}
		
		public void wakeup(){
			synchronized(a){
				if(flag){
					try{
						a.notifyAll();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
			System.out.println("wake up");
		}
	}
	
	public static class MyThread1 implements Runnable{
		
		Info info;
		
		public MyThread1(Info info){
			this.info = info;
		}
		
		@Override
		public void run() {
			info.sleep();
			
		}
	}
	
	public static class MyThread2 implements Runnable{
		
		Info info;
		
		public MyThread2(Info info){
			this.info = info;
		}
		
		@Override
		public void run() {
			info.wakeup();
			
		}
	}
	
	public static void main(String[] args) {
		Info info = new Info();
		MyThread1 t1 = new MyThread1(info);
		MyThread2 t2 = new MyThread2(info);
		new Thread(t1).start();
		new Thread(t2).start();
	}

}
