package com.narendra;

import java.util.Queue;
import java.util.Scanner;

public class Game {
    private final Grid grid;
    private final Queue<Player> players;
    private GameStatus gameStatus;
    private Player winner;

    public Game(Queue<Player> players) {
        this.players = players;
        this.grid = new Grid();
        this.gameStatus = GameStatus.IDLE;
    }

    public void play() {
        this.gameStatus = GameStatus.IN_PROGRESS;
        try(Scanner scanner = new Scanner(System.in)) {
            while (this.gameStatus == GameStatus.IN_PROGRESS) {
                Player player = players.poll();
                players.offer(player);

                grid.print();

                Move move = player.makeMove(scanner);

                while (!grid.isValidMove(move)) {
                    System.out.println("Invalid move, enter again");
                    move = player.makeMove(scanner);
                }
                grid.update(move, player.getSymbol());
                updateGameStatusAndWinner(player);
            }
        }

        grid.print();
    }

    private void updateGameStatusAndWinner(Player player) {
        if(grid.isWinner(player.getSymbol())) {
            this.gameStatus = GameStatus.WON;
            this.winner = player;
        } else if(grid.isFull()) {
            this.gameStatus = GameStatus.DRAWN;
        }
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Player getWinner() {
        return winner;
    }
}
