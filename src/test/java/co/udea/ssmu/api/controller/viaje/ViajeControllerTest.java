package co.udea.ssmu.api.controller.viaje;

import static org.junit.jupiter.api.Assertions.*;
import co.udea.ssmu.api.controller.viaje.ViajeController;
import co.udea.ssmu.api.model.jpa.model.Viaje;
import co.udea.ssmu.api.services.viaje.IViajeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ViajeControllerTest {

    @Mock
    private IViajeService viajeService;

    @InjectMocks
    private ViajeController viajeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCrearViajeExitoso() {
        // Simular la creación exitosa de un viaje
        Viaje viaje = new Viaje();
        when(viajeService.crearViaje(viaje)).thenReturn(viaje);

        // Llamar al método que estás probando
        ResponseEntity<?> responseEntity = viajeController.crearViaje(viaje);

        // Verificar que la respuesta sea HttpStatus.OK
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Verificar que el servicio de viaje crearViaje fue llamado
        verify(viajeService, times(1)).crearViaje(viaje);
    }


    @Test
    void testObtenerViajesExitoso() {
        // Simular la obtención exitosa de la lista de viajes
        List<Viaje> viajes = new ArrayList<>();
        when(viajeService.obtenerViajes()).thenReturn(viajes);

        // Llamar al método que estás probando
        ResponseEntity<?> responseEntity = viajeController.obtenerViajes();

        // Verificar que la respuesta sea HttpStatus.OK
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Verificar que el servicio de viaje obtenerViajes fue llamado
        verify(viajeService, times(1)).obtenerViajes();
    }
}
