package java_language;

import java.util.HashSet;

public class UseHashset {

	/**
	 * how to use hashSet
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
		HashSet<Student> set = new HashSet<Student>();
		set.add(s1);
		set.add(s2);
		System.out.println(set.size());
	}

}
