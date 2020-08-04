/* Isabelle Friedfeld-Gebaide
 * if2266
 * Deck.java
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private Card[] cards;
	private int top; // the index of the top of the deck
	
	public Deck(){
		// make a 52 card deck here
		top = 0;
		cards = new Card[52];
			for (int i = 1; i<14; i++) {//hearts
				cards[i-1] = new Card(1,i);//1-12 //hearts
                cards[i+12] = new Card(2,i);//13-26 //spades
                cards[i+25] = new Card(3,i);//27-40 //diamonds
                cards[i+38] = new Card(4,i);//39-52 //clubs
			}
	}
	
	public void shuffle(){
		List<Card> cardList = Arrays.asList(cards);
		Collections.shuffle(cardList);
		cardList.toArray(cards);
		top = 0;//bc deck restart
	}
	
	public Card deal(){// deal the top card in the deck
		top++;
		return cards [top-1];
	}
	
    public String toString() {
        String cardOut ="";
        for(Card item: cards) {
            cardOut += item +"\n";
        }
        return cardOut;
    }
}