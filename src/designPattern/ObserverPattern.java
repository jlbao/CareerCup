package designPattern;

import java.util.Observable;
import java.util.Observer;

public class ObserverPattern {

	/**
	 * implement the observer pattern
	 * However, sometimes this cannot apply to GUI since it only applies one thread.
	 */
	
	public static void main(String[] args) {
		HouseObservable house = new HouseObservable(100);
		PriceObserver o1 = new PriceObserver("A");
		PriceObserver o2 = new PriceObserver("B");
		PriceObserver o3 = new PriceObserver("C");
		house.addObserver(o1);
		house.addObserver(o2);
		house.addObserver(o3);
		
		house.setPrice(50);
	}
}

// the observable class
class HouseObservable extends Observable{
	public int price;
	public HouseObservable(int price){
		this.price = price;
	}
	
	public void setPrice(int price){
		this.setChanged();
		this.notifyObservers(price);
		this.price = price;
		//this.clearChanged(); // this has actually automatically been cleared 
	}
}

class PriceObserver implements Observer{

	public String name;
	public PriceObserver(String name){
		this.name = name;
	}
	
	@Override
	public void update(Observable o, Object val) {
		if(o instanceof HouseObservable){
			HouseObservable observable = (HouseObservable)o;
			System.out.println(this.name + " sees price from " + observable.price + " to " + val);
		}
	}
}

