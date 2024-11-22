package dev.emrx.thanksgiving.infra;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Thanksgiving Shared Dinner API")
                        .description("RESTful API for organizing dishes in a shared Thanksgiving dinner")
                        .contact(new Contact()
                                .name("Development Team")
                        )
                        .version("1.0.0")
                )
                .servers(List.of(
                    new Server().url("http://api.thanksgiving-dinner.com/v1").description("Production server"),
                    new Server().url("http://staging-api.thanksgiving-dinner.com/v1").description("Staging server")
                ));
                // .tags(List.of(
                //     new Tag().name("dishes").description("Operations related to dinner dishes")
                // ));
    }
}
