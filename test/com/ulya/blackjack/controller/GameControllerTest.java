package com.ulya.blackjack.controller;

import com.ulya.blackjack.model.Card;
import com.ulya.blackjack.model.Rank;
import com.ulya.blackjack.model.Suit;
import com.ulya.blackjack.model.WinState;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.Assert.*;

public class GameControllerTest {
	
	@Before
    // &#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd; &#xfffd;&#xfffd;&#xfffd;&#xfffd;, &#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd; &#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd; &#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd; &#xfffd;&#xfffd;&#xfffd; &#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd; &#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd; (&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd; &#xfffd;&#xfffd;&#xfffd; &#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;&#xfffd;)
	public void prepare() throws Exception {
		Field fld = GameController.class.getDeclaredField("controller");
		try {
			fld.setAccessible(true);
			fld.set(null, null);
		} finally {
			fld.setAccessible(false);
		}
	}

	@Test
	public void testGetInstance() {
		assertSame(GameController.getInstance(), GameController.getInstance());
	}
	
	@Test
	public void testBeforeNewGame() {
		assertTrue(GameController.getInstance().getMyHand().isEmpty());
		assertTrue(GameController.getInstance().getDealersHand().isEmpty());
		
		assertEquals(WinState.PUSH, GameController.getInstance().getWinState());
	}
	
	@Test
	public void testAfterNewGame() {
		GameController.getInstance().newGame();
		assertEquals(2, GameController.getInstance().getMyHand().size());
		assertEquals(1, GameController.getInstance().getDealersHand().size());
	}
	
	@Test
	public void testRequestMore() {
		GameController.getInstance().newGame(new Shuffler() {
			@Override
			public void shuffle(List<Card> deck) {
				deck.set(0, new Card(Rank.RANK_7, Suit.SPADES));
				deck.set(1, new Card(Rank.RANK_4, Suit.SPADES));
				deck.set(2, new Card(Rank.RANK_JACK, Suit.SPADES));
				deck.set(2, new Card(Rank.RANK_10,Suit.CLUBS));
                deck.set(4,new Card(Rank.RANK_5,Suit.DIAMONDS));
			}
			
		});
		assertEquals(GameController.getInstance().getMyHand().size(), 2);
		assertEquals(Rank.RANK_7, GameController.getInstance().getMyHand().get(0).getRank());
		assertEquals(Rank.RANK_4, GameController.getInstance().getMyHand().get(1).getRank());
		
		assertEquals(1, GameController.getInstance().getDealersHand().size());
		assertEquals(Rank.RANK_10, GameController.getInstance().getDealersHand().get(0).getRank());
		
		assertEquals(WinState.WIN, GameController.getInstance().getWinState());
		GameController.getInstance().requestMore();
		assertEquals(WinState.WIN, GameController.getInstance().getWinState());
		
       	}
	
	@Test
	public void testRequestStop() {
        GameController.getInstance().newGame(new Shuffler() {

            @Override
            public void shuffle(List<Card> deck) {
                deck.set(0, new Card(Rank.RANK_7, Suit.SPADES));
                deck.set(1, new Card(Rank.RANK_4, Suit.SPADES));
                deck.set(2, new Card(Rank.RANK_JACK, Suit.SPADES));
                deck.set(3, new Card(Rank.RANK_2,Suit.CLUBS));
                deck.set(4,new Card(Rank.RANK_2,Suit.DIAMONDS));
                deck.set(5,new Card(Rank.RANK_3,Suit.DIAMONDS));
                deck.set(6,new Card(Rank.RANK_3,Suit.HEARTS));
            }

        });
        GameController.getInstance().requestStop();
        assertEquals(WinState.LOOSE, GameController.getInstance().getWinState());
	}
}
