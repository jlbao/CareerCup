package recursion;

public class FindElementByRowAndList {

	public static int count = 0;
	public static void main(String[] args) {
		int data[][] = { { 1, 14, 25, 35 }, { 2, 16, 28, 38 }, { 5, 20, 28, 40 }, { 16, 22, 38, 41 } };
		int index[] = findElement(data,0,0,150);
		System.out.println(index[0] + " " + index[1]);
		//System.out.println(count);
		
		int i[] = find(data,16);
		
		System.out.println(i[0] + " " + i[1]);
	}

	public static int[] find(int[][] data, int value){
		int i = 0;
		int j = data[0].length - 1;
		
		while(i < data.length && j >= 0){
			if(data[i][j] == value)
				return new int[]{i,j};
			else if(value > data[i][j])
				i++;
			else
				j--;
		}
		return new int[]{-1,-1};
	}
	
	
	
	public static int[] findElement(int data[][], int i, int j, int elementData){
		count++;
		if(i >= data[0].length)
			return new int[]{-1,-1};
		else if(j >= data.length)
			return new int[]{-1, -1};
		else if(elementData < data[i][j])
			return new int[]{-1, -1};
		else if(elementData == data[i][j])
			return new int[]{i, j};
		
		int[] rowData = findElement(data,i, j + 1, elementData);
		if(rowData[0] != -1)
			return rowData;
		
		int[] listData = findElement(data,i + 1, j, elementData);
		if(listData[0] != -1)
			return listData;
		
		return new int[]{-1, -1};
	}
	
}
