package com.ulya.restaurant;

public class Menu {

    private Position[] positions;


    public Menu(Position[] positions) {
        this.positions = positions;
    }

    public Position[] getPositions() {
        return positions;
    }
}
