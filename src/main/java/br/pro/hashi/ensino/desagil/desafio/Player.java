package br.pro.hashi.ensino.desagil.desafio;

public class Player {
    int row;
    int col;

    void move(int rowShift, int colShift) {
        row += rowShift;
        col += colShift;
    }
}
