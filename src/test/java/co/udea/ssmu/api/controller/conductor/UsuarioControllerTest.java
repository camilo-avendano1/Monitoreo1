package co.udea.ssmu.api.controller.conductor;

import static org.junit.jupiter.api.Assertions.*;
import co.udea.ssmu.api.controller.conductor.UsuarioController;
import co.udea.ssmu.api.model.jpa.model.Usuario;
import co.udea.ssmu.api.services.user.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class UsuarioControllerTest {

    @Mock
    private IUserService userService;

    @InjectMocks
    private UsuarioController usuarioController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCrearUsuarioExitoso() {
        // Simular la creación exitosa de un usuario
        Usuario usuario = new Usuario();
        when(userService.createUser(usuario)).thenReturn(true);

        // Llamar al método que estás probando
        ResponseEntity<HttpStatus> responseEntity = usuarioController.crearUsuario(usuario);

        // Verificar que la respuesta sea HttpStatus.CREATED
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

        // Verificar que el servicio de usuario createUser fue llamado
        verify(userService, times(1)).createUser(usuario);
    }

    @Test
    void testCrearUsuarioNoExitoso() {
        // Simular la creación no exitosa de un usuario
        Usuario usuario = new Usuario();
        when(userService.createUser(usuario)).thenReturn(false);

        // Llamar al método que estás probando
        ResponseEntity<HttpStatus> responseEntity = usuarioController.crearUsuario(usuario);

        // Verificar que la respuesta sea HttpStatus.BAD_REQUEST
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        // Verificar que el servicio de usuario createUser fue llamado
        verify(userService, times(1)).createUser(usuario);
    }

    @Test
    void testObtenerUsuariosExitoso() {
        // Simular la obtención exitosa de usuarios
        List<Usuario> usuarios = Arrays.asList(new Usuario(), new Usuario());
        when(userService.getUsers()).thenReturn(usuarios);

        // Llamar al método que estás probando
        ResponseEntity<List<Usuario>> responseEntity = usuarioController.obtenerUsuarios();

        // Verificar que la respuesta sea HttpStatus.OK
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Verificar que la lista de usuarios en la respuesta sea la misma que la simulada
        assertEquals(usuarios, responseEntity.getBody());
    }

    @Test
    void testObtenerUsuariosNoExitoso() {
        // Simular la obtención no exitosa de usuarios
        when(userService.getUsers()).thenReturn(null);

        // Llamar al método que estás probando
        ResponseEntity<List<Usuario>> responseEntity = usuarioController.obtenerUsuarios();

        // Verificar que la respuesta sea HttpStatus.OK
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Verificar que la lista de usuarios en la respuesta sea nula
        assertNull(responseEntity.getBody());
    }

    @Test
    void testObtenerUsuarioExistente() {
        // Simular la obtención de un usuario existente
        Usuario usuario = new Usuario();
        when(userService.getUserById(1L)).thenReturn(usuario);

        // Llamar al método que estás probando
        ResponseEntity<?> responseEntity = usuarioController.obtenerUsuario(1L);

        // Verificar que la respuesta sea HttpStatus.OK
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Verificar que el usuario en la respuesta sea el mismo que el simulado
        assertEquals(usuario, responseEntity.getBody());
    }

    @Test
    void testObtenerUsuarioNoExistente() {
        // Simular la obtención de un usuario no existente
        when(userService.getUserById(1L)).thenReturn(null);

        // Llamar al método que estás probando
        ResponseEntity<?> responseEntity = usuarioController.obtenerUsuario(1L);

        // Verificar que la respuesta sea HttpStatus.NOT_FOUND
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

        // Verificar que el cuerpo de la respuesta sea nulo
        assertNull(responseEntity.getBody());
    }
}
