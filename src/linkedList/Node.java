package linkedList;


public class Node {
	public int val;
	public Node next;
	
	public Node(int val){
		this.val = val;
	}

	public static void print(Node head){
		while(head != null){
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println("null");
		System.out.println();
	}
	
	public static Node getLinkedList(){
		Node head = new Node(10);
		head.next = new Node(3);
		head.next.next = new Node(5);
		head.next.next.next = new Node(2);
		head.next.next.next.next = null;
		return head;
	}
	
}
