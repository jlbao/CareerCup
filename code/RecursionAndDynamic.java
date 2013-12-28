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