package br.pro.hashi.ensino.desagil.desafio;

import br.pro.hashi.ensino.desagil.desafio.model.Model;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }
}
