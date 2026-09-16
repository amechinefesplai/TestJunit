package org.example;

import org.example.notificaciones.NotificarWhatsapp;
import org.example.notificaciones.interfaces.Notificacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CajeroTest {


    @Test
    void transferirCorrecto() {
        //Arrange
        Cajero cajero = new Cajero(new NotificarWhatsapp());
        Cuenta cuenta1 = new Cuenta("Nombre1","Apellido1","1",500 );
        Cuenta cuenta2 = new Cuenta("Nombre2","Apellido2","2",900 );
        //Act
        cajero.transferir(cuenta1, cuenta2, 100);
        //Assert
        assertEquals(cuenta1.getSaldo(), 400);
        assertEquals(cuenta2.getSaldo(), 1000);
    }

    @Test
    void transferirATuMismaCuenta(){

    }

    @Test
    void transferirACuentaInexistente(){

    }
    @Test
    void transferirDesdeCuentaInexistente(){

    }

    @Test
    void transferirACuentaNull(){

    }

    @Test
    void transferirDesdeCuentaNull(){

    }

}