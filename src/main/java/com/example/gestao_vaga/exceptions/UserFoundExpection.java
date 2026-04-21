package com.example.gestao_vaga.exceptions;

public class UserFoundExpection extends RuntimeException {
    public UserFoundExpection() {
        super("Usuário já existe");
    }
}
