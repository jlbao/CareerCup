package leetcode;

public class CheckSymmetricTree {

	/**
	 * Given a binary tree, 
	 * check whether it is a mirror of itself 
	 * (ie, symmetric around its center).
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		//root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		//root.right.right = new TreeNode(3);
		
		boolean result = isSymmetric(root);
		System.out.println(result);
	}
	
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
        return validate(root.left, root.right);
    }
    
    public static boolean validate(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        else if(left != null && right != null){
            if(left.val == right.val)
                return validate(left.left, right.right) && validate(left.right, right.left);
            else
                return false;
        }else
            return false;
    }
}
