package org.example;

import org.example.excepciones.ValorInvalidoException;
import org.example.notificaciones.interfaces.Notificacion;

/**
 * Encargado de realizar transferencias entre cuentas y enviar notificaciones.
 */
public class Cajero {
    Notificacion notificar;
    public Cajero (Notificacion tipoNotificacion){
        notificar = tipoNotificacion;
    }

    public void transferir(Cuenta origen, Cuenta destino, long valor) {
        String mensajeNotificacion ="";
        try {
            origen.retirar(valor);
            destino.depositar(valor);
        } catch (ValorInvalidoException e) {
           IO.println(e.getMessage());
        } finally {
        mensajeNotificacion = """
                    Cliente: %s Cuenta: %s  Nuevo Saldo: %s
                    Cliente: %s Cuenta: %s Nuevo Saldo: %s
                    """.formatted(
                origen.getNombreCliente(),
                origen.getNumero(),
                origen.getSaldo(),
                destino.getNombreCliente(),
                destino.getNumero(),
                destino.getSaldo());

            notificar.notificar(mensajeNotificacion);

        }
    }
}
