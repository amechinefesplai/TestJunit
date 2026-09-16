
import org.example.*;
import org.example.excepciones.ConstruccionCuentaException;
import org.example.excepciones.ValorInvalidoException;
import org.example.notificaciones.interfaces.Notificacion;
import org.example.notificaciones.NotificarMail;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() throws ConstruccionCuentaException, ValorInvalidoException {

    Notificacion tipoNotificacion = new NotificarMail();

    Cuenta origen = new Cuenta(
            "Sandra",
            "Fernandez",
            "010111",
            1000
    );

    Cuenta destino = new Cuenta(
            "Gerardo",
            "Richieri",
            "18909",
            20
    );

    Cajero tobias = new Cajero(tipoNotificacion);
    tobias.transferir(origen, destino, 100);
}
