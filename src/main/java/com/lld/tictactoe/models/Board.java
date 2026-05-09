package com.lld.tictactoe.models;

import java.util.List;

import com.lld.tictactoe.utils.Pair;

public class Board {
    public int size;
    public Cell[][] board;
    
    // Tracking counts for O(1) winner check
    private java.util.Map<String, Integer>[] rowCounts;
    private java.util.Map<String, Integer>[] colCounts;
    private java.util.Map<String, Integer> diagCount;
    private java.util.Map<String, Integer> antiDiagCount;

    @SuppressWarnings("unchecked")
    public Board(int size) {
        this.size = size;
        board = new Cell[size][size];
        
        rowCounts = new java.util.HashMap[size];
        colCounts = new java.util.HashMap[size];
        for (int i = 0; i < size; i++) {
            rowCounts[i] = new java.util.HashMap<>();
            colCounts[i] = new java.util.HashMap<>();
        }
        diagCount = new java.util.HashMap<>();
        antiDiagCount = new java.util.HashMap<>();

        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public List<Pair<Integer, Integer>> getFreeSpaces() {
        List<Pair<Integer, Integer>> freeSpaces = new java.util.ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].piece == null) {
                    Pair<Integer, Integer> rowColumn = new Pair<>(i, j);
                    freeSpaces.add(rowColumn);
                }
            }
        }
        return freeSpaces;
    }

    public boolean addPiece(int row, int col, PlayingPiece piece) {
        if (row < 0 || row >= size || col < 0 || col >= size || board[row][col].piece != null) {
            return false;
        }
        board[row][col].piece = piece;
        
        // Update counts for O(1) check
        String symbol = piece.symbol;
        rowCounts[row].put(symbol, rowCounts[row].getOrDefault(symbol, 0) + 1);
        colCounts[col].put(symbol, colCounts[col].getOrDefault(symbol, 0) + 1);
        
        if (row == col) {
            diagCount.put(symbol, diagCount.getOrDefault(symbol, 0) + 1);
        }
        if (row + col == size - 1) {
            antiDiagCount.put(symbol, antiDiagCount.getOrDefault(symbol, 0) + 1);
        }
        
        return true;
    }

    public boolean isWinner(int row, int col, String symbol) {
        return rowCounts[row].getOrDefault(symbol, 0) == size ||
               colCounts[col].getOrDefault(symbol, 0) == size ||
               diagCount.getOrDefault(symbol, 0) == size ||
               antiDiagCount.getOrDefault(symbol, 0) == size;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].piece == null) {
                    System.out.print("-");
                } else {
                    System.out.print(board[i][j].piece.symbol);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
