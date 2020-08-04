/* Isabelle Friedfeld-Gebaide
 * if2266
 * Game.java
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
	
	private Player p;
	private Deck cards;
	private Scanner s;
	private boolean testHandDone;
	
	public Game(String[] testHand){
		p = new Player();
		for (int i = 0; i<5; i++) {
			String suit = testHand[i].substring(0,1);
			int suitInt =0;
			switch (suit) {
				case "h":
					suitInt = 1;
					break;
				case "s":
					suitInt = 2;
					break;
				case "d":
					suitInt = 3;
					break;
				case "c":
					suitInt = 4;
					break;
			}
			int rank= Integer.parseInt(testHand[i].substring(1));
			p.addCard(new Card (suitInt,rank));
			testHandDone= true;
		}
		cards = new Deck();
		s = new Scanner (System.in);
	}
	
	public Game(){
		// This no-argument constructor is to actually play a normal game
		p = new Player();
		cards = new Deck();
		s = new Scanner (System.in);
		testHandDone = false;
	}
	
	public void play(){
		playCode();
		System.out.println("\nPlay again? True or false");
		boolean again = s.nextBoolean();
		while(p.getBankroll()>0 && again) {
			playCode();
			System.out.println("\nPlay again? True or false");
			again = s.nextBoolean();
		}
		System.out.println("\nNice Game");
	}
    
	public void playCode() {
		System.out.println("Current bankroll: " + p.getBankroll());
		System.out.println("Place your bet (up to 5 tokens and greater than your"
				+ " bankroll)");
		double a = s.nextDouble();
		while((a<0||a>5.0) || a>p.getBankroll()) {
			System.out.println("Bet invalid. Place a bet.");
			a = s.nextDouble();
		}
		p.bets(a);
		if(!testHandDone) {//checking to see if cards are already
			cards.shuffle();
			for (int i = 0; i<5; i++) {//deal cards
				p.changeIndex(i);
				p.addCard(cards.deal());
			}
		}

		System.out.println("This is your hand: " +p.getHand() ) ;
		for (int i = 0; i<5; i++) {//replace cards?
			System.out.println ("Replace this card? "+p.getCard(i)+ 
					"\ntrue or false");
			boolean replace = s.nextBoolean();
			if(replace) {
				p.removeCard(p.getCard(i));
				p.changeIndex(i);
				p.addCard(cards.deal());
				System.out.println("New hand: "+p.getHand());
			}
		}
		System.out.println(checkHand(p.getHand()));//winnings done in checkHand
		System.out.println("Current bankroll: " + p.getBankroll());
		endHand();
	}
	
    public void endHand() {//removes all cards in a hand
		for (int i = 0; i<5; i++) {
			p.removeCard(p.getCard(0));
		}
        testHandDone = false;
	}
	
    public String checkHand(ArrayList<Card> hand){
		// this method should take an ArrayList of cards as input and then 
		// determine what evaluates to and return that as a String
		int[] suit = new int [5];
		int[] rank = new int [5];
		
		for(int i = 0; i<5; i++) {//checking suit
			suit[i]=  p.getCard(i).getSuit();
		}
		
		for(int i = 0; i<5; i++) {//checking rank
			rank[i]= p.getCard(i).getRank();
		}
		
		if(checkRoyFlush(suit,rank)) {
			p.winnings(250);
			return "Royal Flush";
		}else if(checkStrFlush(suit,rank)) {
			p.winnings(50);
			return "Straight Flush";
		}else if(check4Kind(rank)) {
			p.winnings(25);
			return "Four of a kind";
		}else if(checkFullHouse(rank)) {
			p.winnings(6);
			return "Full House";
		}else if(checkFlush(suit)) {
			p.winnings(5);
			return "Flush";
		}else if(checkStr(rank)) {
			p.winnings(4);
			return "Straight";
		}else if(check3K(rank)) {
			p.winnings(3);
			return "Three of a kind";
		}else if (!check4Kind(rank) &&checkPair(rank)==1) {
			p.winnings(2);
			return "Two Pair";
		}else if (checkPair(rank)==0){
			p.winnings(1);
			return "Pair";
		}else {
			p.winnings(0);
			return "No pair";
		}
	}
	
	// types of flushes
	private boolean checkFlush(int[] suit) {
		int check = 0;
		for (int i=1; i<5; i++) {
			if(suit[i-1] == suit[i]) {
				check++;
			}
		}
		return check==4;
	}
	
	private boolean checkStrFlush(int[] suit,int[] rank) {
		boolean check = false;
		if(checkFlush(suit)) {
			Arrays.sort(rank); 
			for (int i = 1; i<5; i++) {
				check = rank[i-1] == rank[i]-1;
			}
		}
		
		return check;
	}

	private boolean checkRoyFlush(int[] suit,int[] rank) {
		boolean check = false;
		if(checkFlush(suit)) {
			Arrays.sort(rank);
			if(rank[0]==1) {
				rank[0]=9;
				check = checkStrFlush(suit,rank);
			}
		}
		return check;
	}
	
	//types of pairs
	private int checkPair(int[] rank) {
		Arrays.sort(rank);
		int check = -1;//-1 == no pair, 0 = 1 pair, 2 = 2 pairs
		for (int i =1; i<5; i++) {
			if (rank[i]==rank[i-1]) {
				check++;
			}
		}
		return check;
	}
	
	private boolean check3K(int[]rank) {
		boolean check = false;
		Arrays.parallelSort(rank);
		if(rank[0]==rank[1]&&rank[0]==rank[2]) {
			check = true;
		}else if(rank[1]==rank[2]&&rank[1]==rank[3]) {
			check = true;
		}else if(rank[2]==rank[3]&&rank[2]==rank[4]) {
			check = true;
		}
		return check;
	}
	
	private boolean check4Kind(int[] rank) {
		boolean check = false;
		Arrays.sort(rank);
		if(checkPair(rank) == 2) {
			if (rank[0]==rank[1]&& rank [1]== rank[2]&& rank[2]==rank[3] ) {
				check = true;
			}else if(rank[1]==rank[2] &&rank [2]== rank[3]&& rank[3]==rank[4]) {
                check = true;
			}
		}
		return check;//if false 2 diff pairs
	}
	
	//misc hands
	private boolean checkStr(int[] rank) {//checking if same rank
		
		int check = 0;
		for (int i=1; i<5; i++) {
			if(rank[i-1] == rank[i]-1)
			check ++;
		}
		return check==4;
	}
	
	private boolean checkFullHouse(int[] rank) {//3 of a kind + a pair
		Arrays.sort(rank);
		return  (checkPair(rank) >=1) && check3K(rank);
	}
	
}
