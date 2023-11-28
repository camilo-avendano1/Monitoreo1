package co.udea.ssmu.api.controller.taxi;

import co.udea.ssmu.api.model.jpa.model.Coordenadas;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class CoordenadaController {

    /**
     * Envía las coordenadas de un taxi al destino "/taxi/coordenada".
     *
     * @param coordenada Objeto que contiene las coordenadas del taxi.
     * @return Coordenadas del taxi que se enviaron.
     * @throws Exception Excepción que pueda ocurrir durante el procesamiento.
     */
    @Operation(summary = "Envía las coordenadas de un taxi al destino '/taxi/coordenada'")
    @ApiResponse(responseCode = "200", description = "Coordenadas enviadas correctamente")
    @MessageMapping("/taxi")
    @SendTo("/taxi/coordenada")
    public Coordenadas envioCoordenada(
            @Parameter(description = "Objeto que contiene las coordenadas del taxi.", required = true)
            Coordenadas coordenada) throws Exception {
        return coordenada;
    }
}
