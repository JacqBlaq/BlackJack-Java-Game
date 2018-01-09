package blackJack;
/*
 * Jacquelyn Gboyor
 */
public class BlackJackDetails {
	
	/* Declare needed variables.
	 * I am going to need a string array to hold all 52 cards in the deck
	 * and a String array to hold all four suits
	 */
	String [] deck;
	String [] suit;
	
	//Class Constructor
	public BlackJackDetails(String [] gameDeck, String [] gameSuits) {
		deck = gameDeck;
		suit = gameSuits;
	}
	
	public String [] getDeck() {
		return deck;
	}
	
	public String [] getSuits() {
		return suit;
	}

}//End Class
