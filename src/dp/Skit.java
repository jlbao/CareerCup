package dp;

public class Skit {

	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		recursion();
		long t2 = System.currentTimeMillis();
		dp();
		long t3 = System.currentTimeMillis();
		
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		
	}
	
	
	public static void recursion(){
		Data d = new Data(5,5);
		d.data = new int[][]{{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}};
		int max = 0;
		for(int i = 0; i < d.data.length; i++){
			for(int j = 0; j < d.data[i].length; j++){
				int value = recursion_getMax(d,i,j);
				max = max > value ? max : value;
			}
		}
		
		System.out.println(max);
	}
	
	
	public static int recursion_getMax(Data d, int i, int j){
		
		int max = 0;
		if(i - 1 >= 0){
			if(d.data[i][j] > d.data[i - 1][j]){
				int value = recursion_getMax(d, i - 1, j);
				max = max > value ? max : value;
			}
		}
		
		if(i + 1 <= d.data.length - 1){
			if(d.data[i][j] > d.data[i + 1][j]){
				int value = recursion_getMax(d, i + 1, j);
				max = max > value ? max : value;
			}
		}
		
		if(j - 1 >= 0){
			if(d.data[i][j] > d.data[i][j - 1]){
				int value = recursion_getMax(d, i, j - 1);
				max = max > value ? max : value;
			}
		}
		
		if(j + 1 <= d.data.length - 1){
			if(d.data[i][j] > d.data[i][j + 1]){
				int value = recursion_getMax(d, i, j + 1);
				max = max > value ? max : value;
			}
		}
	
		return max + 1;
		
	}
	
	public static void dp(){
		Data d = new Data(5,5);
		d.data = new int[][]{{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}};
		for(int i = 0; i < d.data.length; i++){
			for(int j = 0; j < d.data[i].length; j++){
				getMax(d,i,j);
			}
		}
		int max = d.count[0][0];
		for(int i = 0; i < d.count.length; i++){
			for(int j = 0; j < d.count[i].length; j++){
				if(max < d.count[i][j])
					max = d.count[i][j];
			}
		}
		System.out.println(max);
	}
	
	
	
	public static int getMax(Data d,int i, int j){
		
		if(d.count[i][j] > 0)
			return d.count[i][j];
		
		int max = 0;
		if(i - 1 >= 0){
			if(d.data[i][j] > d.data[i - 1][j]){
				int value = getMax(d, i - 1, j);
				max = max > value ? max : value;
			}
		}
		
		if(i + 1 <= d.data.length - 1){
			if(d.data[i][j] > d.data[i + 1][j]){
				int value = getMax(d, i + 1, j);
				max = max > value ? max : value;
			}
		}
		
		if(j - 1 >= 0){
			if(d.data[i][j] > d.data[i][j - 1]){
				int value = getMax(d, i, j - 1);
				max = max > value ? max : value;
			}
		}
		
		if(j + 1 <= d.data[i].length - 1){
			if(d.data[i][j] > d.data[i][j + 1]){
				int value = getMax(d, i, j + 1);
				max = max > value ? max : value;
			}
		}
		
		return d.count[i][j] = max + 1;
	}
	
	
}
class Data{
	public int[][] data;
	public int[][] count;
	
	public Data(int i, int j){
		data = new int[i][j];
		count = new int[i][j];
	}
	
}

