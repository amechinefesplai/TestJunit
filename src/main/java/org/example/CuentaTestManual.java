package org.example;

import org.example.excepciones.ConstruccionCuentaException;
import org.example.excepciones.ValorInvalidoException;

/**
 * Pruebas básicas de validación de la clase Cuenta.
 */
public class CuentaTestManual {
    /**
     * Ejecuta la batería de pruebas del caso de uso principal.
     */
    static void main() {
        // Casos de validación: flujo normal y errores esperados.
        testHappyPath();
        testSaldoNegativo();
        testNombreVacio();
        testApellidoVacio();
        testNombreNulo();
        testApellidoNulo();
    }

    /**
     * Verifica que una cuenta válida puede crearse con saldo positivo.
     */
    static void testHappyPath(){
        try {
            Cuenta cuenta = new Cuenta("Cliente1", "Mechiné","123456",150);
            System.out.println("Test de happypath ok");
        } catch (Exception e) {
            IO.println("Error en test de happypath");
        }
    }

    /**
     * Verifica que un saldo negativo sea rechazado.
     */
    static void testSaldoNegativo(){

        try {
            Cuenta cuenta = new Cuenta("Cliente1", "Mechiné","78784",-149);
            IO.println("Error de test de saldo negativo");
        } catch (ValorInvalidoException e) {
            IO.println("Test de saldo negativo ok");
        }
    }

    /**
     * Verifica que el nombre vacío no permita crear la cuenta.
     */
    static void testNombreVacio(){

        try {
            Cuenta cuenta = new Cuenta("", "Mechiné","123456",150);
            IO.println("Error test nombre vacio");
        } catch (ConstruccionCuentaException e) {
            IO.println("Test de nombre vacio ok");
        }
    }

    /**
     * Verifica que el apellido vacío no permita crear la cuenta.
     */
    static void testApellidoVacio(){

        try {
            Cuenta cuenta = new Cuenta("Cuenta 1", "","98595",150);
            IO.println("Error test Apellido vacio");
        } catch (ConstruccionCuentaException e) {
            IO.println("Test de Apellido vacio ok");
        }
    }

    static void testNombreNulo(){

        try {
            Cuenta cuenta = new Cuenta(null, "Mechiné","123456",150);
            IO.println("Error test nombre nulo");
        } catch (ConstruccionCuentaException e) {
            IO.println("Test de nombre nulo ok");
        }
    }
    static void testApellidoNulo(){

        try {
            Cuenta cuenta = new Cuenta("Cliente2", null,"123456",150);
            IO.println("Error test apellido nulo");
        } catch (ConstruccionCuentaException e) {
            IO.println("Test de apellido nulo ok");
        }
    }


}
