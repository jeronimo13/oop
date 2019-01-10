package com.ulya.blackjack.controller;


import com.ulya.blackjack.model.Card;

import java.util.List;

interface Shuffler {
	void shuffle(List<Card> deck);
}
