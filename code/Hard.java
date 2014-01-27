// Write a method to count the number of 2s that appear in all the numbers between 0 and n(inclusive)
// Example: Input: 25
// Output: 9 (2, 12, 20, 21, 22, 23, 24. Note that 22 counts for two 2s)

// brutal way to do this, not efficient

public int get2Count(int n){
	int count = 0;
	for(int i = 2; i < n; i++){
		while(n != 0){
			if(n % 10 == 2){
				count++;
			}
			n = n / 10;
		}
	}
	return count;
}

// You have a large text file containing words. Given any two words, find the shortest distance (in terms of number of words)
// between them in the file. If the operation will be repeated many times for the same file (but different pairs of words)
// Can you optimize your solution?

public static int findMinInterval(String[] words, String s1, String s2){
	Hashtable<String, ArrayList<Integer>> table = new Hashtable<String, ArrayList<Integer>>();
	for(int i = 0; i < words.length(); i++){ // put the words into the hashtable
		if(table.containsKey(word)){
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(i);
			table.put(word, list);
		}else{
			table.get(word).add(i);
		}
		table.put(word, i);
	}
	ArrayList<Integer> l1 = new ArrayList<Integer>();
	ArrayList<Integer> l2 = new ArrayList<Integer>();
	int i = 0, j = 0;
	int min = Integer.MAX_VALUE;
	boolean fromL1 = true;
	int last = Integer.MAX_VALUE;
	for(i < l1.size() && j < l2.size()){ // speicial merge without array, only check if the last one is different from the current one
		if(l1.get(i) < l2.get(j)){
			if(!fromL1){ // the last is from L2
				fromL1 = true;
				min = Math.min(min, Math.abs(l1.get(i) - last));
			}
			last = l1.get(i);
			i++;
		}else{
			if(fromL1){
				fromL1 = false;
				min = Math.min(min, Math.abs(l2.get(j) - last));
			}
			last = l2.get(j);
			j++;
		}
	}
	if(i < list.size()){
		min = Math.min(min, Math.abs(l1.get(i) - last));
	}else{
		min = Math.min(min, Math.abs(l2.get(j) - last));
	}
	return min;
}


// Describle an algorithm to find the smallest one million numbers
// in one billion numbers. Assume the computer can hold all one billion numbers
public static ArrayList<Integer> getTopNumbers(int[] A){
	PriorityQueue<Integer> queue = new PriorityQueue<Integer>(10);
	for(int i = 0; i < A.length; i++){
		queue.add(A[i]);
	}
	ArrayList<Integer> list = new ArrayList<Integer>();
	list.addAll(queue);
	return list;
}








