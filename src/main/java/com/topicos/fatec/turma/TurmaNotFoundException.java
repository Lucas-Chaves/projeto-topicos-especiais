package com.topicos.fatec.turma;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TurmaNotFoundException extends  RuntimeException {
    public TurmaNotFoundException(String message) {
        super(message);
    }
}

