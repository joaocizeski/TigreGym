package com.example.tigregym.domain.valueobject;

import jakarta.persistence.Embeddable;

@Embeddable
public class Email {

    private String email;

    public Email() {
        this.email = "";
    }

    public Email(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Email Inválido!");
        }

        this.email = email.trim();
    }

    public static boolean isValidEmail(String email) {
        if (email == null || email.isBlank()) {
            return false;
        }

        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    @Override
    public String toString() {
        return email;
    }
}
