package org.example.excepciones;

public class ConstruccionCuentaException extends RuntimeException {
    public ConstruccionCuentaException(String nombreClienteEsRequerido) {
        super(nombreClienteEsRequerido);
    }
}
