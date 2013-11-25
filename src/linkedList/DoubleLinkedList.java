package linkedList;

public class DoubleLinkedList {

	/**
	 * This is a double linked list implementation
	 * the advantage is: can easily insert a new node to the end, remove a node from the end
	 */
	
	Node head; // head is an empty stuff with no data
	int size = 0;
	
	public DoubleLinkedList(){
		head = new Node(0); // head is an empty node
		head.next = head;
		head.prev = head;
	}
	
	public void insertAfter(int val){
		Node newNode = new Node(val);
		head.prev.next = newNode;
		newNode.prev = head.prev;
		newNode.next = head;
		head.prev = newNode;
		size++;
	}
	
	public void removeAfter(){
		head.prev = head.prev.prev;
		head.prev.next = head;
		if(size > 0)
			size--;
	}
	
	class Node{
		public int val;
		public Node prev;
		public Node next;
		public Node(int val){
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		list.insertAfter(1);
		list.insertAfter(2);
		list.insertAfter(3);
		list.removeAfter();
		Node p = list.head.next;
		while(p != list.head){
			System.out.println(p.val);
			p = p.next;
		}
	}
}
