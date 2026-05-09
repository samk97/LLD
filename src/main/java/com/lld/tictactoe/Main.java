package com.lld.tictactoe;

import com.lld.tictactoe.models.Player;
import com.lld.tictactoe.models.PlayingPiece;

public class Main {

    public static void main(String args[]) {
        int boardSize = 3;

        java.util.List<Player> players = new java.util.ArrayList<>();
        players.add(new Player("PlayerX", new PlayingPiece("X")));
        players.add(new Player("PlayerO", new PlayingPiece("O")));
        players.add(new Player("Player$", new PlayingPiece("$")));

        TicTacToe game = new TicTacToe(boardSize, players);
        System.out.println("Game Winner is : " + game.startGame());
    }

}
