package co.udea.ssmu.api.controller.mensaje;

import co.udea.ssmu.api.model.jpa.model.Mensaje;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MensajeController {

    @MessageMapping("/envio")
    @SendTo("/taxi/mensajes")
    public Mensaje envio(Mensaje mensaje) {
        return new Mensaje(mensaje.nombre(), mensaje.contenido());
    }

}