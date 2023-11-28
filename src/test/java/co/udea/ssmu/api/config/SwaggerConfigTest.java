package co.udea.ssmu.api.config;

import co.udea.ssmu.api.config.SwaggerConfig;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springdoc.core.properties.SpringDocConfigProperties;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SwaggerConfigTest {

    @Test
    void testSwaggerConfig() {
        // Crear una instancia de la clase de configuración
        SwaggerConfig swaggerConfig = new SwaggerConfig();

        // Simular el contexto de la aplicación
        SpringDocConfigProperties springDocConfigProperties = Mockito.mock(SpringDocConfigProperties.class);

        // Configurar cualquier comportamiento específico que necesites para la simulación

        // Llamar al método que estás probando
        SpringDocConfigProperties result = swaggerConfig.springDocConfigProperties();

        // Verificar que el resultado no sea nulo
        assertNotNull(result);

        // Puedes realizar más aserciones según tus necesidades
    }
}
