package org.example.notificaciones;

import org.example.notificaciones.interfaces.Notificacion;

public class NotificarWhatsapp implements Notificacion {
    @Override
    public void notificar(String notificacion) {
        System.out.println("Notificacion Whatsapp: \n" +notificacion);
    }
}
