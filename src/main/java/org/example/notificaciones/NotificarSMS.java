package org.example.notificaciones;

import org.example.notificaciones.interfaces.Notificacion;

/**
 * Implementa la notificación por SMS.
 */
public class NotificarSMS implements Notificacion {
    @Override
    public void notificar(String notificacion) {
        System.out.println("Notificacion SMS: \n"+notificacion);
    }
}
