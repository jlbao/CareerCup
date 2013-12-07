package java_language;

import java.util.Comparator;
import java.util.PriorityQueue;

public class UsePrioityQueue {

	/**
	 * Use priority queue to find top 10
	 * Priority queue is like a min heap
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
		PriorityQueue<Student> q = new PriorityQueue<Student>(10, new Comparator<Student>(){
			@Override
			public int compare(Student s1, Student s2) {
				if(s1.age == s2.age){
					return 0;
				}else if(s1.age < s2.age){
					return -1;
				}else{
					return 1;
				}
			}
		});
		
		Student s1 = new Student("bao", 23);
		Student s2 = new Student("Jia", 24);
		Student s3 = new Student("liang", 22);
		
		q.add(s1);
		q.add(s2);
		q.add(s3);
		
		while(!q.isEmpty()){
			System.out.println(q.remove());
		}
	}

}
