package java_language;

import java.util.Observable;
import java.util.Observer;

public class UseObserver {

	/**
	 * learn how to use observer pattern in java
	 */
	public static void main(String[] args) {
		HousePrice house = new HousePrice(3000);
		house.addObserver(new HouseObserver("A"));
		house.addObserver(new HouseObserver("B"));
		house.addObserver(new HouseObserver("C"));
		house.setPrice(2000);
	}
}

class HousePrice extends Observable{
	public int price;
	public HousePrice(int price){
		this.price = price;
	}
	public void setPrice(int price){
		this.setChanged();
		this.notifyObservers(price);
		this.price = price;
	}
}

class HouseObserver implements Observer{

	public String name;
	public HouseObserver(String name){
		this.name = name;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof Integer){
			int price = (Integer)arg;
			System.out.println(name + " price is now " + price);
		}
	}
	
}
