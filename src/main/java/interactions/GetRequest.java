package interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class GetRequest extends RestInteraction {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetRequest.class);
    private final String resource;

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Iniciando petición GET al recurso: {}", resource);
        rest()
                .log().all()
                .get(as(actor).resolve(resource))
                .then().log().all();
        LOGGER.info(" Petición GET finalizada correctamente.");
        LOGGER.debug("Respuesta de la API: {}", SerenityRest.lastResponse().asString());
    }

    public static GetRequest resource(String resource) {
        return instrumented(GetRequest.class, resource);
    }
}
