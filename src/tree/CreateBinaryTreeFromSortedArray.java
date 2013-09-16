package tree;

import java.util.LinkedList;
import java.util.Queue;

public class CreateBinaryTreeFromSortedArray {

	/**
	 * Create a binary tree from a sorted array
	 */
	
	static class Node{
		Node left;
		Node right;
		int data;
		public Node(int data){
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {1,2,3,4,5,6,7,8,9};
		Node root = createBinaryTree(data, 0, data.length - 1);
		output_midOrder(root);
	}
	
	public static void output_midOrder(Node root){
		if(root == null)
			return;
		output_midOrder(root.left);	
		System.out.print(root.data + " ");
		output_midOrder(root.right);
	}
	
	public static void outputTreeByLevel(Node root){
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node node = q.poll();
			System.out.print(node.data + " ");
			if(node.left != null)
				q.add(node.left);
			if(node.right != null)
				q.add(node.right);
		}
	}
	
	
	public static Node createBinaryTree(int[] data, int i, int j){
		if(i > j)
			return null;
		if(i == j){
			Node node = new Node(data[i]);
			return node;
		}
		int mid = (i + j) / 2;
		Node root = new Node(data[mid]);
		root.left = createBinaryTree(data, i, mid - 1);
		root.right = createBinaryTree(data, mid + 1, j);
		return root;
	}

}
