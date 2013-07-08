package recursion;

public class FindElementByRowAndList {

	public static void main(String[] args) {
		int data[][] = {{1,5,9},{2,7,21},{3,19,22}};
		int index[] = findElement(data,0,0,21);
		System.out.println(index[0] + " " + index[1]);
	}

	public static int[] findElement(int data[][], int i, int j, int elementData){
		if(elementData == data[i][j])
			return new int[]{i,j};
		if(i + 1 >= data.length)
			return new int[]{-1, -1};
		else if(j + 1 >= data[0].length)
			return new int[]{-1, -1};
		
		int[] rowData = findElement(data,i, j + 1, elementData);
		int[] listData = findElement(data,i + 1, j, elementData);
		if(rowData[0] != -1)
			return rowData;
		if(listData[0] != -1)
			return listData;
		else
			return new int[]{-1, -1};
	}
	
}
