package com.ulya.blackjack.view;

/**
 * Набор поддерживаемых комманд.
 */
public interface Command {
	String HELP = "help";
	String MORE = "hit";
	String STOP = "stand";
	String EXIT = "exit";
}