package br.pro.hashi.ensino.desagil.desafio;

import br.pro.hashi.ensino.desagil.desafio.model.Board;
import br.pro.hashi.ensino.desagil.desafio.model.Model;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

// Estender a classe JPanel e reescrever o método
// paintComponent é um jeito tradicional de criar
// uma componente cujo visual você mesmo inventa.
public class View extends JPanel {

    // Constante que representa o tamanho,
    // em pixels, da célula do tabuleiro.
    private int CELL_SIZE = 50;

    private Model model;
    private Image targetImage;
    private Image humanPlayerImage;
    private Image cpuPlayerImage;

    public View(Model model) {
        this.model = model;

        // Define o tamanho da componente a partir
        // do tamanho do tabuleiro e da constante.
        Board board = model.getBoard();
        int width = board.getNumCols() * CELL_SIZE;
        int height = board.getNumRows() * CELL_SIZE;
        setPreferredSize(new Dimension(width, height));

        // Carrega a imagem do alvo e dos dois jogadores.
        targetImage = getImage("target.png");
        humanPlayerImage = getImage("human-player.png");
        cpuPlayerImage = getImage("cpu-player.png");
    }

    // Método que desenha a interface gráfica do jogo. A ideia é simples: o objeto g é como
    // um pincel que desenha o que você mandar ele desenhar. Para saber o que é possível, veja
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/java/awt/Graphics.html.
    // Você nunca deve chamar esse método diretamente. O certo é chamar o método repaint.
    @Override
    public void paintComponent(Graphics g) {

        // Desenha as células do tabuleiro.
        Board board = model.getBoard();
        for (int i = 0; i < board.getNumRows(); i++) {
            for (int j = 0; j < board.getNumCols(); j++) {
                if (board.isWall(i, j)) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }

        int row;
        int col;

        row = model.getTarget().getRow();
        col = model.getTarget().getCol();
        g.drawImage(targetImage, col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE, this);

        row = model.getHumanPlayer().getRow();
        col = model.getHumanPlayer().getCol();
        g.drawImage(humanPlayerImage, col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE, this);

        row = model.getCpuPlayer().getRow();
        col = model.getCpuPlayer().getCol();
        g.drawImage(cpuPlayerImage, col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE, this);

        // Linha necessária para evitar atrasos
        // de renderização em sistemas Linux.
        getToolkit().sync();
    }

    // Método de conveniência que carrega uma imagem a partir de um nome
    // de arquivo. Estamos supondo que o arquivo está na pasta de recursos.
    private Image getImage(String name) {
        URL url = getClass().getClassLoader().getResource(name);
        return getToolkit().getImage(url);
    }
}
