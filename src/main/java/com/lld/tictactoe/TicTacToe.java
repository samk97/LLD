package com.lld.tictactoe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.lld.tictactoe.models.Player;
import com.lld.tictactoe.models.Board;
import com.lld.tictactoe.utils.Pair;

public class TicTacToe {
    Deque<Player> players;
    Board board;

    public TicTacToe(int size, List<Player> gamePlayers) {
        this.board = new Board(size);
        this.players = new LinkedList<>(gamePlayers);
    }

    public String startGame() {
        boolean winner = false;

        try (Scanner sc = new Scanner(System.in)) {
            while (!winner) {
                Player playerTurn = players.removeFirst();

                board.printBoard();
                List<Pair<Integer, Integer>> freeSpace = board.getFreeSpaces();
                if (freeSpace.isEmpty()) {
                    return "It is a draw";
                }

                System.out.println("Player " + playerTurn.name + ": Enter the row and column number (e.g., 0 1):");
                int row = sc.nextInt();
                int col = sc.nextInt();

                boolean pieceAdded = board.addPiece(row, col, playerTurn.piece);
                if (!pieceAdded) {
                    System.out.println("Incorrect position, try again");
                    players.addFirst(playerTurn);
                    continue;
                }
                players.addLast(playerTurn);

            boolean isWinner = board.isWinner(row, col, playerTurn.piece.symbol);
            if (isWinner) {
                return "Winner is " + playerTurn.name;
            }
        }
        return "Game Over";
    }
}

}
