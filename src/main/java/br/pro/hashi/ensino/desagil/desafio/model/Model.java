package br.pro.hashi.ensino.desagil.desafio.model;

import java.io.IOException;

public class Model {
    private Board board;
    private Element target;
    private Player humanPlayer;
    private Player cpuPlayer;

    // Ignore o "throws IOException" por enquanto.
    // Esse trecho será explicado em aulas futuras.
    public Model() throws IOException {
        board = new Board("board.txt");

        target = new Element(4, 14);

        humanPlayer = new Player(0, 0, board);

        cpuPlayer = new Player(8, 18, board);
    }

    public Board getBoard() {
        return board;
    }

    public Element getTarget() {
        return target;
    }

    public Player getHumanPlayer() {
        return humanPlayer;
    }

    public Player getCpuPlayer() {
        return cpuPlayer;
    }
}
