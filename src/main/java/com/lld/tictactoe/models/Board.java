package com.lld.tictactoe.models;

import java.util.List;

import com.lld.tictactoe.Pair;

public class Board {
    public int size;
    public Cell[][] board;

    public Board(int size) {
        this.size = size;
        board = new Cell[size][size];

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
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].piece == null) {
                    System.out.print("-");
                } else {
                    System.out.print(board[i][j].piece.type);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
