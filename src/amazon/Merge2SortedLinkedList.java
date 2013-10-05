package amazon;

public class Merge2SortedLinkedList {

	/**
	 * merge 2 sorted linkList
	 */
	public static void main(String[] args) {
		Node head1 = new Node(3);
		head1.next = new Node(6);
		head1.next.next = new Node(16);
		head1.next.next.next = null;
		
		Node head2 = new Node(2);
		head2.next = new Node(5);
		head2.next.next = new Node(10);
		head2.next.next.next = new Node(18);
		head2.next.next.next.next = new Node(66);
		head2.next.next.next.next.next = null;
		
		Node head = merge(head1, head2);
		Node p = head;
		while(p != null){
			System.out.print(p.data + " ");
			p = p.next;
		}
	}
	
	public static Node merge(Node head1, Node head2){
		Node head = null;
		Node p = head;
		while(head1 != null || head2 != null){
			Node insertNode = null;
			if(head1 != null && head2 != null){
				if(head1.data < head2.data){
					insertNode = head1;
					head1 = head1.next;
				}else{
					insertNode = head2;
					head2 = head2.next;
				}
			}else if(head1 != null){
				insertNode = head1;
				head1 = head1.next;
			}else{
				insertNode = head2;
				head2 = head2.next;
			}
			insertNode.next = null;
			if(head == null){
				head = insertNode;
				p = head;
			}else{
				p.next = insertNode;
				p = p.next;
			}
		}
		return head;
	}
	
	static class Node{
		Node next = null;
		int data;
		public Node(int data){
			this.data = data;
		}
	}

}
