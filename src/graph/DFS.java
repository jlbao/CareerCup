package graph;

import java.util.ArrayList;
import java.util.HashSet;
public class DFS {

	/**
	 * Depth first search
	 */
	
	static boolean[][] adjacancyTable;
	static Node[] adjacancyList;
	
	static class Node{
		int id;
		Node next;
		public Node(int id){
			this.id = id;
		}
	}
	public static void createNonDirectedGraph(){
		adjacancyTable = new boolean[7][7];
		adjacancyTable[0][1] = true;
		adjacancyTable[1][0] = true;
		adjacancyTable[0][3] = true;
		adjacancyTable[3][0] = true;
		adjacancyTable[1][2] = true;
		adjacancyTable[2][1] = true;
		adjacancyTable[1][4] = true;
		adjacancyTable[4][1] = true;
		adjacancyTable[1][6] = true;
		adjacancyTable[6][1] = true;
		adjacancyTable[3][5] = true;
		adjacancyTable[5][3] = true;
		
		adjacancyList = new Node[adjacancyTable.length];
		for(int i = 0; i < adjacancyTable.length; i++){
			Node head = adjacancyList[i];
			for(int j = 0; j < adjacancyTable[i].length; j++){
				if(adjacancyTable[i][j]){
					if(head == null){
						adjacancyList[i] = new Node(j);
						head = adjacancyList[i];
					}else{
						head.next = new Node(j);
						head = head.next;
					}
				}
			}
		}
	}
	
	public static void createDirectedGraph(){
		adjacancyTable = new boolean[5][5];
		adjacancyTable[0][1] = true;
		adjacancyTable[0][2] = true;
		adjacancyTable[1][3] = true;
		adjacancyTable[1][4] = true;
		adjacancyTable[2][1] = true;
		adjacancyTable[3][4] = true;
		adjacancyTable[4][2] = true;
		
		adjacancyList = new Node[adjacancyTable.length];
		for(int i = 0; i < adjacancyTable.length; i++){
			Node head = adjacancyList[i];
			for(int j = 0; j < adjacancyTable[i].length; j++){
				if(adjacancyTable[i][j]){
					if(head == null){
						adjacancyList[i] = new Node(j);
						head = adjacancyList[i];
					}else{
						head.next = new Node(j);
						head = head.next;
					}
				}
			}
		}
	}
	
	// judge if there is a loop in directed graph
	// Using hashset is because we only want to judge if there is a loop
	public static boolean judgeLoopInList(int root, HashSet<Integer> graySet,HashSet<Integer> finishedSet){
		graySet.add(root);
		Node head = adjacancyList[root];
		while(head != null){
			if(!finishedSet.contains(head.id)){
				if(graySet.contains(head.id)){
					return true;
				}else{
					boolean result = judgeLoopInList(head.id, graySet, finishedSet);
					if(result)
						return true;
				}
			}
			head = head.next;
		}
		graySet.remove(root);
		finishedSet.add(root);
		return false;
	}
	
	
	// non directed graph
	// if want to support disjointed graph, need another function to check if all vertices have been traversed
	// if not, randomly select a vertex to make dfs traverse
	// dfs is just like a pre order
	// we can also use post order, but we should keep in mind that: 
	// we need to add to list first, then remove at the end of call, and add again. 
	
	// can support disjointed graph
	public static ArrayList<Integer> dfs_list(int v){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < adjacancyList.length; i++){
			if(!list.contains(i)){
				dfs_one_list(i, list);
			}
		}
		return list;
	}
	
	private static ArrayList<Integer> dfs_one_list(int v, ArrayList<Integer> list){
		list.add(v);
		Node head = adjacancyList[v];
		while(head != null){
			if(!list.contains(head.id)){
				dfs_one_list(head.id, list);
			}
			head = head.next;
		}
		return list;
	}
	
	public static ArrayList<Integer> dfs_table(int v){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < adjacancyList.length; i++){
			if(!list.contains(i)){
				dfs_one_table(i, list);
			}
		}
		return list;
	}
	
	
	private static ArrayList<Integer> dfs_one_table(int v, ArrayList<Integer> list){
		list.add(v); // v was discovered
		for(int i = 0; i < adjacancyTable[v].length; i++){
			if(adjacancyTable[v][i] && !list.contains(i)){
				dfs_one_table(i, list);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		createDirectedGraph();
		ArrayList<Integer> list = dfs_list(0);
		for(int val : list){
			System.out.print(val + " ");
		}
	}

}
