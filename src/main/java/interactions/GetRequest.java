package interactions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetRequest extends RestInteraction {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetRequest.class);
    private final String recurso;

    public GetRequest(String recurso) {
        this.recurso = recurso;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Iniciando petición GET al recurso: {}", recurso);
        rest()
                .log().all()
                .get(as(actor).resolve(recurso))
                .then().log().all();
        LOGGER.info(" Petición GET finalizada correctamente.");
        LOGGER.debug("Respuesta de la API: {}", SerenityRest.lastResponse().asString());
    }

    public static GetRequest recurso(String recurso) {
        return instrumented(GetRequest.class, recurso);
    }
}
