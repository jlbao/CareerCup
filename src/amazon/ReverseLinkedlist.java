package amazon;

public class ReverseLinkedlist {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(5);
		head.next = new Node(8);
		head.next.next = new Node(19);
		head.next.next.next = new Node(29);
		
		Node h = reverse(head);
		while(h != null){
			System.out.print(h.data + " ");
			h = h.next;
		}
		System.out.println();
	}

	public static Node reverseLinkedlist(Node head){
		Node pre = null;
		Node cur = head;
		Node next = cur.next;
		while(cur != null){
			cur.next = pre;
			pre = cur;
			cur = next;
			if(cur == null)
				break;
			next = next.next;
		}
		return pre;
	}
	
	public static Node reverse(Node head) {
		Node prev = null;
		while(head != null){
			Node next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	
	public static class Node{
		Node next;
		int data;
		public Node(int data){
			this.data = data;
		}
	}
	
}
