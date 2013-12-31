package search;

public class SearchSortedStringWithEmpty {
	
/*
 * Given a sorted array of strings which is interspersed with empty strings
 * Write a method to find the location of a given string
 */

	public static void main(String[] args) {
		String[] data = {"aa","","bc", "", "", "","","cd"};
		System.out.println(find(data, "cd"));
	}

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
}
