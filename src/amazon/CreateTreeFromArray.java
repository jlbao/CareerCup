package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class CreateTreeFromArray {

	/**
	 * create tree according to ascending sorted array
	 */
	public static void main(String[] args) {
		int[] data = {1,2,6,8,26,36};
		TreeNode root = createTree(data, 0, data.length - 1);
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
				System.out.print(n.data + " ");
				if(n.left != null)
					q.add(n.left);
				if(n.right != null)
					q.add(n.right);
			}
		}
	}
	
	public static TreeNode createTree(int[] data, int i, int j){
		if(i > j)
			return null;
		int mid = (i + j) / 2;
		TreeNode root = new TreeNode(data[mid]);
		TreeNode left = createTree(data,i,mid - 1);
		TreeNode right = createTree(data, mid + 1, j);
		root.left = left;
		root.right = right;
		return root;
	}
	
	
	public static class TreeNode{
		TreeNode left;
		TreeNode right;
		int data;
		
		public TreeNode(int data){
			this.data = data;
		}
	}

}

