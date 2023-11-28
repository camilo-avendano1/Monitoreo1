package co.udea.ssmu.api.config;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@Tag(name = "WebSocket Config", description = "Configuración para la comunicación mediante WebSocket de coordenadas " +
        "y chat entre conductor y pasajero")
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Configura el sistema de mensajería de WebSocket.
     *
     * @param registry El registro del sistema de mensajería.
     */
    @Operation(summary = "Configura el sistema de mensajería de WebSocket")
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/taxi");
        registry.setApplicationDestinationPrefixes("/app");
    }

    /**
     * Registra los puntos de conexión Stomp para WebSocket.
     *
     * @param registry El registro de puntos de conexión Stomp.
     */
    @Operation(summary = "Registra los puntos de conexión Stomp para WebSocket")
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket")
                .setAllowedOrigins("*");
    }
}
