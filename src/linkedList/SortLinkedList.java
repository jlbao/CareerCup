package linkedList;

public class SortLinkedList {

	/**
	 * Sort a linkedlist
	 * very tricky, better use the recursion to insert node, which will be easy
	 */
	public static void main(String[] args) {
		Node head = Node.getLinkedList();
		Node p = sortLinkedList(head);
		while(p != null){
			System.out.print(p.val + " ");
			p = p.next;
		}
	}

	public static Node sortLinkedList(Node head){
		Node p = head;
		Node p_prev = null;
		while(p != null){
			Node prev = null;
			Node q = head;
			
			Node p_next = p.next;
			while(q != p){
				if(q == head && p.val < head.val){ // need to insert to the head
					if(head.next == p){
						head.next = p_next;
					}else{ // need to put null to last one
						Node s = head;
                        p_prev.next = p_next;
					}
					p.next = head;
					head = p;
					break;
				}else if(p.val < q.val){ // find the place to insert
					p.next = q;
					p_prev.next = p_next;
					prev.next = p;
					break;
				}
				if(prev == null){ // it is now at head
					prev = head;
				}else{
					prev = prev.next;
				}
				q = q.next;
			}
			if(p_prev == null){
			    p_prev = head;
			}else if(q == p){
			    p_prev = p_prev.next;
			}
			p = p_next;
		}
		return head;
	}
	
}
