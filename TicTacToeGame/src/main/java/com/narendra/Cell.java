package com.narendra;

public class Cell {
    private Symbol symbol;
    public Symbol getSymbol() {
        return symbol;
    }
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol == null? "-" :symbol.toString();
    }
}
