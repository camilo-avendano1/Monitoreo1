package co.udea.ssmu.api.controller.taxi;

import static org.junit.jupiter.api.Assertions.*;
import co.udea.ssmu.api.controller.taxi.CoordenadaController;
import co.udea.ssmu.api.model.jpa.model.Coordenadas;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CoordenadaControllerTest {

    @InjectMocks
    private CoordenadaController coordenadaController;

    @Test
    void testEnvioCoordenada() throws Exception {
        // Crear una instancia mock de Coordenadas
        Coordenadas coordenadas = mock(Coordenadas.class);

        // Inicializar el controlador y sus dependencias
        coordenadaController = new CoordenadaController();

        // Llamar al método que estás probando
        Coordenadas resultado = coordenadaController.envioCoordenada(coordenadas);

        // Verificar que las coordenadas enviadas son las mismas que las recibidas
        assert coordenadas.equals(resultado);
    }
}
