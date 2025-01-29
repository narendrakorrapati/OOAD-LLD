package com.narendra;

import java.util.Scanner;

public class Player {
    private static int NUMBER_GENERATOR = 1;
    private final int number;
    private final Symbol symbol;
    private String name;

    public Player(String name) {
        this.name = name;
        this.number = NUMBER_GENERATOR ++;

        if(number == 1) {
            this.symbol = Symbol.X;
        } else {
            this.symbol = Symbol.O;
        }
    }

    public Move makeMove(Scanner scanner) {
        System.out.println("It is " + name + "'s turn now");
        System.out.println("Enter X,Y coordinates");
        String coordinateString = scanner.next();
        String[] coordinates = coordinateString.split(",");
        return new Move(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
    }

    public int getNumber() {
        return number;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name:" + this.name + ", Symbol:" + this.symbol;
    }
}
