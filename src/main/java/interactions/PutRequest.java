package interactions;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class PutRequest extends RestInteraction {

    private final String recurso;
    private final Map<String, Object> cuerpo;

    public PutRequest(String recurso, Map<String, Object> cuerpo) {
        this.recurso = recurso;
        this.cuerpo = cuerpo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest()
                .log().all()
                .contentType(ContentType.JSON)
                .body(cuerpo)
                .put(as(actor).resolve(recurso))
                .then().log().all();
    }

    public static PutRequest recurso(String recurso, Map<String, Object> cuerpo) {
        return instrumented(PutRequest.class, recurso, cuerpo);
    }
}
