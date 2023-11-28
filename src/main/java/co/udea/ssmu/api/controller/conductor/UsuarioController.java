package co.udea.ssmu.api.controller.conductor;

import co.udea.ssmu.api.model.jpa.model.Usuario;
import co.udea.ssmu.api.services.user.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Tag(name = "Usuario Controller", description = "Operaciones relacionadas con usuarios")
public class UsuarioController {

    @Autowired
    private IUserService userService;

    /**
     * Crea un nuevo usuario.
     *
     * @param usuario El objeto Usuario que representa al nuevo usuario.
     * @return ResponseEntity con HttpStatus CREATED si el usuario se crea correctamente, HttpStatus BAD_REQUEST si hay un error.
     */
    @Operation(summary = "Crea un nuevo usuario")
    @ApiResponse(responseCode = "201", description = "Usuario creado exitosamente")
    @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    @PostMapping("/create")
    public ResponseEntity<HttpStatus> crearUsuario(
            @Parameter(description = "El objeto Usuario que representa al nuevo usuario.", required = true)
            @RequestBody Usuario usuario) {
        boolean isCreated = this.userService.createUser(usuario);
        if (isCreated) return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * Obtiene todos los usuarios.
     *
     * @return ResponseEntity con la lista de usuarios y HttpStatus OK.
     */
    @Operation(summary = "Obtiene todos los usuarios")
    @ApiResponse(responseCode = "200", description = "Usuarios obtenidos exitosamente")
    @GetMapping("")
    public ResponseEntity<List<Usuario>> obtenerUsuarios() {
        List<Usuario> usuarios = this.userService.getUsers();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    /**
     * Obtiene un usuario por su identificador.
     *
     * @param id El identificador del usuario.
     * @return ResponseEntity con el usuario y HttpStatus OK si se encuentra, HttpStatus NOT_FOUND si no se encuentra.
     */
    @Operation(summary = "Obtiene un usuario por su identificador")
    @ApiResponse(responseCode = "200", description = "Usuario obtenido exitosamente")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUsuario(
            @Parameter(description = "El identificador del usuario.", required = true)
            @PathVariable Long id) {
        Usuario usuario = this.userService.getUserById(id);
        if (usuario == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
}
