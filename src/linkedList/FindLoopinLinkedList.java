package linkedList;

public class FindLoopinLinkedList {

	/**
	 * find if there is a loop in the linked list
	 */
	
	static class Node{
		int data;
		Node next;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		Node head = getNode();
		boolean isLoopExisted = isLoopExisted(head);
		System.out.println(isLoopExisted);
	}

	public static boolean isLoopExisted(Node head){
		Node pre = head;
		Node after = head;
		while(after != null){
			after = after.next;
			if(after == null)
				return false;
			pre = pre.next;
			after = after.next;
			if(pre == after)
				return true;
		}
		return false;
	}
	
	
	public static Node getNode(){
		Node head = new Node(3);
		head.next = new Node(5);
		head.next.next = new Node(8);
		head.next.next.next = new Node(15);
		head.next.next.next.next = new Node(18);
		head.next.next.next.next.next = new Node(20);
		head.next.next.next.next.next.next = new Node(28);
		head.next.next.next.next.next.next.next = head.next;
		return head;
	}
	
	
}
