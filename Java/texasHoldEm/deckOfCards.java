import java.io.*;
import java.util.*;

class Card
{

	public enum Suit
	{
		CLUBS, DIAMONDS, HEARTS, SPADES
	}

	public enum Rank
	{
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN,
			EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	Suit suit;
	Rank rank;

	public Card(Suit suit, Rank rank)
	{
		this.suit = suit;
		this.rank = rank;
	}

	public Suit getSuit()
	{
		return this.suit;
	}

	public Rank getRank()
	{
		return this.rank;
	}

	public String toString()
	{
		return rank + " OF " + suit;
	}

}

public class deckOfCards
{
	// Initialize and shuffle deck of cards.
	public static Stack<Card> newDeck()
	{
		Stack<Card> deck = new Stack<Card>();

		for(Card.Suit suit : Card.Suit.values())
		{
			for(Card.Rank rank : Card.Rank.values())
			{
				Card temp = new Card(suit, rank); 
				deck.push(temp);
			}
		}
		shuffle(deck);
		return deck;
	}

	// draw / rename for call .pop
	public static Card drawCard(Stack<Card> deck)
	{
		return deck.pop();
	}

	public static Stack<Card> shuffle(Stack<Card> deck)
	{
		for(int i = 0; i < 3; i++)
			Collections.shuffle(deck);
		return deck;
	}
}
