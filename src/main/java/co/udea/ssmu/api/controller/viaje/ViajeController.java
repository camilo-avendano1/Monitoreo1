package co.udea.ssmu.api.controller.viaje;



import co.udea.ssmu.api.model.jpa.model.Viaje;
import co.udea.ssmu.api.model.jpa.repository.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/viajes")
public class ViajeController {
    @Autowired
    private ViajeRepository viajeRepository;

    @Autowired
    private ViajeRepository ubicacionRepository;


    @PostMapping
    public ResponseEntity<?> crearViaje(@RequestBody Viaje viaje){

        viajeRepository.save(viaje);
        return ResponseEntity.ok(viaje);
    }



    @GetMapping
    public ResponseEntity<?> obtenerViajes(){
        return ResponseEntity.ok(viajeRepository.findAll());
    }


}
