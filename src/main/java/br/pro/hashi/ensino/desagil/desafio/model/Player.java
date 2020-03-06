package br.pro.hashi.ensino.desagil.desafio.model;

public class Player extends Element {
    private Board board;

    public Player(int row, int col, Board board) {
        super(row, col);
        this.board = board;
    }

    public void move(int rowShift, int colShift) {
        row += rowShift;
        col += colShift;
    }
}
