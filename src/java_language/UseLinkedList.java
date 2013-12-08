package java_language;

import java.util.LinkedList;

public class UseLinkedList {

	/**
	 * See how to use linkedlist
	 */
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		for(String val : list){
			System.out.println(val);
		}
	}

}
