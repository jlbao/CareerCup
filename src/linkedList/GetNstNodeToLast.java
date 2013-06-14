package linkedList;

public class GetNstNodeToLast {

	public static void main(String[] args) {
		Node head = Node.getLinkedList();
		Node.print(getNstNodeToLast(head,3));
	}
	
	public static Node getNstNodeToLast(Node head, int n){
		int i = 1;
		while(head != null){
			if(i == n)
				return head;
			head = head.next;
			i++;
		}
		return null;
	}
	
}
