package co.udea.ssmu.api.controller.taxi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@RestController
@RequestMapping("/taxiapp")
public class TaxiController {

    private final SimpMessagingTemplate template;

    public TaxiController(SimpMessagingTemplate template) {
        this.template = template;
    }

    /**
     * Envía las coordenadas de un taxi al destino "/taxi/coordenada".
     *
     * @param coordenada Cadena que representa las coordenadas del taxi.
     */
    @Operation(summary = "Envía las coordenadas de un taxi al destino '/taxi/coordenada'")
    @ApiResponse(responseCode = "200", description = "Coordenadas enviadas correctamente")
    @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    @PostMapping("/send-coordenada")
    public void sendCoordenada(
            @Parameter(description = "Cadena que representa las coordenadas del taxi.", required = true)
            @RequestBody String coordenada) {
        this.template.convertAndSend("/taxi/coordenada", coordenada);
    }
}
