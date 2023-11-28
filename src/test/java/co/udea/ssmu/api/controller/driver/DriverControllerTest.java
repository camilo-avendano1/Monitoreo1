package co.udea.ssmu.api.controller.driver;

import static org.junit.jupiter.api.Assertions.*;
import co.udea.ssmu.api.controller.driver.DriverController;
import co.udea.ssmu.api.model.jpa.model.Conductor;
import co.udea.ssmu.api.services.driver.IDriverService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class DriverControllerTest {

    @Mock
    private IDriverService driverService;

    @InjectMocks
    private DriverController driverController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetDriverByIdExistente() {
        // Simular la obtención de un conductor existente
        Conductor conductor = new Conductor();
        when(driverService.getDriverById(1L)).thenReturn(conductor);

        // Llamar al método que estás probando
        ResponseEntity<Conductor> responseEntity = driverController.getDriverById(1L);

        // Verificar que la respuesta sea HttpStatus.OK
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Verificar que el conductor en la respuesta sea el mismo que el simulado
        assertEquals(conductor, responseEntity.getBody());
    }

    @Test
    void testGetDriverByIdNoExistente() {
        // Simular la obtención de un conductor no existente
        when(driverService.getDriverById(1L)).thenReturn(null);

        // Llamar al método que estás probando
        ResponseEntity<Conductor> responseEntity = driverController.getDriverById(1L);

        // Verificar que la respuesta sea HttpStatus.NOT_FOUND
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

        // Verificar que el cuerpo de la respuesta sea nulo
        assertNull(responseEntity.getBody());
    }

    @Test
    void testCreateDriverExitoso() {
        // Simular la creación exitosa de un conductor
        Conductor conductor = new Conductor();
        when(driverService.createDriver(conductor)).thenReturn(conductor);

        // Llamar al método que estás probando
        ResponseEntity<HttpStatus> responseEntity = driverController.createDriver(conductor);

        // Verificar que la respuesta sea HttpStatus.CREATED
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

        // Verificar que el servicio de conductor createDriver fue llamado
        verify(driverService, times(1)).createDriver(conductor);
    }

    @Test
    void testCreateDriverNoExitoso() {
        // Simular la creación no exitosa de un conductor
        Conductor conductor = new Conductor();
        when(driverService.createDriver(conductor)).thenReturn(null);

        // Llamar al método que estás probando
        ResponseEntity<HttpStatus> responseEntity = driverController.createDriver(conductor);

        // Verificar que la respuesta sea HttpStatus.BAD_REQUEST
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        // Verificar que el servicio de conductor createDriver fue llamado
        verify(driverService, times(1)).createDriver(conductor);
    }
}
