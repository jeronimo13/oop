package com.ulya.blackjack;


import com.ulya.blackjack.view.CommandLineInterface;

public class BlackJack {

	public static void main(String[] args) {
		new CommandLineInterface(System.out, System.in).play();
	}

}