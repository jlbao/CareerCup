package amazon;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Output the leftmost element of each level of a tree
 */

public class OutputLeftMostNode {

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(4);
		root.right = new Node(6);
		root.left.left = null;
		root.right.right = new Node(20);
		output(root);
		output2(root);
	}

	public static void output(Node node){
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		int level = 0;
		int preLevel = -1;
		while(!q.isEmpty()){
			level++;
			Node n = q.poll();
			if(n.level > preLevel){
				System.out.println(n.data);
				preLevel = n.level;
			}
			if(n.left != null){
				n.left.level = level;
				q.add(n.left);
			}
			if(n.right != null){
				n.right.level = level;
				q.add(n.right);
			}
		}
	}
	
	public static void output2(Node node){
		Queue<Node> q = new LinkedList<Node>();
		q.add(null);
		q.add(node);
		boolean flag = true;
		while(!q.isEmpty()){
			Node n = q.poll();
			if(q.isEmpty())
				return;
			if(n == null){
				q.add(null);
				flag = true;	
			}else{ // n != null
				if(n.left != null)
					q.add(n.left);
				if(n.right != null)
					q.add(n.right);	
				if(flag){
					System.out.println(n.data);
					flag = false;
				}
			}
		}
	}
}

class Node{
	public Node left;
	public Node right;
	public int data;
	public int level;
	
	public Node(int data){
		this.data = data;
	}
}
