package linkedList;

import java.util.Stack;

public class IsLinkedListPalindrome {
	static ListNode head = ListNode.getLinkedList();
	static ListNode n = head;
	
	public static void main(String[] args) {
		
		boolean res = isListPalindrome3(head);
		System.out.println(res);
	}

	// this is the best !!!
	public static boolean isListPalindrome3(ListNode head){
		if(head == null){
			return true;
		}
		Stack<Integer> stack = new Stack<Integer>();
		ListNode prev = head;
		ListNode after = head;
	
		while(after != null && after.next != null){
			stack.push(prev.val);
			prev = prev.next;
			after = after.next;
		}
		if(after != null){ // node count is even
			prev = prev.next;
		}
	
		while(prev != null){
			if(stack.isEmpty()){
				return false;
			}
			int val = stack.pop();
			if(val != prev.val){
				return false;
			}
			prev = prev.next;
		}
		return true;
	}	

	// use stack
	public static boolean isListPalindrome(ListNode head){
		Stack<Integer> stack = new Stack<Integer>();
		ListNode p = head;
		while(p != null){
			stack.push(p.val);
			p = p.next;
		}
		p = head;
		while(p != null){
			if(stack.isEmpty()){
				return false;
			}
			int val = stack.pop();
			if(val != p.val){
				return false;
			}
			p = p.next;
		}
		return true;
	}

	// use recursion
	public static boolean isListPalindrome2(ListNode head){
		if(head == null){
			return true;
		}
		if(isListPalindrome2(head.next)){
			if(n.val == head.val){
				n = n.next;
				return true;
			}
		}
		return false;
	}
	
}
