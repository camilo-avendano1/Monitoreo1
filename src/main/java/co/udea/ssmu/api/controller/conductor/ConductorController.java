package co.udea.ssmu.api.controller.conductor;

import co.udea.ssmu.api.model.jpa.model.Conductor;
import co.udea.ssmu.api.model.jpa.repository.ConductorRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Conductores", description = "Gestión de conductores")
@RestController
@RequestMapping("/api/coductores")
public class ConductorController {
    @Autowired
    private ConductorRepository conductorRepository;
    @GetMapping
    public ResponseEntity<?> crearConductor(){
        Conductor conductor = new Conductor();
        conductor.setId(2L);
        conductor.setNombre("Juan");
        conductor.setApellido("Perez");
        conductor.setCedula("1234567890");
        conductor.setRol("Conductor");
        conductor.setEstado("Activo");

        conductorRepository.save(conductor);
        return ResponseEntity.ok(conductor);
    }

}
