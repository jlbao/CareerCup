package sort;

public class GetBiggestTower {


	public static void main(String[] args) {
		Plate[] plates = new Plate[]{new Plate(100,98),
									new Plate(95,90),
									new Plate(110,102),
									new Plate(50,120),
									new Plate(30,115),
									new Plate(35,110),
									new Plate(20,135)};
		
		int[] heightSortedIndex = mergeSort(plates,0,plates.length - 1, true);
		int[] weightSortedIndex = mergeSort(plates,0,plates.length - 1, false);
		
		int[] buffer = new int[plates.length];
		Plate[] sortedTower = new Plate[plates.length];
		for(int i = 0, flag = 0; i < heightSortedIndex.length; i++){
			buffer[heightSortedIndex[i]]++;
			buffer[weightSortedIndex[i]]++;
			Plate hPlate = null;
			Plate wPlate = null;
			
			if(buffer[heightSortedIndex[i]] == 2)
				hPlate = plates[heightSortedIndex[i]];
			if (buffer[weightSortedIndex[i]] == 2)
				wPlate = plates[weightSortedIndex[i]];
			
			if(hPlate != null && wPlate != null){
				
			}
			
			
			
		
		}
		
		for(Plate p: sortedTower){
			if(p != null)
				System.out.println(p.height + " " + p.weight);
		}
		
		
	}
	
	
	//return the index array of the the plates according to mergeHeight and mergeWeight
	public static int[] mergeSort(Plate[] plates, int pre, int after, boolean bMergeHeight){
		if(pre == after)
			return new int[]{pre};
		int mid = (pre + after) / 2;
		int[] prePlates = mergeSort(plates,pre,mid,bMergeHeight);
		int[] afterPlates = mergeSort(plates,mid + 1, after, bMergeHeight);
		int[] newPlates = new int[prePlates.length + afterPlates.length];
		
		for(int i = 0, j = 0, k = 0; k < newPlates.length; k++){
			if(i < prePlates.length && j < afterPlates.length){
				if(bMergeHeight == true && plates[prePlates[i]].height < plates[afterPlates[j]].height)
					newPlates[k] = prePlates[i++];
				else if(bMergeHeight == false && plates[prePlates[i]].weight < plates[afterPlates[j]].weight)
					newPlates[k] = prePlates[i++];
				else
					newPlates[k] = afterPlates[j++];
			}else if (i >= prePlates.length)
				newPlates[k] = afterPlates[j++];
			else
				newPlates[k] = prePlates[i++];
		}
		return newPlates;
	}
	
	public static void getBiggestTower(){
		
	}
	
	
}

class Plate{
	int height;
	int weight;
	public Plate(int height, int weight){
		this.height = height;
		this.weight = weight;
	}
}
