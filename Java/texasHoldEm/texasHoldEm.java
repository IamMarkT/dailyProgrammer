import java.io.*;
import java.util.*;

public class texasHoldEm
{
	// Constant values
	public static final int POCKET = 2;
	public static final int COMMUNITY = 5;
	public static final int FLOPDROP = 3;

	// Asks for and returns player count
	public static int startGame()
	{
		Scanner sc = new Scanner(System.in); 

		System.out.println("How many players (2-8)?");
		return sc.nextInt();
	}

	// Draws 3 cards (aka Flop [3/5]), inserts into communityCards. and displays
	public static void getFlop(Stack<Card> deck, Card[] communityCards)
	{
		// Burn card to take out of play
		deckOfCards.drawCard(deck);

		System.out.print("Flop: ");
		for (int i = 0; i < FLOPDROP; i++)
			communityCards[i] = deckOfCards.drawCard(deck);
		displayMultiCards(communityCards, FLOPDROP);
	}

	// Draws next card (aka Turn [4/5]),
	// inserts into communityCards, and displays
	public static void getTurn(Stack<Card> deck, Card[] communityCards)
	{
		// Burn card to take out of play
		deckOfCards.drawCard(deck);

		System.out.print("Turn: ");
		System.out.println(communityCards[3] = deckOfCards.drawCard(deck));
	}

	// Draws final card (aka River [5/5]),
	// inserts into communityCards, and displays
	public static void getRiver(Stack<Card> deck, Card[] communityCards)
	{
		// Burn card to take out of play
		deckOfCards.drawCard(deck);

		System.out.print("River: ");
		System.out.println(communityCards[4] = deckOfCards.drawCard(deck));
	}

	// Displays Cards using commas to seperate
	// Last card creates new line and doesn't get comma.
	public static void displayMultiCards(Card[] cards, int num)
	{
		for(int i = 0; i < num; i++)
		{
			if (i == num - 1)
				System.out.println(cards[i]);
			else
				System.out.print(cards[i] + ", ");
		}
	}

	// Deals cards to all players, then displays all hands.
	public static void dealCards(Stack<Card> deck, int playerNum, Card[][] players)
	{
		// Deals each player one card before dealing second card.
		for(int i = 0; i < POCKET; i++)
			for(int j = 0; j < playerNum; j++)
				players[j][i] = deckOfCards.drawCard(deck);
		
		for(int i = 0; i < playerNum; i++)
		{
			if(i == 0)
				System.out.print("Your Hand: ");
			else
				System.out.print("CPU " + i + " Hand: ");
			displayMultiCards(players[i], POCKET);
		}

		System.out.println();
		System.out.println();
	}

	public static void main(String[] args)
	{

		int playerNum = startGame();
		// 2D array that holds each players pocket cards
		Card players[][] = new Card[playerNum][POCKET];
		// Array that holds the board/community cards
		Card communityCards[] = new Card[COMMUNITY]; 
		Stack<Card> deck = deckOfCards.newDeck();

		// Pre-Flop
		dealCards(deck, playerNum, players);

		// Flop
		getFlop(deck, communityCards);

		// Turn
		getTurn(deck, communityCards);
		
		// River
		getRiver(deck, communityCards);

	}
}
