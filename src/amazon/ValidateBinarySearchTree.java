package amazon;

public class ValidateBinarySearchTree {

	/**
	 * Given a binary tree, 
	 * write a function that returns true if 
	 * and only if it is a binary search tree.  
	 * Your solution will be evaluated on correctness, 
	 * runtime complexity (big-O), 
	 * and adherence to coding best practices
	 */
	
	public static void main(String[] args) {
		Tree root = new Tree(10);
		root.left = new Tree(6);
		root.right = new Tree(18);
		root.left.left = new Tree(3);
		root.left.right = new Tree(8);
		boolean isBinaryTree = isBinaryTree(root);
		System.out.println(isBinaryTree);
	}

	public static boolean isBinaryTree(Tree node){
		if(node == null)
			return true;
		boolean leftResult = isBinaryTree(node.left);
		boolean rightResult = isBinaryTree(node.right);
		if(leftResult && rightResult){
			if(node.left != null && node.right != null){
				if(node.left.data <= node.data && node.data <= node.right.data)
					return true;
			}else if(node.left != null && node.left.data <= node.data)
				return true;
			else if(node.right != null && node.data <= node.right.data)
				return true;
			else
				return true;
		}
		return false;
	}
	
	static class Tree{
		Tree left;
		Tree right;
		int data;
		public Tree(int data){
			this.data = data;
		}
	}
}
