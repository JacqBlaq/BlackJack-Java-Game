package blackJack;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JOptionPane;
public class Game {
	
	static String player1 = ""; //Variable to hold player name
	static double player1Bet = 0; //Variable to hold player's bet amount
	
	//Array lists to hold the players cards and the dealers cards
	static ArrayList<String> playerCards = new ArrayList<String>();
	static ArrayList<String> dealerCards = new ArrayList<String>(); 
	
	static String [] gameDeck; //Variable to hold game deck from Deck class
	static int value; //Variable to keep a running total of card values
	static int dealerValue; //Variable to keep a running total of the dealer's card values
	static Object[] aceOptions = {"1", "11"}; //If an Ace is pulled, user can choose for it to equal 1 or 11

	public static void main(String[] args) {
		
		//Declare needed variables
		gameDeck = Deck.getDeck(); //Get deck from Deck class
		int c = 0;
		int valueCount = 0;
		int choice = 0; //Main menu choice variable
		int gameChoice = 0; //Game menu choice variable
		
		do {
			choice = Integer.parseInt(JOptionPane.showInputDialog("Main Menu: "
				+ "\n1. View the rules of Black Jack"
				+ "\n2. Enter Player One name"
				+ "\n3. Play Game"
				+ "\n4. Exit Menu"));
			
			switch (choice) {
			case 1:
				JOptionPane.showMessageDialog(null, "Rules:"
						+ "\n1. This is a one Player game."
						+ "\n2. Player attempts to beat the dealer by getting a count as close to 21 as possible, without going over 21."
						+ "\n3. It is up to the player if an ace is worth 1 or 11."
						+ "\n4. Face cards are 10 and any other card is its pip value."
						+ "\n5. Before the deal begins, player will place a bet."
						+ "\n6. Bets cannot be lower than $2 or higher than $500.");
				break;
			case 2:
				player1 = JOptionPane.showInputDialog("Enter Player 1's Name: ");
				player1 = player1.trim();
				
				//Validation loop to make sure a player name is entered
				while ((player1.equals(""))) {
						player1 = JOptionPane.showInputDialog("Please enter a name for player 1: ");
				}
				//Print out player's name in console
				System.out.println("Player One: " + player1);
				break;
				
			case 3:
				player1Bet = Double.parseDouble(JOptionPane.showInputDialog(player1 + " how much would you like to bet?"
						+ "\n You can only between $2 to $500. "));
				
				//Validation loop to make sure user enters a number between 2 and 500
				while(player1Bet < 2 || player1Bet > 500) {
					player1Bet = Double.parseDouble(JOptionPane.showInputDialog(player1 + " you can only bet between $2 and $500."));
				}
				
				//Turn Deck into list and then shuffle
				List cards = Arrays.asList(gameDeck);
				Collections.shuffle(cards);
				
				
				do {
					gameChoice = Integer.parseInt(JOptionPane.showInputDialog("Make a choice: "
						+ "\n1. Hit me."
						+ "\n2. Show Card."
						+ "\n3. Stand."));
				
					if (gameChoice == 1) {
						dealCardPlayer1(c); //Method to deal out cards
						c++; //increment c
					}else if (gameChoice == 2) {
						System.out.println(playerCards); //Print out player's cards
						value = value + cardValue(playerCards, valueCount); //running total of player's card values
						System.out.println("Value: " + value); //Print out value
						valueCount += 1; //Incremented count to more to next index in array
						
						//If player's value ends up being over 21 they lose and dealer wins
						if (value > 21) {
							JOptionPane.showMessageDialog(
									null, //parentComponent 
									"BUST!"
									+ "\nYou've gone over 21 you lose $" + player1Bet,//message, 
									"Result", 
									JOptionPane.PLAIN_MESSAGE, 
									null);
						}
					}
				} while (gameChoice < 3 && gameChoice > 0);
				break;
			}
		} while (choice > 0 && choice < 4);

	}//End Main
	/**********************************************************/
	private static void dealerCrds(int c) {
		dealerCards.add(gameDeck[c]);
	}
	private static void dealCardPlayer1(int c) {
		//Add new card to array list
		playerCards.add(gameDeck[c]);
		//gameDeck = ArrayUtils.remove(gameDeck, playerCards.get(c));
	}//End Main
	/**********************************************************/

	private static int cardValue(ArrayList<String> dealedCards, int i) {
		/**
		 * This method is meant to get the int value based on the card that's dealt.
		 * Then returns value in order to add to the running total.
		 */
		if (
			(dealedCards.get(i).equals("Ace of Spades")) || 
			(dealedCards.get(i).equals("Ace of Diamonds")) || 
			(dealedCards.get(i).equals("Ace of Hearts")) || 
			(dealedCards.get(i).equals("Ace of Clubs"))) {
			int aceValue = JOptionPane.showOptionDialog(
					null, //component
					"What would you like Ace to equal to?", //message
					"Value of Ace", //title
					JOptionPane.YES_NO_CANCEL_OPTION, //option type
					JOptionPane.QUESTION_MESSAGE, //message type
					null, //icon
					aceOptions, //options
					aceOptions[1]); //initial value
			
			switch (aceValue) {
			case JOptionPane.YES_OPTION:
				value = 1;
				break;
			case JOptionPane.NO_OPTION:
				value = 11;
			default:
				break;
			}
			
		}else if (
				(dealedCards.get(i).equals("2 of Spades")) || 
				(dealedCards.get(i).equals("2 of Diamonds")) || 
				(dealedCards.get(i).equals("2 of Hearts")) || 
				(dealedCards.get(i).equals("2 of Clubs"))
				) {
			value = 2;
		}else if (
				(dealedCards.get(i).equals("3 of Spades")) || 
				(dealedCards.get(i).equals("3 of Diamonds")) || 
				(dealedCards.get(i).equals("3 of Hearts")) || 
				(dealedCards.get(i).equals("3 of Clubs"))
				) {
			value = 3;
		}else if (
				(dealedCards.get(i).equals("4 of Spades")) || 
				(dealedCards.get(i).equals("4 of Diamonds")) || 
				(dealedCards.get(i).equals("4 of Hearts")) || 
				(dealedCards.get(i).equals("4 of Clubs"))
				) {
			value = 4;
		}else if (
				(dealedCards.get(i).equals("5 of Spades")) || 
				(dealedCards.get(i).equals("5 of Diamonds")) || 
				(dealedCards.get(i).equals("5 of Hearts")) || 
				(dealedCards.get(i).equals("5 of Clubs"))
				) {
			value = 5;
		}else if (
				(dealedCards.get(i).equals("6 of Spades")) || 
				(dealedCards.get(i).equals("6 of Diamonds")) || 
				(dealedCards.get(i).equals("6 of Hearts")) || 
				(dealedCards.get(i).equals("6 of Clubs"))
				) {
			value = 6;
		}else if (
				(dealedCards.get(i).equals("7 of Spades")) || 
				(dealedCards.get(i).equals("7 of Diamonds")) || 
				(dealedCards.get(i).equals("7 of Hearts")) || 
				(dealedCards.get(i).equals("7 of Clubs"))
				) {
			value = 7;
		}else if (
				(dealedCards.get(i) == "8 of Spades") || 
				(dealedCards.get(i) == "8 of Diamonds") || 
				(dealedCards.get(i) == "8 of Hearts") || 
				(dealedCards.get(i) == "8 of Clubs")
				) {
			value = 8;
		}else if (
				(dealedCards.get(i).equals("9 of Spades")) || 
				(dealedCards.get(i).equals("9 of Diamonds")) || 
				(dealedCards.get(i).equals("9 of Hearts")) || 
				(dealedCards.get(i).equals("9 of Clubs"))
				) {
			value = 9;
		}else if (
				(dealedCards.get(i).equals("10 of Spades")) || 
				(dealedCards.get(i).equals("10 of Diamonds")) || 
				(dealedCards.get(i).equals("10 of Hearts")) || 
				(dealedCards.get(i).equals("10 of Clubs"))
				) {
			value = 10;
		}else if (
				(dealedCards.get(i).equals("Jack of Spades")) || 
				(dealedCards.get(i).equals("Jack of Diamonds")) || 
				(dealedCards.get(i).equals("Jack of Hearts")) || 
				(dealedCards.get(i).equals("Jack of Clubs"))
				) {
			value = 11;
		}else if (
				(dealedCards.get(i).equals("Queen of Spades")) || 
				(dealedCards.get(i).equals("Queen of Diamonds")) || 
				(dealedCards.get(i).equals("Queen of Hearts")) || 
				(dealedCards.get(i).equals("Queen of Clubs"))
				) {
			value = 12;
		}else if (
				(dealedCards.get(i).equals("King of Spades")) || 
				(dealedCards.get(i).equals("King of Diamonds")) || 
				(dealedCards.get(i).equals("King of Hearts")) || 
				(dealedCards.get(i).equals("King of Clubs"))
				) {
			value = 13;
		}
		
		return value;
	}
	
	

}//End Class
