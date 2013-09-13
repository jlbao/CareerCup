package amazon;

/*
 * Given a link list. Determine if it is a palindrome
 */

public class JudgePalindrome {

	static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data = data;
		}
	}
	
	public static Node n; // used to compare with the data from recursion back
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		head.next.next.next = null;
		n = head; // used for ascendent comparing when recursion
		System.out.println(isPalindrome(head));
	}
	
	public static boolean isPalindrome(Node head){
		if(head == null)
			return false;
		return process(head);
	}
	
	public static boolean process(Node node){
		if(node == null)
			return true;
		if(process(node.next) == false)
			return false;
		if(n.data == node.data){
			n = n.next;
			return true;
		}
		return false;
	}
	

}
