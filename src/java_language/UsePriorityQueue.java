package java_language;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class UsePriorityQueue {

	public static void main(String[] args) {
		int[] A = new int[100];
		for(int i = 0; i < A.length; i++){
			A[i] = A.length - i;
		}
		ArrayList<Integer> list = getTopNumbers(A);
		for(int val : list){
			System.out.println(val);
		}
	}
	
	// Describe an algorithm to find the smallest one million numbers
	// in one billion numbers. Assume the computer can hold all one billion numbers
	public static ArrayList<Integer> getTopNumbers(int[] A){
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
			@Override
			public int compare(Integer a, Integer b) {
				if(a < b){
					return 1;
				}else if(a == b){
					return 0;
				}else{
					return -1;
				}
			}
		});
		for(int i = 0; i < A.length; i++){
			if(queue.size() < 10){
				queue.add(A[i]);
			}else if(A[i] < queue.peek()){
				queue.remove();
				queue.add(A[i]);
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(queue);
		return list;
	}


}
