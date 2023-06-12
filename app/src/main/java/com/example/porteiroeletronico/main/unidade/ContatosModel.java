package com.example.porteiroeletronico.main.unidade;

public class ContatosModel {

    private String name;
    private String number;

    public ContatosModel(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
