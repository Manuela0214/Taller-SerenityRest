package interactions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.restassured.http.ContentType;
import java.util.Map;

public class PostRequest extends RestInteraction {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostRequest.class);
    private final String recurso;
    private final Map<String, Object> cuerpo;
    public static String petId;

    public PostRequest(String recurso, Map<String, Object> cuerpo) {
        this.recurso = recurso;
        this.cuerpo = cuerpo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("El usuario esta enviando una solicitud POST para consumir el recurso {}", recurso);
        rest()
                .log().all()
                .contentType(ContentType.JSON)
                .body(cuerpo)
                .post(as(actor).resolve(recurso))
                .then().log().all();
        petId = SerenityRest.lastResponse().jsonPath().getString("id");
        LOGGER.info("ID de la mascota guardado correctamente: " + petId);
        LOGGER.debug("Respuesta de la API: {}", SerenityRest.lastResponse().asString());

    }

    public static PostRequest conDatos(String recurso, Map<String, Object> cuerpo) {
        return instrumented(PostRequest.class, recurso, cuerpo);

    }
}

