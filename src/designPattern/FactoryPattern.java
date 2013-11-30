package designPattern;

public class FactoryPattern {

	/**
	 * Factory pattern
	 * let the factory to decide which classes to instantiate
	 * Factory is used to create the correct objects
	 */
	public static void main(String[] args) {
		Fruit f = Factory.getInstance("apple");
		f.process();
		f = Factory.getInstance("orange");
		f.process();
	}
}

interface Fruit{
	public void process();
}

class Factory{
	public static Fruit getInstance(String str){
		String requestStr = str.toLowerCase();
		if(requestStr.equals("apple")){
			return new Apple();
		}else if(requestStr.equals("orange")){
			return new Orange();
		}
		return null;
	}
}

class Apple implements Fruit{

	@Override
	public void process() {
		System.out.println("Apple processed");
	}
}

class Orange implements Fruit{

	@Override
	public void process() {
		System.out.println("Orange processed");
	}
}

