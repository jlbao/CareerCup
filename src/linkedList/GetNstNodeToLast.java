package linkedList;

public class GetNstNodeToLast {
/*
 * find the Nst node to the last element
 */
	public static void main(String[] args) {
		ListNode head = ListNode.getLinkedList();
		ListNode node = findKthElementToEnd(head, 2);
		System.out.println(node.val);
	}
	
	public static ListNode findKthElementToEnd(ListNode head, int k){
		ListNode p = head;
		int count = 0;
		while(count < k && p != null){
			count++;
			p = p.next;
		}
		if(count < k){
			return null;
		}
		ListNode prev = head;
		while(p != null){
			prev = prev.next;
			p = p.next;
		}
		return prev;
	}
}
