package com.lld.tictactoe;

import com.lld.tictactoe.enums.PieceType;
import com.lld.tictactoe.models.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    public void initializeGame() {
        players = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player1", crossPiece);

        PlayingPieceO noughtsPiece = new PlayingPieceO();
        Player player2 = new Player("Player2", noughtsPiece);

        players.add(player1);
        players.add(player2);

        gameBoard = new Board(3);
    }

    // Helper classes because I used crossPiece/noughtsPiece in the previous turn's thought but didn't write them yet
    private static class PlayingPieceX extends PlayingPiece { public PlayingPieceX() { super(PieceType.X); } }
    private static class PlayingPieceO extends PlayingPiece { public PlayingPieceO() { super(PieceType.O); } }

    public String startGame() {
        boolean noWinner = true;
        System.out.println("Game Started!");
        Scanner inputScanner = new Scanner(System.in);
        while (noWinner) {
            Player playerTurn = players.removeFirst();
            gameBoard.printBoard();
            List<int[]> freeSpaces = gameBoard.getFreeCells();
            if (freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            System.out.print("Player: " + playerTurn.name + " Enter row,column: ");
            if (!inputScanner.hasNextLine()) {
                System.out.println("No more input found in input.txt. Game ending.");
                return "incomplete";
            }
            String s = inputScanner.nextLine().trim();
            if (s.isEmpty()) continue;
            String[] values = s.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputCol = Integer.parseInt(values[1]);

            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow, inputCol, playerTurn.piece);
            if (!pieceAddedSuccessfully) {
                System.out.println("Incorrect position, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow, inputCol, playerTurn.piece.type);
            if (winner) {
                return playerTurn.name;
            }
        }
        return "tie";
    }

    public boolean isThereWinner(int row, int column, PieceType pieceType) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // Check row
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[row][i] == null || gameBoard.board[row][i].type != pieceType) {
                rowMatch = false;
                break;
            }
        }

        // Check column
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][column] == null || gameBoard.board[i][column].type != pieceType) {
                columnMatch = false;
                break;
            }
        }

        // Check diagonal
        for (int i = 0, j = 0; i < gameBoard.size; i++, j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].type != pieceType) {
                diagonalMatch = false;
                break;
            }
        }

        // Check anti-diagonal
        for (int i = 0, j = gameBoard.size - 1; i < gameBoard.size; i++, j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].type != pieceType) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

    public static void main(String[] args) {
        com.lld.common.FileIO.setup();
        TicTacToeGame game = new TicTacToeGame();
        game.initializeGame();
        System.out.println("Game winner is: " + game.startGame());
    }
}
