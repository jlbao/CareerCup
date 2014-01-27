package java_language;

import java.util.concurrent.Semaphore;

public class UseSemaphore {

	/*
	 * Use Semaphore to implement Consumer and Producer problem.
	 * 2 semaphores and one mutex
	 * semaphore is used to control how many threads do its job
	 * mutex is used to ensure only one thread can access one shared resource
	 */
	public static class Resource{
		public static Semaphore produce = new Semaphore(20);
		public static Semaphore consume = new Semaphore(20);
		public static int count = 0;
		
		public Resource(){
			try{
				consume.acquire(20);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public void produce(){
			try{
				produce.acquire();
					Thread.sleep(500);
					synchronized(this){
						System.out.println("produce: " + count);
						count++;
					}
				consume.release();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public void consume(){
			try{
				consume.acquire();
					//Thread.sleep(300);
					synchronized(this){
						System.out.println("consume: " + count);
						count--;
					}
				produce.release();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static class ProducerThread implements Runnable{
		public Resource resource;
		public ProducerThread(Resource resource){
			this.resource = resource;
		}
		@Override
		public void run() {
			resource.produce();
		}
	}
	
	public static class ConsumerThread implements Runnable{
		public Resource resource;
		public ConsumerThread(Resource resource){
			this.resource = resource;
		}
		@Override
		public void run() {
			resource.consume();
		}
	}
	
	public static void main(String[] args) {
		Resource resourse = new Resource();
		ProducerThread producer = new ProducerThread(resourse);
		ConsumerThread consumer = new ConsumerThread(resourse);
		for(int i = 0; i < 30; i++){
			new Thread(producer).start();
			new Thread(consumer).start();
		}
	}

}
