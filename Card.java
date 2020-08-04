/* Isabelle Friedfeld-Gebaide
 * if2266
 * Card.java
 */
public class Card implements Comparable<Card> {
	private int suit; // use integers 1-4 to encode the suit
	private int rank; // use integers 1-13 to encode the rank

	public Card(int s, int r) {
		// make a card with suit s and value v
		if(suit>-1 && suit<5) {
			this.suit = s;
		}if(rank>-1 && rank<14) {
			this.rank = r;
		}
	}

	public int compareTo(Card c) {
		// use this method to compare cards so they
		// may be easily sorted
		int compared = rank - c.getRank();// pos if c's rank is larger
		return compared; //
	}

	public String toString() {
		String suitStr = "";
	
		switch (suit) {
			case 1:
				suitStr = "Hearts";
				break;
			case 2:
				suitStr = "Spades";
				break;
			case 3:
				suitStr = "Diamonds";
				break;
			case 4:
				suitStr = "Clubs";
				break;
		}
		String rankStr="";
		switch (rank) {
			case 1:
				rankStr = "Ace";
				break;
			case 11:
				rankStr = "Jack";
				break;
			case 12:
				rankStr = "Queen";
				break;
			case 13:
				rankStr = "King";
				break;
			default:
				rankStr= ""+ rank;
		}
		return rankStr + " of " + suitStr;
	}

	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
}