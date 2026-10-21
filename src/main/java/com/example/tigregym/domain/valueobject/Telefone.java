package com.example.tigregym.domain.valueobject;

import jakarta.persistence.Embeddable;

@Embeddable
public class Telefone {

    private String telefone;

    public Telefone() {
        this.telefone = "";
    }

    public Telefone(String telefone) {
        if (!isValidTelefone(telefone)) {
            throw new IllegalArgumentException("Telefone Inválido!");
        }

        this.telefone = telefone.replaceAll("\\D", "");
    }

    public static boolean isValidTelefone(String telefone) {
        if (telefone == null) {
            return false;
        }

        String numeros = telefone.replaceAll("\\D", "");

        return numeros.length() == 10 || numeros.length() == 11;
    }

    @Override
    public String toString() {
        if (telefone.length() == 11) {
            return telefone.replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
        }

        return telefone.replaceAll("(\\d{2})(\\d{4})(\\d{4})", "($1) $2-$3");
    }
}
