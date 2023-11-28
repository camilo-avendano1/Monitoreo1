package co.udea.ssmu.api.services.viaje;

import static org.junit.jupiter.api.Assertions.*;
import co.udea.ssmu.api.model.jpa.model.Viaje;
import co.udea.ssmu.api.model.jpa.repository.ViajeRepository;
import co.udea.ssmu.api.services.viaje.ViajeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ViajeServiceTest {

    @Mock
    private ViajeRepository viajeRepository;

    @InjectMocks
    private ViajeService viajeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCrearViaje() {
        // Simular un viaje
        Viaje viaje = new Viaje();
        viaje.setId(1L);

        // Configurar el comportamiento del repositorio simulado
        when(viajeRepository.save(viaje)).thenReturn(viaje);

        // Llamar al método que estás probando
        Viaje result = viajeService.crearViaje(viaje);

        // Verificar que el resultado sea el mismo que el viaje simulado
        assertEquals(viaje, result);

        // Verificar que el método save del repositorio simulado fue llamado
        verify(viajeRepository).save(viaje);
    }

    @Test
    void testCrearViajeException() {
        // Simular un viaje
        Viaje viaje = new Viaje();
        viaje.setId(1L);

        // Configurar el comportamiento del repositorio simulado para lanzar una excepción al guardar
        when(viajeRepository.save(viaje)).thenThrow(new RuntimeException("Error al guardar"));

        // Llamar al método que estás probando
        Viaje result = viajeService.crearViaje(viaje);

        // Verificar que el resultado sea nulo debido a la excepción
        assertNull(result);

        // Verificar que el método save del repositorio simulado fue llamado
        verify(viajeRepository).save(viaje);
    }

    @Test
    void testObtenerViajes() {
        // Simular una lista de viajes
        List<Viaje> viajes = Arrays.asList(new Viaje(), new Viaje());

        // Configurar el comportamiento del repositorio simulado
        when(viajeRepository.findAll()).thenReturn(viajes);

        // Llamar al método que estás probando
        List<Viaje> result = viajeService.obtenerViajes();

        // Verificar que el resultado sea la lista simulada
        assertEquals(viajes, result);
    }
}
