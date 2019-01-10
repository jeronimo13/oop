package com.ulya.blackjack.controller;


import com.ulya.blackjack.model.Card;
import com.ulya.blackjack.model.WinState;

import java.util.Collections;
import java.util.List;

public class GameController {
    private static GameController controller;

    private GameController() {
        // инициализация переменных тут
    }

    public static GameController getInstance() {
        if (controller == null) {
            controller = new GameController();
        }

        return controller;
    }

    public void newGame() {
        newGame(new Shuffler() {
            @Override
            public void shuffle(List<Card> deck) {
                Collections.shuffle(deck);
            }
        });
    }

    /**
     * Создает новую игру.
     * - перемешивает колоду (используйте для этого shuffler.shuffle(list))
     * - раздает две карты игроку
     * - раздает одну карту диллеру.
     *
     * @param shuffler shuffle interface
     */
    void newGame(Shuffler shuffler) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Метод вызывается когда игрок запрашивает новую карту.
     * - если сумма очков на руках у игрока больше максимума или колода пуста - ничего не делаем
     * - если сумма очков меньше - раздаем игроку одну карту из коллоды.
     *
     * @return true если сумма очков у игрока меньше максимума (или равна) после всех операций и false если больше.
     */
    public boolean requestMore() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public int getCost(List<Card> deck) {
        int cost = 0;
        for (Card d : deck) {
            cost += d.getCost();
        }
        return cost;
    }

    /**
     * Вызывается когда игрок получил все карты и хочет чтобы играло казино (диллер).
     * Сдаем диллеру карты пока у диллера не наберется 17 очков.
     */
    public void requestStop() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Сравниваем руку диллера и руку игрока.
     * Если у игрока больше максимума - возвращаем WinState.LOOSE (игрок проиграл)
     * Если у игрока меньше чем у диллера и у диллера не перебор - возвращаем WinState.LOOSE (игрок проиграл)
     * Если очки равны - это пуш (WinState.PUSH)
     * Если у игрока больше чем у диллера и не перебор - это WinState.WIN (игрок выиграл).
     */
    public WinState getWinState() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Возвращаем руку игрока
     */
    public List<Card> getMyHand() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Возвращаем руку диллера
     */
    public List<Card> getDealersHand() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
