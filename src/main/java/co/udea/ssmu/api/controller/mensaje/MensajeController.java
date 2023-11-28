package co.udea.ssmu.api.controller.mensaje;

import co.udea.ssmu.api.model.jpa.model.Mensaje;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MensajeController {

    /**
     * Maneja el mensaje de entrada y lo reenvía a "/taxi/mensajes".
     *
     * @param mensaje El objeto Mensaje que contiene información del mensaje.
     * @return El objeto Mensaje reenviado.
     */
    @Operation(summary = "Maneja el mensaje de entrada y lo reenvía a '/taxi/mensajes'")
    @ApiResponse(responseCode = "200", description = "Mensaje reenviado correctamente")
    @MessageMapping("/envio")
    @SendTo("/taxi/mensajes")
    public Mensaje envio(
            @Parameter(description = "El objeto Mensaje que contiene información del mensaje.", required = true)
            Mensaje mensaje) {
        return new Mensaje(mensaje.nombre(), mensaje.contenido());
    }
}
