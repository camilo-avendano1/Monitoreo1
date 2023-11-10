package co.udea.ssmu.api.controller.conductor;


import co.udea.ssmu.api.model.jpa.model.Usuario;
import co.udea.ssmu.api.model.jpa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario){

        usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuario);
    }


    @GetMapping
    public ResponseEntity<?> obtenerUsuarios(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUsuario(Long id){
        return ResponseEntity.ok(usuarioRepository.findById(id));
    }
}
