package java_language;

import java.util.HashMap;

public class UseHashMap {

	/**
	 * if I need to put user-defined key into a map
	 * how to find the value based on a anonymous key?
	 * We need to override the hashCode function and Equals function
	 * Because we first need the same hashCode to find the user
	 * then we need use equals to decide if they are the same
	 * this is used to collision check 
	 * Please look at the Person class implementation
	 */
	
	public static void main(String[] args) {
		HashMap<Person, String> map = new HashMap<Person,String>();
		map.put(new Person("bao",23),"bao");
		String name = map.get(new Person("bao",23));
		System.out.println("Person name:" + name);
	}

}

class Person{
	String name;
	int age;
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(!(obj instanceof Person))
			return false;
		Person per = (Person)obj;
		if(this.name == per.name && this.age == per.age)
			return true;
		return false;
	}
	
	@Override
	public int hashCode(){
		return this.name.hashCode() * this.age;
	}
}