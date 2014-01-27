package tree;

import java.util.ArrayList;
import java.util.LinkedList;

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
		
		ArrayList<ArrayList<Integer>> coll = new ArrayList<ArrayList<Integer>>();
		dfs(root, 31, coll, new ArrayList<Integer>());
		for(ArrayList<Integer> one : coll){
			for(int val : one){
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

	public static void dfs(TreeNode root, int target, ArrayList<ArrayList<Integer>> coll, ArrayList<Integer> level){
		if(root == null){
			return;
		}
		level.add(root.val);
		LinkedList<Integer> list = new LinkedList<Integer>();
		int sum = 0;
		for(int i = level.size() - 1; i >= 0; i--){
			sum += level.get(i);
			list.addFirst(level.get(i));
			if(sum == target){
				coll.add(new ArrayList<Integer>(list));
			}
		}
		dfs(root.left, target, coll, level);
		dfs(root.right, target, coll, level);
		level.remove(level.size() - 1);
	}
}
