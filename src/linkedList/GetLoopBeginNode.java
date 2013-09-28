package linkedList;

public class GetLoopBeginNode {


	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = head.next.next;
		
		Node node = getLoopBeginNode(head);
		System.out.println(node.data);

	}

	public static Node getLoopBeginNode(Node head){
		if(head == null){
			return null;
		}
		Node p = head.next;
		while(p != null){
			Node n = head;
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
