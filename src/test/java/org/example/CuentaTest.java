package org.example;

import org.example.excepciones.ConstruccionCuentaException;
import org.example.excepciones.ValorInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {


    /**
     * Verifica que una cuenta válida puede crearse con saldo positivo.
     */
    @Test
    void cuentaCreadaCorrectamenteConValoresCorrectos() {
        Cuenta cuenta = new Cuenta("Cliente1", "Mechiné", "123456", 150);
        assertEquals("Cliente1", cuenta.getNombreCliente());
        assertEquals("Mechiné", cuenta.getApellidoCliente());
        assertEquals("123456", cuenta.getNumero());
        assertEquals(150, cuenta.getSaldo());

    }

    @Test
    void testNombreVacio() {
        assertThrows(
                ConstruccionCuentaException.class,
                () -> {
                    Cuenta cuenta = new Cuenta("", "Mechiné", "123456", 150);
                });


    }

    @Test
    void testApellidoVacio() {

        assertThrows(
                ConstruccionCuentaException.class,
                () -> {
                    Cuenta cuenta = new Cuenta("Cuenta1", "", "123456", 150);
                });
    }

    @Test
    void testNombreNulo() {

        assertThrows(
                ConstruccionCuentaException.class,
                () -> {
                    Cuenta cuenta = new Cuenta(null, "Mechiné", "123456", 150);
                });
    }

    @Test
    void testApellidoNulo() {

        assertThrows(
                ConstruccionCuentaException.class,
                () -> {
                    Cuenta cuenta = new Cuenta("Cuenta1", null, "123456", 150);
                });
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
    void depositar() {
        //Arrange
        Cuenta cuenta = new Cuenta(
                "Cliente1",
                "Mechiné",
                "78784",
                50);

        //Act
        cuenta.depositar(10);

        //Assert
        assertEquals(60, cuenta.getSaldo());
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
    void retirar() {
        Cuenta cuenta = new Cuenta(
                "Cliente1",
                "Mechiné",
                "78784",
                50);
        cuenta.retirar(10);
        assertEquals(40, cuenta.getSaldo());
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