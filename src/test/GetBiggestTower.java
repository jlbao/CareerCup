package test;

import java.util.ArrayList;

public class GetBiggestTower {


	public static void main(String[] args) {
		Plate[] plates = new Plate[]{new Plate(100,98),
									new Plate(95,90),
									new Plate(110,102),
									new Plate(50,120),
									new Plate(30,115),
									new Plate(35,110),
									new Plate(120,135)};
		
		Plate[] heightSortedPlates = mergeSort(plates,0,plates.length - 1);
		ArrayList<Plate> currentList = new ArrayList<Plate>();
		ArrayList<Plate> longList = null;
		
		for(Plate p: heightSortedPlates){
			if(currentList.isEmpty() || currentList.get(currentList.size() - 1).weight <= p.weight)
				currentList.add(p);
			else
				currentList = new ArrayList<Plate>();
			
			if(longList == null || currentList.size() < longList.size())
				longList = currentList;
		}
		
		for(Plate p: longList)
			System.out.println(p.height + " " + p.weight);
		
		
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
