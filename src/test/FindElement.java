package test;

public class FindElement {


	public static void main(String[] args) {
		String[] s = {"aa","","bc","","","cd"};
//		System.out.println(isBigger("aa","bc"));
		
		System.out.println(find(s,"bc",0,s.length -1));
	}

	public static int find(String[] data, String value, int i, int j){
		
		while(i <= j){
			int mid = (i + j) / 2;
			if(data[mid] == value)
				return mid;
			else if (data[mid] == ""){
				int pre = find(data,value, i, mid - 1);
				if(pre != -1)
					return pre;
				int after = find(data, value, mid + 1, j);
				if(after != -1)
					return after;
				return -1;
			}else if(isBigger(value,data[mid]))
				i = mid + 1;
			else
				j = mid - 1;
		}
		return -1;
	}
	
	public static boolean isBigger(String s1, String s2){
		int i = 0;
		while(i < s1.length() && i < s2.length()){
			if(s1.charAt(i) < s2.charAt(i))
				return false;
			else if(s1.charAt(i) > s2.charAt(i))
				return true;
			i++;
		}
		return s1.length() < s2.length();	
	}
}
