package recursion;

public class FindElement {


	public static void main(String[] args) {
		int[] data = {2,3,5,6,12,15,18};
		System.out.println(find(data,3,0,data.length - 1));
	}
	
	public static int find(int[] data, int value, int i, int j){

		int mid = (i + j) / 2;
		if(data[mid] == value)
			return mid;
		if(i == j)
			return -1;
		
		int pre = find(data, value, i, mid);
		if(pre != -1)
			return pre;
		
		int after = find(data, value, mid + 1, j);
		if(after != -1)
			return after;
		
		return -1;
		
	}
	
}
