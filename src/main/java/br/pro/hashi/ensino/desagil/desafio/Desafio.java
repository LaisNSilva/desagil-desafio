package br.pro.hashi.ensino.desagil.desafio;

import java.io.IOException;

public class Desafio {

    // Ignore o "throws IOException" por enquanto.
    // Esse trecho será explicado em aulas futuras.
    public static void main(String[] args) throws IOException {
        Board board = new Board();
        board.load("board.txt");
        for (int i = 0; i < board.numRows; i++) {
            for (int j = 0; j < board.numCols; j++) {
                if (board.wall[i][j]) {
                    System.out.print('#');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }

        Target target = new Target(4, 14);
        System.out.println("Target: " + target.getRow() + ", " + target.getCol());

        Player humanPlayer = new Player();
        humanPlayer.row = 0;
        humanPlayer.col = 0;
        humanPlayer.board = board;
        System.out.println("Human: " + humanPlayer.row + ", " + humanPlayer.col);

        Player cpuPlayer = new Player();
        cpuPlayer.row = 8;
        cpuPlayer.col = 18;
        cpuPlayer.board = board;
        System.out.println("Cpu: " + cpuPlayer.row + ", " + cpuPlayer.col);
    }
}
