package hashtable;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MyHashtable<K, V> {

	/**
	 * Implement my own hashtable
	 * A simple version that implement the following functions
	 * put, get, remove, size, hash, rehash
	 * 
	 * It helps me to better understand how hashtable work
	 * 
	 * We need to define a good hashCode. We need to divide by a prime number.
	 * The reason is that if the hashCode can always be divided by 4,
	 * for the hashCodes bigger than the bucketSize, 
	 * it will still be inserted to the positions that can be divided by 4
	 * That will cause the vacancy of other 3 positions
	 * So dividing by a prime number can solve this problem
	 */
	
	int bucketSize = 50;
	final double loadFactorThreshold = 0.75;
	int size;
	Entry<K, V>[] table;
	
	static class Entry<K, V>{
		public K key;
		public V value;
		public Entry<K, V> next = null;
		
		public Entry(K key, V value){
			this.key = key;
			this.value = value;
		}
	}
	
	public MyHashtable(){
		size = 0;
		table = new Entry[bucketSize];
	}
	
	public V put(K key, V value){
		// decide if we need to rehash
		if((size + 1) / (double)bucketSize > loadFactorThreshold){
			rehash();
		}
		int bucketPosition = hash(key);
		Entry<K, V> entry = table[bucketPosition];
		if(entry == null){
			table[bucketPosition] = new Entry<K, V>(key, value);
		}else{
			while(entry.next != null){
				if(entry.key.equals(key)){ // no need to increase the size
					entry.value = value;
					return value;
				}
				entry = entry.next;
			}
			entry.next = new Entry<K, V>(key, value);
			return value;
		}
		size++;
		return value;
	}
	
	public V get(K key){
		int bucketPosition = hash(key);
		Entry<K, V> entry = table[bucketPosition];
		while(entry != null){
			if(entry.key.equals(key)){
				return entry.value;
			}
			entry = entry.next;
		}
		return null;
	}
	
	public V remove(K key){
		int bucketPosition = hash(key);
		Entry<K, V> head = table[bucketPosition];
		if(head == null)
			return null;
		if(head.key.equals(key)){
			table[bucketPosition] = head.next;
			return head.value;
		}
		Entry<K, V> p = head.next;
		Entry<K, V> prev = head;
		while(p != null){
			if(p.key.equals(key)){
				prev.next = p.next;
				return p.value;
			}
			prev = prev.next;
			p = p.next;
		}
		return null;
	}
	
	public boolean containsKey(K key){
		int bucketPosition = hash(key);
		Entry<K, V> entry = table[bucketPosition];
		while(entry != null){
			if(entry.key.equals(key))
				return true;
		}
		return false;
	}
	
	// return the set that stores all the key-value pairs
	public Set<Entry<K, V>> entrySet(){
		Set<Entry<K, V>> set = new HashSet<Entry<K, V>>();
		for(int i = 0; i < table.length; i++){
			Entry<K, V> entry = table[i];
			while(entry != null){
				set.add(entry);
				entry = entry.next;
			}
		}
		return set;
	}
	
	public int size(){
		return this.size;
	}
	
	// try to get the slot that the hashCode maps to
	int hash(K key){
		return Math.abs(key.hashCode()) % this.bucketSize;
	}
	
	// if the load factor is more then a threshold
	boolean rehash(){
		Entry<K, V>[] oldTable = table;
		bucketSize *= 2;
		table = new Entry[bucketSize];
		size = 0;
		for(int i = 0; i < oldTable.length; i++){
			Entry<K, V> entry = oldTable[i];
			while(entry != null){
				this.put(entry.key, entry.value);
				entry = entry.next;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		MyHashtable<String, Integer> table = new MyHashtable<String, Integer>();
		Random rand = new Random();
		for(int i = 0; i < 100; i++){
			int size = rand.nextInt(12) + 3;
			String str = "";
			for(int j = 0; j < size; j++){
				str += (char)(65 + rand.nextInt(25));
			}
			table.put(str, i);
		}
		
		int count = 0;
		Set<Entry<String, Integer>> set = table.entrySet();
		for(Entry<String, Integer> entry : set){
			System.out.println(entry.key + " " + entry.value);
			count++;
		}
		System.out.println("--------------------");
		System.out.println("count: " + count);
	}
}
