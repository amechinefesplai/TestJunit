package org.example;

import org.example.excepciones.ConstruccionCuentaException;
import org.example.excepciones.ValorInvalidoException;

import java.util.Objects;

/**
 * Representa una cuenta bancaria con datos del cliente y saldo disponible.
 */
public class Cuenta {
    private String nombreCliente;
    private String apellidoCliente;
    private String numero;
    private long saldo;

    public Cuenta(
            String nombreCliente,
            String apellidoCliente,
            String numero,
            long saldo
    ) {
        this.validarValoresContructor(nombreCliente, apellidoCliente, numero, saldo);
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.numero = numero;
        this.saldo = saldo;
    }

    private void validarValoresContructor(
            String nombreCliente,
            String apellidoCliente,
            String numero,
            long saldo
    ) throws ConstruccionCuentaException, ValorInvalidoException {
        if (saldo < 0) {
            throw new ValorInvalidoException("El saldo es negativo");
        }

        if (Objects.isNull(nombreCliente) || nombreCliente.isBlank()) {
            throw new ConstruccionCuentaException("Nombre cliente es requerido");
        }

        if (Objects.isNull(apellidoCliente) || apellidoCliente.isBlank()) {
            throw new ConstruccionCuentaException("Apellido cliente es requerido");
        }

        if (Objects.isNull(numero) || numero.isBlank()) {
            throw new ConstruccionCuentaException("Apellido cliente es requerido");
        }
    }

    public void depositar(long valor) {
        if (valor <= 0) {
            throw new ValorInvalidoException("El valor a depositar es negativo");
        }
        this.saldo += valor; //this.saldo = this.saldo + valor;
    }

    public void retirar(long valor) {
        if (valor > this.saldo) {
            throw new ValorInvalidoException("El valor a retirar no puede ser mayor al saldo de tu cuenta");
        }

        if (valor < 0) {
            throw new ValorInvalidoException("El valor a retirar no puede ser negativo");
        }else if(valor == 0)   {
            throw new ValorInvalidoException("El valor a retirar no puede ser cero");
        }


        this.saldo -= valor;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public String getNumero() {
        return numero;
    }

    public long getSaldo() {
        return saldo;
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
