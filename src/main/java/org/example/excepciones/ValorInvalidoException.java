package org.example.excepciones;

/**
 * Se lanza cuando se intenta usar un valor fuera de los límites permitidos.
 */
public class ValorInvalidoException extends RuntimeException {
    public ValorInvalidoException(String s) {
        super(s);
    }
}
