package org.example.excepciones;

/**
 * Se lanza cuando no se cumplen los requisitos para crear una cuenta.
 */
public class ConstruccionCuentaException extends RuntimeException {
    public ConstruccionCuentaException(String nombreClienteEsRequerido) {
        super(nombreClienteEsRequerido);
    }
}
