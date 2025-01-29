package com.narendra;

import java.util.Arrays;

public class Grid {
    private final Cell[][] cells;
    private int movesCount;
    public Grid() {
        this.cells = new Cell[3][3];
        initializeGrid();
    }
    private void initializeGrid() {
        for(int i = 0; i < cells.length; i ++) {
            for(int j = 0; j < cells.length; j ++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }
    public void update(Move move, Symbol symbol) {
        if(isOutOfBounds(move.getX(), move.getY())) {
            throw new IllegalArgumentException("Invalid Move:" + move);
        }
        this.cells[move.getX()][move.getY()].setSymbol(symbol);
        movesCount ++;
    }

    private boolean isOutOfBounds(int x, int y) {
        return x < 0 || x > 2 || y < 0 || y > 2;
    }

    public boolean isFull() {
        return movesCount == 9;
    }

    public boolean isWinner(Symbol symbol) {
        for(int i = 0; i < cells.length; i ++) {
            if(checkRow(i, symbol) || checkColum(i, symbol)) {
                return true;
            }
        }

        return checkDiagonal(symbol) || checkAntiDiagonal(symbol);
    }

    private boolean checkAntiDiagonal(Symbol symbol) {
        for(int i = 0; i < cells.length; i ++) {
            if(cells[i][cells.length -1 - i].getSymbol() != symbol) {
                return false;
            }
        }

        return true;
    }

    private boolean checkDiagonal(Symbol symbol) {
        for(int i = 0; i < cells.length; i ++) {
            if(cells[i][i].getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColum(int column, Symbol symbol) {
        for(int row = 0; row < cells.length; row ++) {
            if(cells[row][column].getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRow(int row, Symbol symbol) {
        for(int col = 0; col < cells.length; col ++) {
            if(cells[row][col].getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        for(Cell[] cell : cells) {
            System.out.println(Arrays.toString(cell));
        }
    }

    public boolean isValidMove(Move move) {
        return !isOutOfBounds(move.getX(), move.getY()) && getCell(move.getX(), move.getY()).getSymbol() == null;
    }
}
