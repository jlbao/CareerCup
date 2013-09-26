package linkedList;

public class DeleteLoop {

	/**
	 * delete loop in the linked list
	 * first need to detect if there is a loop in the linkedlist
	 * next need to find the start point of the loop
	 * they will meet in the meeting point they met before
	 * so they will meet at the point at first 
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
		head = deleteLoop(head);
		Node node = head;
		while(node != null){
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static Node deleteLoop(Node head){
		Node pre = head;
		Node after = head;
		while(after != null){
			after = after.next;
			if(after == null)
				break;
			pre = pre.next;
			after = after.next;
			if(pre == after)
				break;
		}
		if(after == null)
			return head;
		pre = head;
		while(after.next != pre.next){
			pre = pre.next;
			after = after.next;
		}
		after.next = null;
		return head;
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
