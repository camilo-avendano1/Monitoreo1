package co.udea.ssmu.api.services.driver;

import static org.junit.jupiter.api.Assertions.*;
import co.udea.ssmu.api.model.jpa.model.Conductor;
import co.udea.ssmu.api.model.jpa.repository.ConductorRepository;
import co.udea.ssmu.api.services.driver.DriverServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DriverServiceImpTest {

    @Mock
    private ConductorRepository conductorRepository;

    @InjectMocks
    private DriverServiceImp driverService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetDriverById() {
        // Simular un conductor con ID 1
        Conductor conductor = new Conductor();
        conductor.setId(1L);

        // Configurar el comportamiento del repositorio simulado
        when(conductorRepository.findById(1L)).thenReturn(Optional.of(conductor));

        // Llamar al método que estás probando
        Conductor result = driverService.getDriverById(1L);

        // Verificar que el resultado sea el mismo que el conductor simulado
        assertEquals(conductor, result);
    }

    @Test
    void testCreateDriver() {
        // Simular un conductor
        Conductor conductor = new Conductor();
        conductor.setId(1L);

        // Configurar el comportamiento del repositorio simulado
        when(conductorRepository.save(conductor)).thenReturn(conductor);

        // Llamar al método que estás probando
        Conductor result = driverService.createDriver(conductor);

        // Verificar que el resultado sea el mismo que el conductor simulado
        assertEquals(conductor, result);

        // Verificar que el método save del repositorio simulado fue llamado
        verify(conductorRepository).save(conductor);
    }

    @Test
    void testCreateDriverException() {
        // Simular un conductor
        Conductor conductor = new Conductor();
        conductor.setId(1L);

        // Configurar el comportamiento del repositorio simulado para lanzar una excepción al guardar
        when(conductorRepository.save(conductor)).thenThrow(new RuntimeException("Error al guardar"));

        // Llamar al método que estás probando
        Conductor result = driverService.createDriver(conductor);

        // Verificar que el resultado sea nulo debido a la excepción
        assertNull(result);

        // Verificar que el método save del repositorio simulado fue llamado
        verify(conductorRepository).save(conductor);
    }
}
