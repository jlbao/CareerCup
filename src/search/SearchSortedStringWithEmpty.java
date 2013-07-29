package search;

public class SearchSortedStringWithEmpty {


	public static void main(String[] args) {
		String[] data = {"aa","","bc","","","cd"};
		System.out.println(searchString(data, "cd", 0, data.length - 1));
	}
	
	public static int searchString(String[] data, String value, int i, int j){

		while(i <= j){
			int mid = (i + j) / 2;
			if(data[mid] == ""){
				int left = searchString(data, value, mid + 1, j);
				int right = searchString(data, value, i, mid - 1);
				
				if(left != -1)
					return left;
				else if(right != -1)
					return right;
				else
					return -1;
			}else if(value == data[mid])
				return mid;
			else if(isBigger(value,data[mid]))
				i = mid + 1;
			else
				j = mid - 1;
		}
		
		return -1;
		
	}
	
	public static boolean isBigger(String data1, String data2){
		int i = 0;
		while(i < data1.length() && i < data2.length()){
			if((int)data1.charAt(i) < (int)data2.charAt(i))
				return false;
			else if((int)data1.charAt(i) > (int)data2.charAt(i))
				return true;
			else
				i++;
		}
		return data1.length() > data2.length();
	}
	

}
