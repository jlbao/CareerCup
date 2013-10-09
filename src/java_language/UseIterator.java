package java_language;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class UseIterator {

	/**
	 * This file tells us how to use iterator in java
	 * how to use collections
	 */
	public static void main(String[] args) {
		useIternatorInHashMap();
	}
	
	public static void useIternatorInHashMap(){
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("1", "hello");
		map.put("2", "world");
		Set<Entry<String,String>> set = map.entrySet();
		//map stores the Entry<K,V> pairs inside
		Iterator<Entry<String,String>> iter = set.iterator();
		while(iter.hasNext()){
			Entry<String,String> val = iter.next();
			System.out.print(val.getKey() + " " + val.getValue());
			System.out.println();
		}
		/*
		for(Entry<String,String> a : map.entrySet()){
			System.out.print(a.getKey() + " " + a.getValue());
			System.out.println();
		}
		*/
		
	}
	public static void useIteratorInArrayList(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world!!!");
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			System.out.print(iter.next() + " ");
		}
	}

}
