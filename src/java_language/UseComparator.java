package java_language;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class UseComparator {

	/**
	 * how to use comparator, show the difference between Comparable and Comparator
	 * Comparator do not need to be implemented in the class
	 * but can be created as a new Comparator class
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
		
		@Override
		public String toString(){
			return this.name + " " + this.age;
		}
	}

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("Jack", 25));
		list.add(new Student("baojialiang", 23));
		Collections.sort(list, new Comparator<Student>(){ 
			// comparator defines the size of 2 objects 
			@Override
			public int compare(Student s1, Student s2) {
				if(s1.age < s2.age)
					return -1;
				else if(s1.age > s2.age)
					return 1;
				else
					return 0;
			}
		});
		for(Student s: list){
			System.out.println(s);
		}
	}
	
}