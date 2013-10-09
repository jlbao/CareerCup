package java_language;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UseComparable {

	/**
	 * implement comparable interface to 
	 */
	public static void main(String[] args) {
		collectionSort();
		//arraySort();
	}
	
	public static void collectionSort(){
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("jialiang bao", 25));
		students.add(new Student("hello world !!", 20));
		students.add(new Student("gddsd", 29));
		Collections.sort(students);
		for(Student s : students){
			System.out.println(s.name + "\t" + s.age);
		}
	}
	
	public static void arraySort(){
		Student[] students = new Student[3];
		students[0] = new Student("jialiang bao", 25);
		students[1] = new Student("hello world !!", 20);
		students[2] = new Student("gddsd", 28);
		Arrays.sort(students);
		for(Student s : students){
			System.out.println(s.name + "\t" + s.age);
		}
	}
}

class Student implements Comparable<Student>{
	public String name;
	public int age;
	
	public Student(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int compareTo(Student stu) {
		if(this.age < stu.age)
			return -1;
		else if(this.age > stu.age)
			return 1;
		else
			return 0;
	}
}