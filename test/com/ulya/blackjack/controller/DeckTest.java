package com.ulya.blackjack.controller;

import com.ulya.blackjack.model.Card;
import com.ulya.blackjack.model.Rank;
import com.ulya.blackjack.model.Suit;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DeckTest {

	@Test
	public void testCreate() {
		assertEquals(52, Deck.createDeck(1).size());
		assertEquals(104, Deck.createDeck(2).size());
		assertEquals(208, Deck.createDeck(4).size());
		assertEquals(52 * 10, Deck.createDeck(10).size());
		
		assertEquals(52 * 10, Deck.createDeck(11).size());
		assertEquals(52, Deck.createDeck(-1).size());
		
		List<Card> deck = Deck.createDeck(2);
		int i = 0;
		
		for (int deckN = 0; deckN < 2; deckN++) {
			for (Suit suit : Suit.values()) {
				for (Rank rank : Rank.values()) {
					assertEquals(suit, deck.get(i).getSuit());
					assertEquals(rank, deck.get(i).getRank());
					assertEquals(rank.getCost(), deck.get(i).getCost());
					i++;
				}
			}
		}
	}
	
	@Test
	public void testCostOf() {
        List<Card> d = Deck.createDeck(1);
        assertEquals(380,Deck.costOf(d));
	}
}
