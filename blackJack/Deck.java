package blackJack;

public class Deck {
	
	private static int i = 0;
	
	// Declare size of each array
	private static String [] deck = new String [52];
	private static String [] suit = {"Hearts", "Spades", "Clubs", "Diamonds"};

	//Create a BlackJackDetails Object to hold each variables values
	static BlackJackDetails gameDetails = new BlackJackDetails(deck, suit);
	
	/* This method will fill up the deck array with each card number and correct suit
	 * Then will return the full deck, which will be called from Game.java
	 */
	public static String [] getDeck() {
		for (int k = 0; k < gameDetails.suit.length; k++) {	
			for (int j = 0; j < 13; j++) {
				if (i == 0 || i == 13 || i == 26 || i == 39) {
					gameDetails.deck[i] = "Ace" + " of " + gameDetails.suit[k];
				}else if (i == 10 || i == 23 || i == 36 || i == 49) {
					gameDetails.deck[i] = "Jack" + " of " + gameDetails.suit[k];
				}else if (i == 11 || i == 24 || i == 37 || i == 50) {
					gameDetails.deck[i] = "Queen" + " of " + gameDetails.suit[k];
				}else if (i == 12 || i == 25 || i == 38 || i == 51) {
					gameDetails.deck[i] = "King" + " of " + gameDetails.suit[k];
				}else {
					gameDetails.deck[i] = (j + 1) + " of " + gameDetails.suit[k];
				}
				i++;
			}
		}
		return gameDetails.deck;
	}//End method

}//End class








