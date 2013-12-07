package acre;

import java.util.Random;

public class ShuffleCards {

	/**
	 * Given 52 cards in an array, shuffle the cards
	 */
	public static void main(String[] args) {
		/*
		int[] cards = new int[54];
		for(int i = 0; i < cards.length; i++){
			cards[i] = i;
		}
		
		shuffle(cards);
		for(int i = 0; i < cards.length; i++){
			System.out.print(cards[i] + " ");
		}
		*/
		System.out.println(new Random().nextInt(100));
	}

	public static void shuffle(int[] cards){
		Random rand = new Random();
		for(int i = 0; i < cards.length; i++){
			int index = rand.nextInt(53);
			int tmp = cards[i];
			cards[i] = cards[index];
			cards[index] = tmp;
		}
	}
}
