package linkedList;

import java.util.HashSet;

public class RemoveDuplicatedNodes {

	public static void main(String[] args) {

		ListNode head = ListNode.getLinkedList();
		//head = removeDuplicates(head);
		head = removeDuplicates_NoSpace2(head);
		ListNode.print(head);
		
	}
	
	// delete duplicate elements in the linkedlist (with no space)
	public static ListNode removeDuplicates_NoSpace(ListNode head){
		ListNode prev = null;
		ListNode p = head;
		while(p != null){
			ListNode node = head;
			while(node != p && p.val != node.val){
				node = node.next;
			}
			if(node != p){ // there is duplicates
				prev.next = p.next;
			}else{
				prev = p;
			}
			p = p.next;
		}
		return head;
	}

	public static ListNode removeDuplicates_NoSpace2(ListNode head){
		ListNode cur = head;
		while(cur != null){
			ListNode n = cur;
			while(n.next != null){
				if(n.next.val == cur.val){ // is duplicate, delete this node
					n.next = n.next.next;
				}else{
					n = n.next;
				}
			}
			cur = cur.next;
		}
		return head;
	}
	
	// delete duplicate elements in the linkedlist (with space)
	public static ListNode removeDuplicates(ListNode root){
		HashSet<Integer> set = new HashSet<Integer>();
		ListNode prev = null;
		ListNode next = root;
		while(next != null){
			if(set.contains(next.val)){ // delete this node
				prev.next = next.next;
			}else{
				set.add(next.val);
				prev = next;
			}
			next = next.next;
		}
		return root;
	}

	

}
