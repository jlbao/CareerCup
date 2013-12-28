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

// find kth element to the end
public static ListNode findKthElementToEnd(ListNode head, int k){
	ListNode p = head;
	int count = 0;
	while(count < k && p != null){
		count++;
		p = p.next;
	}
	if(count < k){
		return null;
	}
	ListNode prev = head;
	while(p != null){
		prev = prev.next;
		p = p.next;
	}
	return prev;
}

// implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node
public static boolean deleteMidNode(ListNode mid){
	if(mid == null || mid.next == null){
		return false;
	}
	mid.val = mid.next.val;
	mid.next = mid.next.next;
	return true;
}

// write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x
public static ListNode partitionList(ListNode head, int x){
	ListNode prev = null;
	ListNode next = head;
	while(next != null){
		if(next.val < x && prev != null){ // need to come to front
			prev.next = next.next;	// delete this node
			next.next = head;
			head = next;			// set up a new head
		}else{
			prev = next;
		}
		next = prev.next;
	}
	return head;
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
		tmpSum *= Math.power(10, count);
		sum += tmpSum;
		count++;
	}
	if(carry == 1){
		sum += Math.power(10, count);
	}
	return sum;
}

// linkedlist add linkedlist, the first element is the 1's
public static ListNode linkedlistPlus(ListNode head1, ListNode head2){
	int carry = 0;
	int count = 0;
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
		count++;
	}
	if(carry == 1){
		p.next = new ListNode(1);
	}
	return newHead;
}


public static boolean isListPalindrome(ListNode head){
	Stack<Integer> stack = new Stack<Integer>();
	ListNode p = head;
	while(p != null){
		stack.push(p.val);
		p = p.next
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

public static boolean isListPalindrome2(ListNode head){
	if(head == null){
		return true;
	}
	Stack<Integer> stack = new Stack<Integer>();
	ListNode prev = head;
	ListNode after = head;

	while(after != null && after.next != null){
		stack.push(prev.val);
		prev = prev.next;
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

















