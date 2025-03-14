package interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.restassured.http.ContentType;
import java.util.Map;

@AllArgsConstructor
public class PostRequest extends RestInteraction {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostRequest.class);
    private final String resource;
    private final Map<String, Object> body;
    public static String petId;

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("El usuario esta enviando una solicitud POST para consumir el recurso {}", resource);
        rest()
                .log().all()
                .contentType(ContentType.JSON)
                .body(body)
                .post(as(actor).resolve(resource))
                .then().log().all();
        petId = SerenityRest.lastResponse().jsonPath().getString("id");
        LOGGER.info("ID de la mascota guardado correctamente: " + petId);
        LOGGER.debug("Respuesta de la API: {}", SerenityRest.lastResponse().asString());

    }

    public static PostRequest resource(String resource, Map<String, Object> body) {
        return instrumented(PostRequest.class, resource, body);

    }
}

