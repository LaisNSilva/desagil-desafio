package br.pro.hashi.ensino.desagil.desafio;

import br.pro.hashi.ensino.desagil.desafio.model.HumanPlayer;
import br.pro.hashi.ensino.desagil.desafio.model.Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void keyTyped(KeyEvent event) {
        // Neste programa, não é necessário definir o que o controlador
        // faz quando um caractere é digitado, mas implementar KeyListener
        // obriga esse método a existir. Então simplesmente deixamos ele vazio.
    }

    @Override
    public void keyPressed(KeyEvent event) {
        HumanPlayer humanPlayer = model.getHumanPlayer();

        // Caso você tenha esquecido como funciona o switch, veja a explicação no código-fonte do Board.

        // Para agir de acordo com a tecla que foi pressionada, comparamos o key code do evento com as
        // constantes disponíveis na classe KeyEvent. Uma lista de todas as constantes pode ser vista em
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/java/awt/event/KeyEvent.html.
        switch (event.getKeyCode()) {
            case KeyEvent.VK_UP:
                humanPlayer.moveUp();
                break;
            case KeyEvent.VK_RIGHT:
                humanPlayer.moveRight();
                break;
            case KeyEvent.VK_DOWN:
                humanPlayer.moveDown();
                break;
            case KeyEvent.VK_LEFT:
                humanPlayer.moveLeft();
                break;
        }

        view.repaint();
    }

    @Override
    public void keyReleased(KeyEvent event) {
        // Neste programa, não é necessário definir o que o controlador
        // faz quando uma tecla é solta, mas implementar KeyListener
        // obriga esse método a existir. Então deixamos ele vazio.
    }
}
