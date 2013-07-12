package search;

public class FindElementInOneHalfSortedArray {

	public static void main(String[] args) {
		int[] data = {6,8,35,39,1,2,3,4,5};
		System.out.println(getElementTurnPoint(data));
		System.out.println(findElement(data,35));
	}
	
	public static int find(int[] data, int value){
		int i = 0;
		int j = data.length - 1;
		while(i <= j){
			int mid = (i + j) / 2;
			if(value == data[mid]){
				return mid;
			}else if(data[i] < data[mid]){
				if(value < data[i])
					i = mid + 1;
				else
					j = mid - 1;
			}else{ //data[i] > data[mid]
				if(value < data[mid])
					j = mid - 1;
					
			}
			
		}
		
	}
	
	
	
	
	
	
	public static int findElement(int[] data, int value){
		int turnPoint = getElementTurnPoint(data);
		int i, j;
		if(data[turnPoint] == value)
			return turnPoint; 
		else if(value < data[turnPoint - 1]){
			i = 0;
			j = turnPoint - 1;
		}else{
			i = turnPoint;
			j = data.length - 1;
		}

		while(i <= j){
			int mid = (i + j) / 2;
			if(data[mid] == value)
				return mid;
			else if(value < data[mid])
				j = mid - 1;
			else
				i = mid + 1;
		}
		return -1;
	}
	
	//get turn point of an array(2 sorted list, the 1st sorted list > 2nd sorted list)
	public static int getElementTurnPoint(int[] data){
		int i = 0;
		int j = data.length - 1;
		
		if(data[i] < data[j])
			return -1;
		
		while(i + 1 != j){
			int mid = (i + j) / 2;
			if(data[mid] > data[i])
				i = mid;
			else
				j = mid;
		}
		return j;
	}
	
}
