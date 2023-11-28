package co.udea.ssmu.api.config;


import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SpringDocConfigProperties.class)
public class SwaggerConfig {
    @Bean
    public SpringDocConfigProperties springDocConfigProperties() {
        return new SpringDocConfigProperties();
    }
}
