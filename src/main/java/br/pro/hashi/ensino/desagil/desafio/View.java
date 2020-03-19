package br.pro.hashi.ensino.desagil.desafio;

import br.pro.hashi.ensino.desagil.desafio.model.Board;
import br.pro.hashi.ensino.desagil.desafio.model.Element;
import br.pro.hashi.ensino.desagil.desafio.model.Model;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.HashMap;

// Estender a classe JPanel e reescrever o método
// paintComponent é um jeito tradicional de criar
// uma componente cujo visual você mesmo inventa.
public class View extends JPanel {

    // Constante que representa o tamanho,
    // em pixels, da célula do tabuleiro.
    private static final int CELL_SIZE = 50;

    private final Model model;
    private final HashMap<Element, Image> elementsToImages;

    public View(Model model) {
        this.model = model;

        // Define o tamanho da componente a partir
        // do tamanho do tabuleiro e da constante.
        Board board = model.getBoard();
        int width = board.getNumCols() * CELL_SIZE;
        int height = board.getNumRows() * CELL_SIZE;
        setPreferredSize(new Dimension(width, height));

        // Mapeia cada elemento para sua respectiva imagem.
        elementsToImages = new HashMap<>();
        elementsToImages.put(model.getTarget(), getImage("target.png"));
        elementsToImages.put(model.getHumanPlayer(), getImage("human-player.png"));
        elementsToImages.put(model.getCpuPlayer(), getImage("cpu-player.png"));
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

        // Desenha o alvo e os jogadores.
        for (Element element : elementsToImages.keySet()) {
            int row = element.getRow();
            int col = element.getCol();
            Image image = elementsToImages.get(element);
            g.drawImage(image, col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE, this);
        }

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
