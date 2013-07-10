package search;

public class BinarySearch {


	public static void main(String[] args) {
		int data[] = {1, 5, 9, 12, 29, 38, 50};
		int index = binarySearch(data, 5);
		System.out.println(index);
	}
	
	public static int binarySearch(int[] data, int d){
		int i = 0;
		int j = data.length - 1;
		while(i < j){
			int mid = (i + j) / 2;
			if(data[mid] < d){
				i = mid + 1;
			}else if(data[mid] > d){
				j = mid - 1;
			}else
				return mid;
		}
		return -1;
	}

}
