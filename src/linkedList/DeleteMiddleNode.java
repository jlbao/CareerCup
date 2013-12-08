package linkedList;

public class DeleteMiddleNode {


	public static void main(String[] args) {
		Node head = Node.getLinkedList();
		Node mid = getMiddleNode(head);
		//System.out.println(mid.val);
		deleteMiddleNode(mid);
		Node.print(head);
	}
	
	public static Node getMiddleNode(Node head){
		Node pre = head;
		Node after = head;
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
	
	
	public static void deleteMiddleNode(Node mid){
		
		if(mid == null || mid.next == null)
			return;
		
		Node n = mid;
		Node pre = mid;
		
		while(n != null){
			if(n.next != null){ // next is not null
				n.val = n.next.val; //copy from next node
			}else{ //the last node now
				pre.next = null;
			}
			//keep pre is the previous node of n
			if(pre.next == n){
				pre = pre.next;
			}
			n = n.next;
		}
	}
	

}
