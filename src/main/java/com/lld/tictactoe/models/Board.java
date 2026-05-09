package com.lld.tictactoe.models;

public class Board {
    int size;
    Cell[][] board;

    public Board(int size){
        this.size=size;
        board=new Cell[size][size];

        initializeBoard();
    }

    private void initializeBoard(){
        for(int i=0;i<size();i++){
            for(int j=0;j<size();j++){
                board[i][j]=new Cell();
            }      
        }
    }
}
