package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class CreateTreeFromLinkedList {

	/**
	 * Create a binary tree from a linkedlist (ascending sorted)
	 */
	public static void main(String[] args) {
		LinkedNode head = new LinkedNode(2);
		head.next = new LinkedNode(3);
		head.next.next = new LinkedNode(5);
		head.next.next.next = new LinkedNode(6);
		head.next.next.next.next = new LinkedNode(8);
	
		TreeNode root = createTree(head,null);
		printTreeByLevel(root);
	}

	public static void printTreeByLevel(TreeNode node){
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);
		q.add(null);
		while(!q.isEmpty()){
			TreeNode n = q.poll();
			if(n == null && !q.isEmpty()){
				System.out.println();
				q.add(null);
			}else if(n == null && q.isEmpty())
				break;
			else{
				System.out.print(n.data.data + " ");
				if(n.left != null)
					q.add(n.left);
				if(n.right != null)
					q.add(n.right);
			}
		}
	}
	
	public static TreeNode createTree(LinkedNode head, LinkedNode end){
		TreeNode root = getMid(head, end);
		TreeNode left = null;
		TreeNode right = null;
		if(head != root.data)
			left = createTree(head, root.data);
		if(end != root.data.next)
			right = createTree(root.data.next, end);
		root.left = left;
		root.right = right;
		return root;
	}
	
	public static TreeNode getMid(LinkedNode head, LinkedNode end){
		LinkedNode pre = head;
		LinkedNode after = head;
		while(after != end && after.next != end){
			for(int i = 0; i < 2 && after != end; i++){
				after = after.next;
			}
			pre = pre.next;
		}
		if(pre == null)
			return null;
		return new TreeNode(pre);
	}
	public static class LinkedNode{
		LinkedNode next;
		int data;
		public LinkedNode(int data){
			this.data = data;
		}
	}

	public static class TreeNode{
		TreeNode left;
		TreeNode right;
		LinkedNode data;
		public TreeNode(LinkedNode data){
			this.data = data;
		}
	}
}

