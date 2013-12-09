package java_language;

import java.util.HashMap;

public class UseHashcodeAndEquals {

	/**
	 * try to figure the relationship between hashCode and equals
	 * If we define our own class, and if we want to put the object into hashtable
	 * we need to define the hashcode and equals on our own
	 * this way, we will not put the same object into hashtable
	 */
	
	static class Student{
		String name;
		int age;
		
		public Student(String name, int age){
			this.name = name;
			this.age = age;
		}
		
		@Override
		public int hashCode(){
			return this.name.hashCode() * this.age;
		}
		
		@Override
		public boolean equals(Object o){
			if(!(o instanceof Student)){
				return false;
			}
			if(o == this){
				return true;
			}
			Student s = (Student)o;
			return this.name == s.name && this.age == s.age;
		}
	}
	
	
	public static void main(String[] args) {
		Student s1 = new Student("baojialiang", 23);
		Student s2 = new Student("baojialiang", 23);
		Student s3 = new Student("hello", 23);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		
		HashMap<Student, Integer> map = new HashMap<Student, Integer>();
		map.put(s1, 1);
		map.put(s2, 1);
		System.out.println(map.size());
		
		System.out.println(map.containsKey((new Student("baojialiang", 23))));
	}

}

