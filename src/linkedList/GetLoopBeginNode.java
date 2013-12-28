package linkedList;

public class GetLoopBeginNode {


	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = head.next.next;
		
		ListNode node = getLoopBeginNode(head);
		System.out.println(node.val);

	}

	public static ListNode getLoopBeginNode(ListNode head){
		if(head == null){
			return null;
		}
		ListNode p = head.next;
		while(p != null){
			ListNode n = head;
			while(n != p){
				if(p.next == n){
					return n;
				}
				n = n.next;
			}
			if(p == p.next) // in case a node loop itself
				return p;
			
			p = p.next;
		}
		return null;	
	}
}
