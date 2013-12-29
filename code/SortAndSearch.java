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









