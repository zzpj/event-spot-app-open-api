package pl.sii.mentor.openapi;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;

@Configuration
@OpenAPIDefinition
public class OpenApiConfig {

    @Value("${info.app.name}")
    private String appName;
    @Value("${info.app.description}")
    private String appDescription;
    @Value("${info.app.version}")
    private String appVersion;

    @Bean
    public OpenAPI openAPI() {

        Info info = new Info();
        info.setTitle(appName);
        info.setDescription(appDescription);
        info.setVersion(appVersion);

        Contact contact = new Contact();
        contact.name("Zbyszko");
        contact.email("mymail@mail-server.info");
        info.setContact(contact);

        OpenAPI openAPI = new OpenAPI();

        openAPI.setInfo(info);

        return openAPI;
    }
}
