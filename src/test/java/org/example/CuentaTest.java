package org.example;

import org.example.excepciones.ValorInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void cuentaValoresCorrectos() {

        Cuenta cuenta = new Cuenta("Cliente1", "Mechiné", "123456", 150);

        assertEquals("Cliente1", cuenta.getNombreCliente());

    }

    @Test
    void saldoNegativo() {
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
    void depositar(){
        Cuenta cuenta = new Cuenta(
                "Cliente1",
                "Mechiné",
                "78784",
                50);
        cuenta.depositar(10);
        assertEquals(60,cuenta.getSaldo());
    }
    @Test
    void depositarCero() {
        assertThrows(ValorInvalidoException.class,
                () -> {
                    Cuenta cuenta = new Cuenta(
                            "Cliente1",
                            "Mechiné",
                            "78784",
                            50);
                    cuenta.depositar(0);
                }
        );

    }

    @Test
    void depositarNegativo() {
        assertThrows(ValorInvalidoException.class,
                () -> {
                    Cuenta cuenta = new Cuenta(
                            "Cliente1",
                            "Mechiné",
                            "78784",
                            50);
                    cuenta.depositar(-5);
                }
        );
    }

    @Test
    void retirar(){
        Cuenta cuenta = new Cuenta(
                "Cliente1",
                "Mechiné",
                "78784",
                50);
        cuenta.retirar(10);
        assertEquals(40,cuenta.getSaldo());
    }

    @Test
    void retirarDeMas() {
        assertThrows(ValorInvalidoException.class,
                () -> {
                    Cuenta cuenta = new Cuenta(
                            "Cliente1",
                            "Mechiné",
                            "78784",
                            50);
                    cuenta.retirar(60);
                }
        );
    }
    @Test
    void retirarNegativo() {
        assertThrows(ValorInvalidoException.class,
                () -> {
                    Cuenta cuenta = new Cuenta(
                            "Cliente1",
                            "Mechiné",
                            "78784",
                            50);
                    cuenta.retirar(-5);
                }
        );
    }
    @Test
    void retirarCero() {
        assertThrows(ValorInvalidoException.class,
                () -> {
                    Cuenta cuenta = new Cuenta(
                            "Cliente1",
                            "Mechiné",
                            "78784",
                            50);
                    cuenta.retirar(0);
                }
        );
    }
}