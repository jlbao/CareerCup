package linkedList;

public class RemoveDuplicatedNodes {

	public static void main(String[] args) {

		Node head = Node.getLinkedList();
		removeDuplicateNodes(head);
		Node.print(head);
		
	}
	
	public static void removeDuplicateNodes(Node head){
		Node p = head;
		Node node = head;
		while(head != null){
			while(node != p){
				if(node.val == head.val) // is duplicate
					break;
				node = node.next;
			}
			
			if(node == p){ // no duplicate
				node.val = head.val;
				p = p.next;
			}
			head = head.next;
		}
		if(p != null)
			node.next = null;
	}
	

}
