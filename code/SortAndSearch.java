// merge sort
public static void mergeSort(int[] A, int[] helper, int l, int r){
	if(l >= r){
		return;
	}
	int mid = (l + r) / 2;
	mergeSort(A, helper, l, mid);
	mergeSort(A, helper, mid + 1, r);
	merge(A, helper, l, mid, r);
}

public static void merge(int[] A, int[] helper, int l, int mid, int r){
	for(int i = l; i <= r; i++){
		helper[i] = A[i];
	}
	int i = l;
	int j = mid + 1;
	int k = l; // k keep track of the index in helper array
	while(i <= mid || j <= r){
		if(i <= mid && j <= r){
			if(helper[i] < helper[j]){
				A[k] = helper[i];
				i++;
			}else{
				A[k] = helper[j];
				j++;
			}
		}else if(i <= mid){
			A[k] = helper[i];
			i++;
		}else{
			A[k] = helper[j];
			j++;
		}
		k++;
	}
}

// quick sort, choose the last element as pivot
public static void quickSort(int[] A, int l, int r){
	if(l >= r){
		return;
	}
	int mid = partition(A, l, r);
	quickSort(A, l, mid - 1);
	quickSort(A, mid + 1, r);
}

public static int partition(int[] A, int l, int r){
	// choose pivot as the last element
	int i = l - 1;
	int j = l;
	while(j < r){
		if(A[j] < A[r]){
			// swap with A[i]
			i++;
			int tmp = A[i];
			A[i] = A[j];
			A[j] = tmp;
		}
		j++;
	}
	// swap with the pivot
	i++;
	int tmp = A[i];
	A[i] = A[r];
	A[r] = tmp;
	return i;
}

// 2 sorted arrays, A and B, where A has enough buffer at the end to hold B
// Merge B into A in sorted order
public static void merge(int[] A, int[] B, int aLen){
	int k = aLen + B.length - 1;
	int i = aLen - 1;
	int j = B.length - 1;
	while(j >= 0){
		if(i >= 0){ // A is not used up
			if(A[i] < B[j]){
				A[k] = B[j];
				j--;
			}else{
				A[k] = A[i];
				i--;
			}
		}else{ // A is used up
			A[k] = B[j];
			j--;
		}
		k--;
	}
}

// write a method to sort an array of strings so that anagrams are next to each other
public static void group(String[] A){
	Hashtable<String, LinkedList<String>> table = new Hashtable<String, LinkedList<String>>();
	for(int i = 0; i < A.length; i++){
		String sortedStr = sortedString(A[i]);
		if(!table.containsKey(sortedStr)){
			table.put(sortedStr, new LinkedList<String>());
		}
		LinkedList<String> list = table.get(sortedStr);
		list.add(A[i]);
	}
	int index = 0;
	for(LinkedList<String> list: table.values()){
		for(String val : list){
			A[index++] = val;
		}
	}
}

// Sort String array
public static String sortedString(String str){
	char[] chars = str.toCharArray();
	Arrays.sort(chars);
	return new String(chars);
}

// Given a sorted array of n integers that has been rotated an unknown number of times
// write code to find an element in the array. You may assume the array is originally sorted in increasing order

// this is the unique element version
public static int find(int[] A, int val){
	int l = 0;
	int r = A.length - 1;
	while(l <= r){
		int mid = (l + r) / 2;
		if(val == A[mid]){
			return mid;
		}
		if(A[mid] > A[l]){
			if(val > A[mid]){
				l = mid + 1;
			}else if(val >= A[l]){
				r = mid - 1;
			}else{
				l = mid + 1;
			}
		}else{ // A[mid] < A[l]
			if(val < A[mid]){
				r = mid - 1;
			}else if(val <= A[r]){
				l = mid + 1;
			}else{
				r = mid - 1;
			}
		}
	}
	return -1;
}

public static int find(int[] A, int val, int l, int r){
	if(l > r){
		return -1;
	}
	int mid = (l + r) / 2;
	if(A[mid] == val){
		return mid;
	}
	if(A[mid] > A[l]){ // left is in increasing order
		if(val > A[mid]){
			return find(A, val, mid + 1, r);
		}else if(val >= A[l]){
			return find(A, val, l, mid - 1);
		}else{
			return find(A, val, mid + 1, r);
		}
	}else if(A[mid] < A[l]){ // right is in increasing order
		if(val < A[mid]){
			return find(A, val, l, mid - 1);
		}else if(val <= A[r]){
			return find(A, val, mid + 1, r);
		}else{
			return find(A, val, l, mid - 1);
		}
	}else{ // A[mid] == A[l]
		// 2 2 2 2 2 3 4 5 6 1
		if(A[mid] != A[r]){ // search right
			return find(A, val, mid + 1, r);
		}else{ // search left first
			// 2 2 2 2 2 3 4 5 1 2
			// 2 3 4 5 2 2 2 2 2 2
			int res = find(A, val, l, mid - 1);
			if(res != -1){
				return res;
			}
			return find(A, val, mid + 1, r);
		}
	}
}

// Given a sorted array of strings which is interpersed with empty strings
// Write a method to find the location of a given string
public static int find(String[] A, String val){
	int l = 0;
	int r = A.length - 1;
	while(l <= r){
		int mid = (l + r) / 2;
		if(A[mid].isEmpty()){
			int i = mid - 1;
			int j = mid + 1;
			while(true){
				if(i >= 0 && !A[i].isEmpty()){
					mid = i;
					break;
				}else if(j < A.length && !A[j].isEmpty()){
					mid = j;
					break;
				}else if(i < l && j > r){
					return -1;
				}
				i--;
				j++;
			}
		}
		if(val.equals(A[mid])){
			return mid;
		}else if(val.compareTo(A[mid]) > 0){
			l = mid + 1;
		}else{
			r = mid - 1;
		}
	}
	return -1;
}

class Person implements Comparable<Person>{
	int height;
	int weight;
	public Person(int h, int w){
		this.height = h;
		this.weight = w;
	}
	public int compareTo(Person p){
		if(this.height == p.height){
			return 0;
		}else if(this.height > p.height){
			return 1;
		}else{
			return -1;
		}
	}
}

// used a little dp
public static ArrayList<Person> getLargestNumber(Person[] pList){
	Arrays.sort(pList);
	int[] maxStore = new int[pList.length];
	int[] sequence = new int[pList.length];
	int max = 0;
	int maxIndex = 0;
	for(int i = 0; i < pList.length; i++){
		maxStore[i] = 1;
		sequence[i] = -1;
		for(int j = i - 1; j >= 0; j--){ // go back to find the weight that has the maximum count
			if(pList[j].weight <= pList[i].weight){ 
				if(maxStore[j] + 1 > max){
					maxStore[i] = maxStore[j] + 1;
					sequence[i] = j;
				}
			}
		}
		if(max < maxStore[i]){
			max = maxStore[i];
			maxIndex = i;
		}
	}
	ArrayList<Person> list = new ArrayList<Person>();
	for(int i = maxIndex; i >= 0; i = sequence[i]){
		list.add(pList[i]);
	}
	
	// reverse
	for(int i = 0; i < list.size() / 2; i++){
		Person p = list.get(i);
		list.set(i, list.get(list.size() - 1 - i));
		list.set(list.size() - 1 - i, p);
	}
	return list;
}

// Imagine given a stream of integers
// design a algorithm to implement the method of "track(int x)"
// which is called when each number is generated
// and the method "getRankOfNumber(int x)"
// return the number of values less than or equal to x(not including x itself)

class RankNode{
	public RankNode left;
	public RankNode right;
	public int val;
	public int leftCount;

	public RankNode(int val){
		this.val = val;
	}

	public void insert(int val){
		if(this.val > val){
			if(this.left != null){
				this.left.insert(val);
			}else{
				this.left = new RankNode(val);
			}
			this.leftCount++;
		}else{
			if(this.right != null){
				this.right.insert(val);
			}else{
				this.right = new RankNode(val);
			}
		}
	}
	
	public int getRankOfNumber(int x){
		if(this.val == x){
			return this.leftCount;
		}else if(this.val < x){
			if(this.left == null){
				return -1;
			}
			return this.left().getRankOfNumber(x);
		}else{
			if(this.right == null){
				return -1;
			}
			return this.leftCount + this.right.getRankOfNumber(x) + 1;
		}
	}
	
}













