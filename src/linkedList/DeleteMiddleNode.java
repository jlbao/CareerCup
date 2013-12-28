package linkedList;

public class DeleteMiddleNode {


	public static void main(String[] args) {
		ListNode head = ListNode.getLinkedList();
		ListNode mid = getMiddleNode(head);
		//System.out.println(mid.val);
		deleteMidNode(mid);
		ListNode.print(head);
	}
	
	public static ListNode getMiddleNode(ListNode head){
		ListNode pre = head;
		ListNode after = head;
		while(after != null){
			after = after.next;
			if(after != null)
				after = after.next;
			else
				break;
			pre = pre.next;
		}
		return pre;
	}
	
	// implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node
	// implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node
	public static boolean deleteMidNode(ListNode mid){
		if(mid == null || mid.next == null){
			return false;
		}
		mid.val = mid.next.val;
		mid.next = mid.next.next;
		return true;
	}


}
