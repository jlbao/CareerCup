package test;

import java.util.ArrayList;
import java.util.Arrays;

class A<T>{
	private void test(){
		System.out.println("A");
	}
	public void output(){
		test();
	}
}

public class Test {
	
	public static void main(String[] args) {

		/*
		ArrayList<Person> list1 = new ArrayList<Person>();
		ArrayList<Person> list2 = new ArrayList<Person>();
		
		list1.add(new Person("baojialiang", 23));
		//list2.add(new Person("baojialiang", 23));
		
		list2.addAll(list1);
		list1.remove(0);
		
		
		System.out.println(list2.size());
	*/
		partition("ab");

		
		//combinationSum2(new int[]{1,1}, 2);
	}
	
    public static ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        ArrayList<String> one = new ArrayList<String>();
        getCombinations(s, 0, list, one);
        return list;
    }
    
    public static void getCombinations(String s, int index, ArrayList<ArrayList<String>> list, ArrayList<String> one){
        if(index >= s.length()){
            ArrayList<String> newOne = new ArrayList<String>();
            newOne.addAll(one);
            list.add(newOne);
            return;
        }
        String str = "";
        for(int i = index; i < s.length(); i++){
            str += s.charAt(i);
            int idx = one.size();
            if(isPalindrome(str)){
                one.add(str);
                getCombinations(s, i + 1, list, one);
            }
            one.remove(idx);
        }
    }
    
    public static boolean isPalindrome(String str){
        for(int i = 0; i < str.length() / 2; i++){
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}




class Person{
	int age;
	String name;
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Person)){
			return false;
		}
		Person p = (Person)obj;
		if(this.name == p.name && this.age == p.age){
			return true;
		}
		return false;
	}
	
}
