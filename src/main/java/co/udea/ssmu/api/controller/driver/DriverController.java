package co.udea.ssmu.api.controller.driver;

import co.udea.ssmu.api.model.jpa.model.Conductor;
import co.udea.ssmu.api.services.driver.IDriverService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/driver")
@Tag(name = "Driver Controller", description = "Operaciones relacionadas con conductores")
public class DriverController {

    @Autowired
    private IDriverService driverService;

    /**
     * Obtiene un conductor por su identificador.
     *
     * @param id El identificador del conductor.
     * @return ResponseEntity con el conductor y HttpStatus OK si se encuentra, HttpStatus NOT_FOUND si no se encuentra.
     */
    @Operation(summary = "Obtiene un conductor por su identificador")
    @ApiResponse(responseCode = "200", description = "Conductor obtenido exitosamente")
    @ApiResponse(responseCode = "404", description = "Conductor no encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<Conductor> getDriverById(
            @Parameter(description = "El identificador del conductor.", required = true)
            @PathVariable Long id) {
        Conductor conductor = this.driverService.getDriverById(id);
        if (conductor == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(conductor, HttpStatus.OK);
    }

    /**
     * Crea un nuevo conductor.
     *
     * @param conductor El objeto Conductor que representa al nuevo conductor.
     * @return ResponseEntity con HttpStatus CREATED si el conductor se crea correctamente, HttpStatus BAD_REQUEST si hay un error.
     */
    @Operation(summary = "Crea un nuevo conductor")
    @ApiResponse(responseCode = "201", description = "Conductor creado exitosamente")
    @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createDriver(
            @Parameter(description = "El objeto Conductor que representa al nuevo conductor.", required = true)
            @RequestBody Conductor conductor) {
        Conductor conductorCreated = this.driverService.createDriver(conductor);
        if (conductorCreated == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
