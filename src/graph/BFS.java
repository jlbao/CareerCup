package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	/**
	 * Using BFS to find the shortest path from head to node n
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
	public static void createGraph(){
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
	
	public static ArrayList<Integer> bfs_list(int root){
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(root);
		list.add(root);
		while(!q.isEmpty()){
			int node = q.poll();
			Node head = adjacancyList[node];
			while(head != null){
				if(!list.contains(head.id)){
					list.add(head.id);
					q.add(head.id);
				}
				head = head.next;
			}
		}
		return list;
	}
	
	
	public static ArrayList<Integer> bfs_table(int root){ // k is the root 
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(root);
		list.add(root);
		while(!q.isEmpty()){
			int node = q.poll();
			for(int i = node + 1; i < adjacancyTable[node].length; i++){
				if(adjacancyTable[node][i] && !list.contains(i)){
					q.add(i);
					list.add(i);
				}
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		createGraph();
		ArrayList<Integer> list = bfs_list(0);
		for(int val : list){
			System.out.print(val + " ");
		}
	}

}
