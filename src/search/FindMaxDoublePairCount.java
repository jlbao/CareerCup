package search;

import java.util.ArrayList;
import java.util.Arrays;

public class FindMaxDoublePairCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person[] pList = new Person[6];
		pList[0] = new Person(65, 100);
		pList[1] = new Person(70, 150);
		pList[2] = new Person(56, 90);
		pList[3] = new Person(75, 190);
		pList[4] = new Person(60, 95);
		pList[5] = new Person(68, 110);
		
		ArrayList<Person> list = getLargestNumber(pList);
		for(Person p : list){
			System.out.println(p.height + " " + p.weight);
		}
		
	}

	// used a little dp
	public static ArrayList<Person> getLargestNumber(Person[] pList){
		Arrays.sort(pList);
		int[] maxStore = new int[pList.length];
		int[] sequence = new int[pList.length];
		int max = 0;
		int maxIndex = 0;
		for(int i = 0; i < pList.length; i++){
			maxStore[i] = 1;
			sequence[i] = -1;
			for(int j = i - 1; j >= 0; j--){ // go back to find the weight that has the maximum count
				if(pList[j].weight <= pList[i].weight){ 
					if(maxStore[j] + 1 > max){
						maxStore[i] = maxStore[j] + 1;
						sequence[i] = j;
					}
				}
			}
			if(max < maxStore[i]){
				max = maxStore[i];
				maxIndex = i;
			}
		}
		ArrayList<Person> list = new ArrayList<Person>();
		for(int i = maxIndex; i >= 0; i = sequence[i]){
			list.add(pList[i]);
		}
		
		// reverse
		for(int i = 0; i < list.size() / 2; i++){
			Person p = list.get(i);
			list.set(i, list.get(list.size() - 1 - i));
			list.set(list.size() - 1 - i, p);
		}
		return list;
	}
}

class Person implements Comparable<Person>{
	int height;
	int weight;
	public Person(int h, int w){
		this.height = h;
		this.weight = w;
	}
	public int compareTo(Person p){
		if(this.height == p.height){
			return 0;
		}else if(this.height > p.height){
			return 1;
		}else{
			return -1;
		}
	}
}
