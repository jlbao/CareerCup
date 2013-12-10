package designPattern;

public class AbstractFactoryPattern {

	/**
	 * Use Abstract Factory pattern
	 */
	
	public static void main(String[] args) {
		AbstractFactory factory = new ChinaFactory();
		Food f = factory.CreateFood("Rice");
		f.process();
		
		factory = new AmericaFactory();
		f = factory.CreateFood("bread");
		f.process();
	}

}

interface AbstractFactory{
	Food CreateFood(String name);
}

interface Food{
	void process();
}


// only provides Chinese food
class ChinaFactory implements AbstractFactory{

	@Override
	public Food CreateFood(String name) {
		if("rice".equalsIgnoreCase(name))
			return new Rice();
		return null;
	}
}

//only provides American food
class AmericaFactory implements AbstractFactory{

	@Override
	public Food CreateFood(String name) {
		if("bread".equalsIgnoreCase(name))
			return new Bread();
		return null;
	}
}

class Rice implements Food{

	@Override
	public void process() {
		System.out.println("I am rice");
	}
}

class Bread implements Food{

	@Override
	public void process() {
		System.out.println("I am Bread");
	}
}
