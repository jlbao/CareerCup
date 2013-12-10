package designPattern;

import java.util.Iterator;

public class IteratorPattern {

	/**
	 * Use iterator to show that we only need to provide this interface
	 * without exposing other functions
	 */
	
	public static class LinkedList<T> {
		public T val;
		public Iterator<T> iterator(){
			return new Iterator<T>(){

				@Override
				public boolean hasNext() {
					return false;
				}

				@Override
				public T next() {
					return null;
				}

				@Override
				public void remove() {
					
				}
				
			};
		}
	}
	
	public static void main(String[] args) {
		
	}
}
