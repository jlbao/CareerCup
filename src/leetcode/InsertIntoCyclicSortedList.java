package leetcode;

public class InsertIntoCyclicSortedList {

	/**
	 * Given a node from a cyclic linked list which has been sorted, 
	 * write a function to insert a value into the list 
	 * such that it remains a cyclic sorted list. 
	 * The given node can be any single node in the list.
	 */
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(3);
		head.next.next = new Node(5);
		head.next.next.next = new Node(8);
		head.next.next.next.next = new Node(8);
		head.next.next.next.next.next = head;
		
		Node insertNode = new Node(6);
		insert(head, insertNode);
		
		// we need to go through the whole list from small to large
		while(head.data > head.next.data){
			head = head.next;
		}
		
		
		while(head.data <= head.next.data){
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.print(head.data + " "); // need to output the last element
	}
	
	public static void insert(Node head, Node insertNode){
		while(true){
			if(head.data < head.next.data){
				// can be inserted in the middle
				if(insertNode.data >= head.data && insertNode.data <= head.next.data){ 
					insertNode.next = head.next;
					head.next = insertNode;
					break;
				}
			}else if(insertNode.data >= head.data){
				insertNode.next = head.next;
				head.next = insertNode;
				break;
			}
			head = head.next;
		}
	}
	
	public static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data = data;
		}
	}
	
}
