package tree;

public class IsSubTree {
	/*
	 * You have two very large binary tree: T1, with millions of nodes, 
	 * and T2, with hundreds of nodes. 
	 * Create an algorithm to decide if T2 is a subtree of T1.
	 */
	
	public static void main(String[] args) {
		

	}
	
	public static boolean isSubTree(TreeNode t1, TreeNode t2){
		if(t1 == null || t2 == null){
			return false;
		}
		if(isTheSame(t1, t2)){
			return true;
		}
		return isSubTree(t1.left, t2) || isSubTree(t1.right, t2);
	}
	
	public static boolean isTheSame(TreeNode t1, TreeNode t2){
		if(t1 == null && t2 == null){
			return true;
		}
		if(t1 == null || t2 == null){
			return false;
		}
		if(t1.val == t2.val){
			return isTheSame(t1.left, t2.left) && isTheSame(t1.right, t2.right);
		}
		return false;
	}
}
