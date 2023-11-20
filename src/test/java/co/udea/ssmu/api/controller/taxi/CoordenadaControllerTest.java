package co.udea.ssmu.api.controller.taxi;

import co.udea.ssmu.api.model.jpa.model.Coordenadas;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@SpringBootTest
class CoordenadaControllerTest {

    @InjectMocks
    private CoordenadaController coordenadaController;

    @Mock
    private SimpMessagingTemplate messagingTemplate;

    @Test
    void envioCoordenadaTest() throws Exception {
        // Create a Coordenadas object for testing
        Coordenadas coordenada = new Coordenadas(1,2);

        // Call the method under test
        coordenadaController.envioCoordenada(coordenada);

        // Assertions
        Mockito.verify(messagingTemplate, Mockito.times(1)).convertAndSend("/taxi/coordenada", coordenada);
    }
}