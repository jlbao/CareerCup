package search;

public class FindMaxAndMinInArray {

	/**
	 * Find max and min value in an array simultaneously with the least complexity 
	 * O(3n / 2)
	 */
	public static void main(String[] args) {
		int[] data = {23, 25, 12, 5, 3, 18, 36, 10, 58, 88, 50, 36};
		int[] result = getMaxAndMin(data);
		System.out.println("min: " + result[0]);
		System.out.println("max: " + result[1]);
	}
	
	public static int[] getMaxAndMin(int[] data){
		int max, min = 0;
		int startIndex = 0;
		if(data.length % 2 == 0){ 
			//need to consider if the count of array is odd or even
			startIndex = 2;
			if(data[0] < data[1]){
				min = data[0];
				max = data[1];
			}else{
				max = data[0];
				min = data[1];
			}
		}else{
			startIndex = 1;
			max = data[0];
			min = data[0];
		}
		
		for(int i = startIndex; i < data.length; i = i + 2){
			if(data[i] < data[i + 1]){
				if(data[i] < min)
					min = data[i];
				if(data[i + 1] > max)
					max = data[i + 1];
			}else{
				if(data[i] > max)
					max = data[i];
				if(data[i + 1] < min)
					min = data[i + 1];
			}
		}
		int[] result = new int[2];
		result[0] = min;
		result[1] = max;
		return result;
	}
}
