package com.lld.tictactoe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.lld.tictactoe.models.Player;
import com.lld.tictactoe.models.Board;
import com.lld.tictactoe.models.PieceX;
import com.lld.tictactoe.models.PieceO;

public class TicTacToe {
    Deque<Player> players;
    Board board;

    public TicTacToe() {
        initializeGame();
    }

    private void initializeGame() {
        players = new LinkedList<>();
        Player player1 = new Player("PlayerX", new PieceX());
        Player player2 = new Player("PlayerO", new PieceO());
        players.add(player1);
        players.add(player2);

        board = new Board(3);
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

                boolean isWinner = checkWinner(row, col, playerTurn.piece.type);
                if (isWinner) {
                    return "Winner is " + playerTurn.name;
                }
            }
        }
        return "Game Over";
    }

    private boolean checkWinner(int row, int col, com.lld.tictactoe.enums.PieceType type) {
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // Check Row
        for (int i = 0; i < board.size; i++) {
            if (board.board[row][i].piece == null || board.board[row][i].piece.type != type) {
                rowMatch = false;
                break;
            }
        }

        // Check Column
        for (int i = 0; i < board.size; i++) {
            if (board.board[i][col].piece == null || board.board[i][col].piece.type != type) {
                colMatch = false;
                break;
            }
        }

        // Check Diagonal
        for (int i = 0, j = 0; i < board.size; i++, j++) {
            if (board.board[i][j].piece == null || board.board[i][j].piece.type != type) {
                diagonalMatch = false;
                break;
            }
        }

        // Check Anti-Diagonal
        for (int i = 0, j = board.size - 1; i < board.size; i++, j--) {
            if (board.board[i][j].piece == null || board.board[i][j].piece.type != type) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
    }

}
