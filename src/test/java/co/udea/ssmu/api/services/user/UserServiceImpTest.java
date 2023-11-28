package co.udea.ssmu.api.services.user;

import static org.junit.jupiter.api.Assertions.*;
import co.udea.ssmu.api.model.jpa.model.Usuario;
import co.udea.ssmu.api.model.jpa.repository.UsuarioRepository;
import co.udea.ssmu.api.services.user.UserServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserServiceImpTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UserServiceImp userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        // Simular un usuario
        Usuario usuario = new Usuario();
        usuario.setId(1L);

        // Configurar el comportamiento del repositorio simulado
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        // Llamar al método que estás probando
        boolean result = userService.createUser(usuario);

        // Verificar que el resultado sea verdadero
        assertTrue(result);

        // Verificar que el método save del repositorio simulado fue llamado
        verify(usuarioRepository).save(usuario);
    }

    @Test
    void testCreateUserException() {
        // Simular un usuario
        Usuario usuario = new Usuario();
        usuario.setId(1L);

        // Configurar el comportamiento del repositorio simulado para lanzar una excepción al guardar
        when(usuarioRepository.save(usuario)).thenThrow(new RuntimeException("Error al guardar"));

        // Llamar al método que estás probando
        boolean result = userService.createUser(usuario);

        // Verificar que el resultado sea falso debido a la excepción
        assertFalse(result);

        // Verificar que el método save del repositorio simulado fue llamado
        verify(usuarioRepository).save(usuario);
    }

    @Test
    void testGetUsers() {
        // Simular una lista de usuarios
        List<Usuario> usuarios = Arrays.asList(new Usuario(), new Usuario());

        // Configurar el comportamiento del repositorio simulado
        when(usuarioRepository.findAll()).thenReturn(usuarios);

        // Llamar al método que estás probando
        List<Usuario> result = userService.getUsers();

        // Verificar que el resultado sea la lista simulada
        assertEquals(usuarios, result);
    }

    @Test
    void testGetUserById() {
        // Simular un usuario con ID 1
        Usuario usuario = new Usuario();
        usuario.setId(1L);

        // Configurar el comportamiento del repositorio simulado
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        // Llamar al método que estás probando
        Usuario result = userService.getUserById(1L);

        // Verificar que el resultado sea el mismo que el usuario simulado
        assertEquals(usuario, result);
    }
}
