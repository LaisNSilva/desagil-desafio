package br.pro.hashi.ensino.desagil.desafio.model;

public class CpuPlayer extends Player {
    public CpuPlayer(int row, int col, Board board) {
        super(row, col, board);
    }

    public void move() {
        System.out.println("move");
    }
}
