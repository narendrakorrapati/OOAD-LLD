package com.narendra;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class GameSimulator {

    public static void main(String[] args) {

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Queue<Player> players = new ArrayDeque<>();
        players.offer(player1);
        players.offer(player2);

        Game game = new Game(players);

        game.play();

        System.out.println("Game Status:" + game.getGameStatus() + ", winner:" + game.getWinner());
    }
}
