package linkedList;

public class PartitionList {
	
/*
 * write code to partition a linked list around a value x, 
 * such that all nodes less than x 
 * come before all nodes 
 * greater than or equal to x
 */
	public static void main(String[] args) {
		ListNode head = ListNode.getLinkedList();
		head = partitionList(head, 31);
		ListNode.print(head);
	}
	
	public static ListNode partitionList(ListNode head, int x){
		ListNode prev = null;
		ListNode next = head;
		while(next != null){
			if(next.val < x && prev != null){ // need to come to front
				prev.next = next.next;	// delete this node
				next.next = head;
				head = next;			// set up a new head
			}else{
				prev = next;
			}
			next = prev.next;
		}
		return head;
	}

}
