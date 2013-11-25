package tree;

import java.util.Stack;

public class Traverse_Stack {

	/**
	 * Use stack to implement the preOrder
	 */
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val){
			this.val = val;
		}
	}
	
	public void preOrder_Stack(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root == null)
			return;
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			System.out.print(node.val + " ");
			if(node.right != null){
				stack.push(node.right);
			}
			if(node.left != null){
				stack.push(node.left);
			}
		}
	}
	
	public void preOrder_Stack2(TreeNode root){
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		stack.push(null);
		while(!stack.empty()){
			TreeNode node = stack.pop();
			if(node == null){ // this is from the root to left
				node = stack.pop();
				System.out.print(node.val + " ");
				stack.push(node);
				if(node.left != null){
					stack.push(node.left);
					stack.push(null);
				}
			}else{
				if(node.right != null){
					stack.push(node.right);
					stack.push(null);
				}
			}
		}
	}
	
	public void inOrder_Stack(TreeNode root){
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root.right != null){
			stack.push(root.right);
		}
		stack.push(root);
		stack.push(null);
		if(root.left != null){
			stack.push(root.left);
		}
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			if(node == null){
				node = stack.pop();
				System.out.print(node.val + " ");
			}else{
				if(node.right != null)
					stack.push(node.right);
				stack.push(node);
				stack.push(null);
				if(node.left != null)
					stack.push(node.left);
			}
		}
	}
	
	public void inOrder_Stack2(TreeNode root){
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			if(node == null){
				node = stack.pop();
				System.out.print(node.val + " ");
				if(node.right != null){
					stack.push(node.right);
				}
			}else{
				stack.push(node);
				stack.push(null);
				if(node.left != null){
					stack.push(node.left);
				}
			}
		}
	}
	
	public void postOrder_Stack(TreeNode root){
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			if(node == null){
				TreeNode n1 = stack.pop();
				if(n1 == null){ // 2 consecutive null means the root has already its children traverse
					node = stack.pop();
					System.out.print(node.val + " ");
				}else{ // 1 null means the root has finished the left children, and need to do the right
					stack.push(n1);
					stack.push(null);
					stack.push(null);
					if(n1.right != null){
						stack.push(n1.right);
					}
				}
			}else{
				stack.push(node);
				stack.push(null);
				if(node.left != null){
					stack.push(node.left);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Traverse_Stack traverse = new Traverse_Stack();
		TreeNode root = getRoot();
		traverse.preOrder_Stack(root);
		System.out.println("\n--------------");
		traverse.inOrder_Stack2(root);
		System.out.println("\n--------------");
		traverse.postOrder_Stack(root);
		
	}
	
	public static TreeNode getRoot(){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(16);
		return root;
	}

}
