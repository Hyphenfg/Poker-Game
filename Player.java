/* Isabelle Friedfeld-Gebaide
 * if2266
 * Player.java
 */
import java.util.ArrayList;

public class Player {
	
		
	private ArrayList<Card> hand; // the player's cards
	private double bankroll;
    private double bet;
    private int index;
		
	public Player(){
		hand = new ArrayList<Card>();
		bet = 0.0;
		bankroll= 100.0;
		index = 0;
	}
    
    public void changeIndex(int i) {
		this.index = i;
	}
    
	public void addCard(Card c){// add the card c to the player's hand at index
		hand.add(index,c);
	}

	public void removeCard(Card c){// remove the card c from the player's hand
		hand.remove(hand.indexOf(c));
    }
		
    public void bets(double amt){// player makes a bet
    	bet = amt;
    	bankroll -= bet;
    }

    public void winnings(double odds){// adjust bankroll if player wins
    	bankroll += bet*odds;
    }

    public double getBankroll(){// return current balance of bankroll
    	return bankroll;
    }
    
    public Card getCard(int index) {//returns a card from the arrayList
    	return hand.get(index);
    }
    
    public ArrayList<Card> getHand(){
    	return hand;
    }
    
   
}
