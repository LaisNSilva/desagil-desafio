package br.pro.hashi.ensino.desagil.desafio.model;

public class Model {
    private Board board;
    private Element target;
    private HumanPlayer humanPlayer;
    private CpuPlayer cpuPlayer;

    public Model() {
        board = new Board("board.txt");

        target = new Element(4, 14);

        humanPlayer = new HumanPlayer(0, 0, board);

        cpuPlayer = new CpuPlayer(8, 18, board);
    }

    public Board getBoard() {
        return board;
    }

    public Element getTarget() {
        return target;
    }

    public HumanPlayer getHumanPlayer() {
        return humanPlayer;
    }

    public CpuPlayer getCpuPlayer() {
        return cpuPlayer;
    }
}
