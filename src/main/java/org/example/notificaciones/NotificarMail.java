package org.example.notificaciones;

import org.example.notificaciones.interfaces.Notificacion;

/**
 * Implementa la notificación por correo electrónico.
 */
public class NotificarMail implements Notificacion {
    @Override
    public void notificar(String notificacion) {
        System.out.println("Notificacion Mail: \n"+notificacion);
    }
}
