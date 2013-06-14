package linkedList;

public class LinkedListPlus {

	public static void main(String[] args) {

		Node head1 = new Node(3);
		head1.next = new Node(1);
		head1.next.next = new Node(5);
		
		Node head2 = new Node(5);
		head2.next = new Node(9);
		head2.next.next = new Node(2);
		
		Node sum = linkedListPlus(head1, head2);
		Node.print(sum);
		
	}
	
	public static Node linkedListPlus(Node head1, Node head2){
		Node a = head1;
		Node b = head2;
		Node sum = null;
		Node c = null;
		int carry = 0; //add 1 if more than 1
		
		while(a != null && b != null){
			int data = a.data + b.data + carry;
			if (data >= 10){
				data = data % 10;
				carry = 1;
			}else{
				carry = 0;
			}
			
			if(sum == null){
				sum = new Node(data);
				c = sum;
			}else{
				c.next = new Node(data);
				c = c.next;
			}
			a = a.next;
			b = b.next;
		}
		
		if(a == null && b == null){
			if(carry == 1){
				c.next = new Node(1);
			}
		}else{
			Node r = null; // redundant node in a or b
			if(a == null)
				r = b;
			else
				r = a;
			while(r != null){
				int data = r.data + carry;
				if(data >= 10){
					carry = 1;
					data = data % 10;
				}else{
					carry = 0;
				}
				c.next = new Node(data);
				r = r.next;
			}
			
			if(carry == 1){
				c.next = new Node(1);
				c = c.next;
				c.next = null;
			}
		}
		
		return sum;
	}
	
}
