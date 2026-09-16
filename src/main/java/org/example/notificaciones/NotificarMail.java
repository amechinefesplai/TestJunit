package org.example.notificaciones;

import org.example.notificaciones.interfaces.Notificacion;

public class NotificarMail implements Notificacion {
    @Override
    public void notificar(String notificacion) {
        System.out.println("Notificacion Mail: \n"+notificacion);
    }
}
