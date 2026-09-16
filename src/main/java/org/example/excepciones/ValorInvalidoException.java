package org.example.excepciones;

public class ValorInvalidoException extends RuntimeException {
    public ValorInvalidoException(String s) {
        super(s);
    }
}
