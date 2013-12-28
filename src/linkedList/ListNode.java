package linkedList;


public class ListNode {
	public int val;
	public ListNode next;
	
	public ListNode(int val){
		this.val = val;
	}

	public static void print(ListNode head){
		while(head != null){
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println("null");
		System.out.println();
	}
	
	public static ListNode getLinkedList(){
		ListNode head = new ListNode(30);
		head.next = new ListNode(21);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(21);
		head.next.next.next.next.next = new ListNode(30);
		return head;
	}
	
}
