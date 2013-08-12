package recursion;

public class GetBiggestSubset {


	public static void main(String[] args) {
		int data[] = {1,-10,20,-30};
		System.out.println(getBiggestSubset(data,data.length - 1));
		
	}
	
	public static int getBiggestSubset(int data[], int index){
		if(index == 0)
			return data[index];
		
		int preBig = getBiggestSubset(data,index - 1);
		if(data[index] <= 0 && preBig <= 0)
			return data[index] > preBig ? data[index] : preBig;
		else if(data[index] >= 0 && preBig >= 0)
			return data[index] + preBig;
		else if(data[index] <= 0 && preBig >= 0)
			return preBig;
		else
			return data[index];
	}
	

}
