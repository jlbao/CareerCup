
// given a directed graph, design an algorithm to find whether there is a route between 2 nodes
public static boolean isConnected(HashTable<ListNode, ListNode> table, ListNode n1, ListNode n2){
	ListNode p = table.get(n1);
	while(p != null){
		if(!p.visited){
			p.visited = true;
			if(isConnected(table, p, n2)){
				return true;
			}
		}
	}
	return false;
}

// given a sorted array, create a binary search tree with minimum height
public static TreeNode createBinarySearchTree(int[] A, int i, int j){
	if(i > j)
		return null;
	int mid = (i + j) / 2;
	TreeNode root = new TreeNode(mid);
	root.left = createBinarySearchTree(A, i, mid - 1);
	root.right = createBinarySearchTree(A, mid + 1, j);
	return root;
}

// given a binary tree, design an algorithm which creates a linkedlist of all
// the nodes at each depth (e.g, if you have a tree with depth D, you will have D linkedlists)
public static ArrayList<LinkedList<TreeNode>> createDepthList(TreeNode root){
	Queue<TreeNode> q = new LinkedList<TreeNode>();
	ArrayList<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>();
	LinkedList<TreeNode> linkedlist = null;
	q.add(root);
	q.add(null);
	while(!q.isEmpty()){
		TreeNode node = q.poll();
		if(node == null){	// this is a new level
			linkedlist = null;
			if(!q.isEmpty()){
				q.add(null);
			}
		}else{ 
			if(linkedlist == null){
				linkedlist = new LinkedList<TreeNode>();
				linkedlist.add(node);
				list.add(linkedlist);
			}else{
				linkedlist.add(node);
			}
			if(node.left != null){
				q.add(node.left);
			}
			if(node.right != null){
				q.add(node.right);
			}
		}
	}
	return list;
}

// check if a binary tree is a binary search tree
public static boolean isBST(TreeNode root, int low, int high){
	if(root == null){
		return true;
	}
	if(root.val < low || root.val > high){
		return false;
	}
	return isBST(root.left, low, root.val) && isBST(root.right, root.val, high);
}

// or we can use mid order to traverse and put them into the list
// and check if the list is in ascending order
public static isBST(TreeNode root){
	ArrayList<TreeNode> list = new ArrayList<TreeNode>();
	inOrder(root, list);
	for(int i = 0; i < list.size() - 1; i++){
		if(list.get(i).val > list.get(i + 1).val){
			return false;
		}
	}
	return true;
}

public static void inOrder(TreeNode root, ArrayList<TreeNode> list){
	if(root == null){
		return;
	}
	inorder(root.left, list);
	list.add(root);
	inorder(root.right, list);
}

// find the 'next' node of a given node in a BST, assume there is a link to parent
// there are 3 possibilites
// 1, has right child
// 2, is the left child
// 3, has no right child, is not the left child
public TreeNode getNextNode(TreeNode node){
	 if(node == null){
	 	return null;
	 }
	 if(node.parent == null){ // it is a root
	 	return node.right;
	 }
	 if(node.right != null){ // node has right child
	 	TreeNode p = node.right;
	 	while(p.left != null){ // find the leftmost child for the right child
	 		p = p.left;
	 	}
	 	return p;
	 }
	 if(node.parent.left == node){ // node is the right child 
	 	return node.parent;
	 }

	 TreeNode p = node.parent;
	 while(p != null){	// find a node that is bigger or equal than it
	 	if(p.val >= node.val){
	 		return p;
	 	}
	 	p = p.parent;
	 }
	 return null;
}

// find the first common Ancestor for 2 tree nodes in a binary tree
public static TreeNode findCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2){
	TreeNode node = find(root, n1, n2);
	if(node != n1 && node != n2){
		return node;
	}else if(node == n1 && isInTree(node, n2)){
		return node;
	}else if(node == n2 && isInTree(node, n1)){
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

public static boolean isInTree(TreeNode root, TreeNode node){
	if(root == null){
		return false;
	}
	if(root == node){
		return true;
	}
	return isInTree(root.left, node) || isInTree(root.right, node);
}


// A very large tree T1, a small tree T2, check if T2 is a subtree of T1
public static boolean isSubTree(TreeNode t1, TreeNode t2){
	if(t1 == null){
		return false;
	}
	if(isInTree(t1, t2)){
		return true;
	}
	return isSubTree(t1.left, t2) || isSubTree(t1.right, t2);
}

public static boolean isInTree(TreeNode t1, TreeNode t2){
	if(t1 == null && t2 == null){
		return true;
	}
	if(t1 != null && t2 != null){
		if(t1.val == t2.val){
			return isInTree(t1.left, t2.left) && isInTree(t1.right, t2.right);
		}
	}
	return false;
}

// Given a binary tree that each node contains a value.
// Design an algorithm to print all paths with sums to a given value
// the path does not need to start from the root and end at the leave

public static void getPaths(TreeNode root, int x, ArrayList<ArrayList<TreeNode>> paths){
	if(root == null){
		return;
	}
	getPathForOneNode(root, paths, new ArrayList<TreeNode>(), 0, x);
	getPaths(root.left, x, paths);
	getPaths(root.right, x, paths);
}


public static void getPathForOneNode(TreeNode root, ArrayList<ArrayList<TreeNode>> paths, ArrayList<TreeNode> list, int sum, int x){
	if(root == null){
		return;
	}
	list.add(root);
	sum += root.val;
	if(sum == x){
		paths.add(list);
	}
	getPathForOneNode(root.left, paths, list, sum, x);
	getPathForOneNode(root.right, paths, list, sum, x);
}










