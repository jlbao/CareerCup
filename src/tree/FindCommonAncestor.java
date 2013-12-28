package tree;

public class FindCommonAncestor {

	public static void main(String[] args){
		TreeNode root = new TreeNode(19);
		root.left = new TreeNode(12);
		root.right = new TreeNode(26);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(15);
		root.right.left = new TreeNode(20);
		root.right.right = new TreeNode(30);
		
		TreeNode node = findCommonAncestor(root, root.left.left, root.left.right);
		System.out.println(node.val);	
	}
	
	// find the first common Ancestor for 2 tree nodes in a binary tree
	public static TreeNode findCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2){
		TreeNode node = find(root, n1, n2);
		if(node != n1 && node != n2){
			return node;
		}else if(node == n1 && isInTree(node, n1)){
			return node;
		}else if(node == n2 && isInTree(node, n2)){
			return node;
		}
		return null;
	}

	public static TreeNode find(TreeNode root, TreeNode n1, TreeNode n2){
		if(root == null){
			return null;
		}
		if(root == n1){
			return n1;
		}
		if(root == n2){
			return n2;
		}
		TreeNode left = find(root.left, n1, n2);
		TreeNode right = find(root.right, n1, n2);
		if(left != null && right != null){
			return root;
		}else if(left != null){
			return left;
		}else if(right != null){
			return right;
		}
		return null;
	}

	// check if the node is in the tree
	public static boolean isInTree(TreeNode root, TreeNode node){
		if(root == null){
			return false;
		}
		if(root == node){
			return true;
		}
		return isInTree(root.left, node) || isInTree(root.right, node);
	}
}
