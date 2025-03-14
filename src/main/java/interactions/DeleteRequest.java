package interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

@AllArgsConstructor
public class DeleteRequest extends RestInteraction {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteRequest.class);
    private final String resource;

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest()
                .log().all()
                .delete(as(actor).resolve(resource))
                .then().log().all();
        LOGGER.debug("Respuesta de la API: {}", SerenityRest.lastResponse().asString());
    }

    public static DeleteRequest resource(String resource){
        return instrumented(DeleteRequest.class, resource);
    }
}