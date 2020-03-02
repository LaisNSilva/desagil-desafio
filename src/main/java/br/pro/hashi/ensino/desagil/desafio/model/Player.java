package br.pro.hashi.ensino.desagil.desafio.model;

public class Player {
    private int row;
    private int col;
    private Board board;

    public Player(int row, int col, Board board) {
        this.row = row;
        this.col = col;
        this.board = board;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void move(int rowShift, int colShift) {
        row += rowShift;
        col += colShift;
    }
}
