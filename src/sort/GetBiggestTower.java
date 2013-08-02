package sort;

public class GetBiggestTower {


	public static void main(String[] args) {
		Plate[] plates = new Plate[]{new Plate(10,198),
									new Plate(20,90),
									new Plate(30,130),
									new Plate(40,150),
									new Plate(50,115),
									new Plate(78,180),
									new Plate(120,135)};
		
		Plate[] heightSortedPlates = mergeSort(plates,0,plates.length - 1);
		
		int[] max = new int[heightSortedPlates.length];
		
		for(int i = heightSortedPlates.length - 1; i >= 0 ; i--){
			for(int j = i; j < heightSortedPlates.length; j++){
				if(heightSortedPlates[i].weight < heightSortedPlates[j].weight)
					if(max[i] < max[j])
						max[i] = max[j] + 1;
			}
			if(max[i] == 0)
				max[i] = 1;
		}
		
		int maxLen = 0;
		for(int i = 0; i < max.length; i++){
			maxLen = maxLen > max[i] ? maxLen : max[i];
		}
		
		System.out.println(maxLen);
		
		
		/*
		for(Plate p : heightSortedPlates)
			System.out.println(p.height + " " + p.weight);
		*/
		
}
		
	//return the index array of the the plates according to mergeHeight and mergeWeight
	public static Plate[] mergeSort(Plate[] plates, int pre, int after){
		if(pre == after)
			return new Plate[]{plates[pre]};
		int mid = (pre + after) / 2;
		Plate[] prePlates = mergeSort(plates,pre,mid);
		Plate[] afterPlates = mergeSort(plates,mid + 1, after);
		Plate[] newPlates = new Plate[prePlates.length + afterPlates.length];
	
		for(int i = 0, j = 0, k = 0; k < newPlates.length; k++){
			if(i < prePlates.length && j < afterPlates.length){
				if(prePlates[i].height < afterPlates[j].height)
					newPlates[k] = prePlates[i++];
				else
					newPlates[k] = afterPlates[j++];
			}else if(i < prePlates.length)
				newPlates[k] = prePlates[i++];
			else
				newPlates[k] = afterPlates[j++];
		}
	
		return newPlates;
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
