package linkedList;


public class Node {
	public int data;
	public Node next;
	
	public Node(int data){
		this.data = data;
	}

	public static void print(Node head){
		while(head != null){
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.println("null");
		System.out.println();
	}
	
	public static Node getLinkedList(){
		Node head = new Node(1);
		head.next = new Node(3);
		head.next.next = new Node(5);
		head.next.next.next = null;
		return head;
	}
	
}
