package org.example;

import org.example.excepciones.ValorInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void cuentaValoresCorrectos(){

            Cuenta cuenta = new Cuenta("Cliente1", "Mechiné","123456",150);

            assertEquals("Cliente1", cuenta.getNombreCliente());

    }
    @Test
    void saldoNegativo(){
        assertThrows(
                ValorInvalidoException.class,
                () -> {
                    Cuenta cuenta = new Cuenta(
                            "Cliente1",
                            "Mechiné",
                            "78784",
                            -149);
        });

    }

    @Test
    void depositar() {
    }

    @Test
    void retirar() {
    }
}