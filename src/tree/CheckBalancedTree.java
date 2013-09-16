package tree;

public class CheckBalancedTree {

	/**
	 * Implement a function to check if a tree is balanced.
	 * For the purposes of this question, a balanced tree is defined
	 * to be a tree such that no two leaf nodes differ in distance
	 * from the root by more than one
	 */

	public static class Node{
		Node left;
		Node right;
		int data;
		public Node(int data){
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(8);
		root.right = new Node(8);
		root.left.left = new Node(8);
		root.right.left = new Node(8);
		root.right.left.right = new Node(8);
		boolean isBalancedTree = isBalancedTree(root);
		System.out.println(isBalancedTree);
	}
	
	public static boolean isBalancedTree(Node node){
		int maxLen = getTreeMaxLen(node);
		int minLen = getTreeMinLen(node);
		return maxLen == minLen || maxLen == minLen + 1;
	}
	
	public static int getTreeMaxLen(Node node){
		if(node == null)
			return 0;
		int leftLen = getTreeMaxLen(node.left);
		int rightLen = getTreeMaxLen(node.right);
		return leftLen > rightLen ? leftLen + 1 : rightLen + 1;
	}
	
	public static int getTreeMinLen(Node node){
		if(node == null)
			return 0;
		int leftLen = getTreeMinLen(node.left);
		int rightLen = getTreeMinLen(node.right);
		return leftLen < rightLen ? leftLen + 1 : rightLen + 1;
	}
	
	

}
