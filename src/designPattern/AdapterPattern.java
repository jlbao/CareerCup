package designPattern;

public class AdapterPattern {

	/**
	 * implement the adapter design pattern
	 * Target is the interface we want to get
	 * Adaptee is the electricity provider for 220
	 * but we want 10 voltage
	 * so, Adapter will implement the Target interface,
	 * and convert the 220 voltage to 10 voltage, return it. 
	 */
	public static void main(String[] args) {
		Target target = new Adapter();
		int voltage = target.getVoltage();
		System.out.println(voltage);
	}
}

interface Target{
	public int getVoltage();
}

class Adapter implements Target{

	Adaptee adaptee; // use delegation
	
	public Adapter(){
		this.adaptee = new Adaptee();
	}
	
	// convert the 220 to 10 voltage
	int process(int voltage220){
		return 10;
	}
	
	@Override
	public int getVoltage() {
		int voltage220 = adaptee.get220Voltage();
		return process(voltage220); 
	}
	
}

class Adaptee{
	public int get220Voltage(){
		return 220;
	}
}