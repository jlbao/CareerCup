package tree;

import java.util.ArrayList;

public class PrintAllPaths {
/*
 * Given a binary tree that each node contains a value.
 * Design an algorithm to print all paths with sums to a given value
 * the path does not need to start from the root and end at the leave
 * 
 * the complexity should be O(n^2)
 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(19);
		root.left = new TreeNode(12);
		root.right = new TreeNode(26);
		root.left.left = new TreeNode(19);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(5);
		
		ArrayList<ArrayList<TreeNode>> paths = new ArrayList<ArrayList<TreeNode>>();
		printPaths(root, 31, paths);		
	}

	public static void printPaths(TreeNode root, int x, ArrayList<ArrayList<TreeNode>> paths){
		if(root == null){
			return;
		}
		getPathForOneNode(root, paths, new ArrayList<TreeNode>(), x);
	}

	public static void getPathForOneNode(TreeNode root, ArrayList<ArrayList<TreeNode>> paths, ArrayList<TreeNode> list, int x){
		if(root == null){
			return;
		}
		list.add(root);
		int sum = 0;
		for(int i = list.size() - 1; i >= 0; i--){
			sum += list.get(i).val;
			if(sum == x){
				print(list, i, list.size() - 1);
			}
		}
		getPathForOneNode(root.left, paths, list, x);
		getPathForOneNode(root.right, paths, list, x);
		list.remove(root);
	}
	
	public static void print(ArrayList<TreeNode> list, int l, int r){
		for(int i = l; i <= r; i++){
			System.out.print(list.get(i).val + " ");
		}
		System.out.println();
	}
	
}
