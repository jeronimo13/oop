package com.ulya.blackjack.view;


import com.ulya.blackjack.controller.Deck;
import com.ulya.blackjack.controller.GameController;
import com.ulya.blackjack.model.Card;
import com.ulya.blackjack.model.WinState;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class CommandLineInterface {

    private static final String LOSE_MSG = "Sorry, today is not your day. You loose.";
    private static final String PUSH_MSG = "Push. Everybody has equal amount of points.";
    private static final String WIN_MSG = "Congrats! You win!";
    private Scanner scanner;
    private PrintStream output;

    public CommandLineInterface(PrintStream output, InputStream input) {
        this.scanner = new Scanner(input);
        this.output = output;
    }

    public void play() {
        output.println("Console Blackjack application.\n" +
                "Author: (Ulyana Hatsoieva)\n" +
                "(C) 2019\n");

        GameController controller = GameController.getInstance();
        controller.newGame();

        output.println();
        printState(controller);

        while (scanner.hasNext()) {
            String command = scanner.next();
            if (!execute(command, controller)) {
                return;
            }
        }


    }

    /**
     * Выполняем команду, переданную с консоли. Список разрешенных комманд можно найти в классе {@link Command}.
     * Используйте методы контроллера чтобы обращаться к логике игры. Этот класс должен содержать только интерфейс.
     * Если этот метод вернет false - игра завершится.
     * <p/>
     * Более детальное описание формата печати можно узнать посмотрев код юниттестов.
     *
     * @see com.ulya.blackjack.view.CommandLineInterface
     *      <p/>
     *      Описание команд:
     *      Command.HELP - печатает помощь.
     *      Command.MORE - еще одну карту и напечатать Состояние (GameController.requestMore())
     *      если после карты игрок проиграл - напечатать финальное сообщение и выйти
     *      Command.STOP - игрок закончил, теперь играет диллер (GameController.requestStop())
     *      после того как диллер сыграл напечатать:
     *      Dealer turn:
     *      пустая строка
     *      состояние
     *      пустая строка
     *      финальное сообщение
     *      Command.EXIT - выйти из игры
     *      <p/>
     *      Состояние:
     *      рука игрока (total вес)
     *      рука диллера (total вес)
     *      <p/>
     *      например:
     *      3 J 8 (total 21)
     *      A (total 11)
     *      <p/>
     *      Финальное сообщение:
     *      В зависимости от состояния печатаем:
     *      Congrats! You win!
     *      Push. Everybody has equal amount of points.
     *      Sorry, today is not your day. You loose.
     *      <p/>
     *      Постарайтесь уделить внимание чистоте кода и разделите этот метод на несколько подметодов.
     */
    private boolean execute(String command, GameController controller) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private boolean getMore(GameController controller) {
        controller.requestMore();
        printState(controller);
        List<Card> myHand = controller.getMyHand();
        if (Deck.costOf(myHand) > 21) {
            finishMessage(controller);
            return false;
        }
        return true;
    }

    private boolean stop(GameController controller) {
        controller.requestStop();
        output.println("Dealer turn:");
        output.println();
        printState(controller);
        output.println();
        finishMessage(controller);

        return false;
    }

    private void finishMessage(GameController controller) {
        WinState winState = controller.getWinState();
        switch (winState) {
            case WIN:
                output.println(WIN_MSG);
                break;
            case LOOSE:
                output.println(LOSE_MSG);
                break;
            case PUSH:
                output.println(PUSH_MSG);
                break;
        }
    }

    private void getHelp() {
        output.println("Usage: \n" +
                "\thelp - prints this message\n" +
                "\thit - requests one more card\n" +
                "\tstand - I'm done - lets finish\n" +
                "\texit - exits game");
    }

    private void format(List<Card> hand) {
        int total = Deck.costOf(hand);

        for (Card aHand : hand) {
            output.print(aHand.getValues()+" ");
        }
        output.println("(total " + total + ")");

    }

    private void printState(GameController controller) {
        List<Card> myHand = controller.getMyHand();
        format(myHand);
        List<Card> dealersHand = controller.getDealersHand();
        format(dealersHand);
    }

}
