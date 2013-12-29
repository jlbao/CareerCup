// a child is running a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time.
// Implement a method to count how many possible ways the child can run up the stairs.
public int getHopCount(int n, int[] store){
	if(n == 1){
		return 1;
	}
	if(n == 2){
		return 2;
	}
	if(n == 3){
		return 4;
	}
	if(store[n] != 0){
		return store[n];
	}
	store[n] = getHopCount(n - 1, store) + getHopCount(n - 2, store) + getHopCount(n - 3, store);
	return store[n];
}

// from top left to bottom right, how many ways to get there?
public static int robotToBottomRightCount(boolean[][] A){
	if(A == null || A.length == 0 || A[0].length == 0){ // boundary case check
		return 0;
	}
	int[][] store = new int[A.length][A[0].length];
	for(int i = 0; i < A.length; i++){
		for(int j = 0; j < A[0].length; j++){
			if(A[i][j]){
				if(i != 0 && j != 0){
					if(i == 0){
						store[i][j] = store[i][j - 1];
					}else if(j == 0){
						store[i][j] = store[i - 1][j];
					}else{
						store[i][j] = store[i][j - 1] + store[i - 1][j];
					}
				}else{ // at the 1st point
					store[0][0] = 1;
				}
			}else{ // this place is blocked
				store[i][j] = 0;
			}
		}
	}
	return store[store.length - 1][store[0].length - 1];
}

// Find the magic index for A[i] = i in increasing sorted unqiue array
// this is the recursion version
public static int find(int[] A, int l, int r){
	if(l > r){
		return -1;
	}	
	int mid = (l + r) / 2;
	if(A[mid] == mid){
		return mid;
	}else if(A[mid] < mid){
		return find(A, mid + 1, r);
	}else{
		return find(A, l, mid - 1);
	}
}

// this is the iteration version
public static int find(int[] A){
	int l = 0;
	int r = A.length - 1;
	while(l <= r){
		int mid = (l + r) / 2;
		if(A[mid] == mid){
			return mid;
		}else if(A[mid] > mid){
			r = mid - 1;
		}else{
			l = mid + 1;
		}
	}
	return -1;
}

// Find the magic index for A[i] = i in increasing sorted array (may have duplicate elements)
public static int find(int[] A, int l, int r){
	if(l > r){
		return -1;
	}
	int mid = (l + r) / 2;
	if(mid == A[mid]){
		return mid;
	}else if(mid < A[mid]){
		if(A[mid] <= r){
			int idx = find(A, A[mid] + 1, r);
			if(idx != -1){
				return idx;
			}
		}
		int idx = find(A, l, mid - 1);
		return idx;
	}else{
		if(A[mid] >= l){
			int idx = find(A, l, A[mid]);
			if(idx != -1){
				return idx;
			}
		}
		int idx = find(A, mid + 1, r);
		return idx;
	}
}

// write a method to return all subsets of a set
public static ArrayList<ArrayList<Integer>> getSubset(int[] A){
	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	list.add(new ArrayList<Integer>());
	for(int i = 0; i < A.length; i++){
		ArrayList<ArrayList<Integer>> newList = new ArrayList<ArrayList<Integer>>();
		for(int j = 0; j < list.size(); j++){
			ArrayList<Integer> one = new ArrayList<Integer>();
			one.addAll(list.get(j));
			one.add(A[i]);
			newList.add(one);
		}
		list.addAll(newList);	
	}
	return list;
}

// write a method to compute all permutations of a string of unique characters
public static ArrayList<String> getPermutations(String str){
		ArrayList<String> list = new ArrayList<String>();
		list.add("");
		for(int i = 0; i < str.length(); i++){
			ArrayList<String> newList = new ArrayList<String>();
			for(int j = 0; j < list.size(); j++){
				newList.addAll(permuteString(list.get(j), str.charAt(i)));
			}
			list = newList;
		}
		return list;
	}
	
// permute the String, using subString
public static ArrayList<String> permuteString(String s, char c){
	ArrayList<String> list = new ArrayList<String>();
	for(int i = 0; i < s.length() + 1; i++){
		String str1 = s.substring(0, i);
		String str2 = s.substring(i, s.length());
		String newStr = str1 + c + str2;
		list.add(newStr);
	}
	return list;
}


// permute the string
public static ArrayList<String> permute(String s, char c){
	ArrayList<String> list = new ArrayList<String>();
	char[] oldChars = s.toCharArray();
	for(int i = 0; i < s.length() + 1; i++){ // find place to insert the new char
		char[] newChars = new char[s.length() + 1];
		newChars[i] = c; // put the insert char
		for(int j = 0, k = 0; j < oldChars.length; j++, k++){ // copy original to new string
			if(i == j){ // this slot has been inserted by the insert char
				k++; // k is in charge of the index of new char array
			}
			newChars[k] = oldChars[j];
		}
		String newStr = new String(newChars);
		list.add(newStr);
	}
	return list;
}

// implement an algorithm to print all valid combinations of n-paris of parenthesis
public static void printBrackets(int left, int right, String str){
	if(left == 0 && right == 0){
		System.out.println(str);
	}else if(left <= right){
		if(left > 0){
			printBrackets(left - 1, right, str + "(");
		}
		if(left < right){
			printBrackets(left, right - 1, str + ")");
		}
	}
}


// paint fill. Given a 2-dimensional array, a color, and a new color,
// fill in the surrending area until the color changes from the original color
class Position{
	public int x;
	public int y;
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public static void paint(Color[][] screen, int i, int j, Color nColor){
	if(screen[j][i] == nColor){
		return;
	}
	Queue<Position> q = new LinkedList<Position>();
	q.add(new Position(j, i));
	while(!q.isEmpty()){
		Position p = q.poll();
		int x = p.x;
		int y = p.y;
		screen[y][x] = nColor;
		if(x - 1 >= 0 && screen[y][x - 1] != nColor){
			q.add(new Position(y, x - 1));
		}
		if(x + 1 < screen[x].length && screen[y][x] != nColor){
			q.add(new Position(y, x + 1));
		}
		if(y - 1 >= 0 && screen[y][x] != nColor){
			q.add(new Position(y - 1, x));
		}
		if(y + 1 < screen.length && screen[y + 1][x] != nColor){
			q.add(new Position(y + 1, x));
		}
	}
}

// given an infinte number of quarters(25 cents), dimes(10 cents),
// nickles(5 cents) and pennies(1 cent)
// calculate the number of ways of reprenting n cents
public static int wayCount(int n, int[] size, int[][] store, int index){
	if(index == size.length - 1){
		return 1;
	}
	if(store[index][n] != 0){
		return store[index][n];
	}
	int ways = 0;
	for(int i = 0; i * size[index] <= n; i++){
		ways += wayCount(n - i * size[index], size, store, index + 1);
	}	
	store[index][n] = ways;
	return ways;
}











