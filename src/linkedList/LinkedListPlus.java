package linkedList;

public class LinkedListPlus {

	public static void main(String[] args) {

		ListNode head1 = new ListNode(3);
		head1.next = new ListNode(1);
		head1.next.next = new ListNode(5);
		
		ListNode head2 = new ListNode(5);
		head2.next = new ListNode(9);
		head2.next.next = new ListNode(2);
		
		int sum = linkedlistPlus(head1, head2);
		System.out.println(sum);
		
		ListNode node = linkedlistPlus2(head1, head2);
		ListNode.print(node);
		
	}
	
	// linkedlist add linkedlist, the first element is the 1's
	public static ListNode linkedlistPlus2(ListNode head1, ListNode head2){
		int carry = 0;
		ListNode newHead = null;
		ListNode p = null;
		ListNode p1 = head1;
		ListNode p2 = head2;
		while(p1 != null || p2 != null){
			int tmpSum;
			if(p1 != null && p2 != null){
				tmpSum = p1.val + p2.val + carry;
				p1 = p1.next;
				p2 = p2.next;
			}else if(p1 != null){
				tmpSum = p1.val + carry;
				p1 = p1.next;
			}else{
				tmpSum = p2.val + carry;
				p2 = p2.next;
			}

			if(tmpSum > 9){ // check if it needs to have a carry
				tmpSum %= 10;
				carry = 1;
			}else{
				carry = 0;
			}
			
			if(newHead == null){
				newHead = new ListNode(tmpSum);
				p = newHead;
			}else{
				p.next = new ListNode(tmpSum);
				p = p.next;
			}
		}
		if(carry == 1){
			p.next = new ListNode(1);
		}
		return newHead;
	}

	// linkedlist add linkedlist, the first element is the 1's
	public static int linkedlistPlus(ListNode head1, ListNode head2){
		int carry = 0;
		int sum = 0;
		int count = 0;
		ListNode p1 = head1;
		ListNode p2 = head2;
		while(p1 != null || p2 != null){
			int tmpSum;
			if(p1 != null && p2 != null){
				tmpSum = p1.val + p2.val + carry;
				p1 = p1.next;
				p2 = p2.next;
			}else if(p1 != null){
				tmpSum = p1.val + carry;
				p1 = p1.next;
			}else{
				tmpSum = p2.val + carry;
				p2 = p2.next;
			}

			if(tmpSum > 9){ // check if it needs to have a carry
				tmpSum %= 10;
				carry = 1;
			}else{
				carry = 0;
			}
			tmpSum *= Math.pow(10, count);
			sum += tmpSum;
			count++;
		}
		if(carry == 1){
			sum += Math.pow(10, count);
		}
		return sum;
	}



}
