package co.udea.ssmu.api.controller.viaje;

import co.udea.ssmu.api.model.jpa.model.Viaje;
import co.udea.ssmu.api.model.jpa.repository.ViajeRepository;
import co.udea.ssmu.api.services.viaje.IViajeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/viajes")
@Tag(name = "Viaje Controller", description = "Operaciones relacionadas con viajes")
public class ViajeController {

    @Autowired
    private IViajeService viajeService;

    @Autowired
    private ViajeRepository ubicacionRepository;

    /**
     * Crea un nuevo viaje.
     *
     * @param viaje El objeto Viaje que representa el nuevo viaje.
     * @return ResponseEntity con el viaje creado y HttpStatus OK.
     */
    @Operation(summary = "Crea un nuevo viaje")
    @ApiResponse(responseCode = "200", description = "Viaje creado exitosamente")
    @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    @PostMapping
    public ResponseEntity<?> crearViaje(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "El objeto Viaje que representa el nuevo viaje.", required = true)
            @RequestBody Viaje viaje) {
        if (viaje == null)
            return ResponseEntity.badRequest().body("No se envió ningún viaje");

        return ResponseEntity.ok(viajeService.crearViaje(viaje));
    }

    /**
     * Obtiene todos los viajes.
     *
     * @return ResponseEntity con la lista de viajes y HttpStatus OK.
     */
    @Operation(summary = "Obtiene todos los viajes")
    @ApiResponse(responseCode = "200", description = "Viajes obtenidos exitosamente")
    @GetMapping
    public ResponseEntity<?> obtenerViajes() {
        return ResponseEntity.ok(viajeService.obtenerViajes());
    }
}
