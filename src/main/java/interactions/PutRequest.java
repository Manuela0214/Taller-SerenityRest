package interactions;

import io.restassured.http.ContentType;
import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import java.util.Map;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class PutRequest extends RestInteraction {

    private static final Logger LOGGER = LoggerFactory.getLogger(PutRequest.class);
    private final String resource;
    private final Map<String, Object> body;

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest()
                .log().all()
                .contentType(ContentType.JSON)
                .body(body)
                .put(as(actor).resolve(resource))
                .then().log().all();
        LOGGER.debug("Respuesta de la API: {}", SerenityRest.lastResponse().asString());
    }

    public static PutRequest resource(String resource, Map<String, Object> body) {
        return instrumented(PutRequest.class, resource, body);
    }
}
