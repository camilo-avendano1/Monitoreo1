package co.udea.ssmu.api.controller.mensaje;

import co.udea.ssmu.api.model.jpa.model.Mensaje;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

class MensajeControllerTest {

    private MensajeController mensajeController;

    @BeforeEach
    void setUp() {
        // Initialize your controller before each test
        mensajeController = new MensajeController();
    }

    @Test
    void envioTest() {
        // Your test logic here
        Mensaje mensaje = new Mensaje("Nombre", "Contenido");
        mensajeController.envio(mensaje);
        // Add assertions or other test logic as needed
    }
}