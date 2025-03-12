package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

import io.restassured.http.ContentType;
import java.util.Map;

public class PostRequest extends RestInteraction {

    private final String recurso;
    private final Map<String, Object> cuerpo;

    public PostRequest(String recurso, Map<String, Object> cuerpo) {
        this.recurso = recurso;
        this.cuerpo = cuerpo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest()
                .log().all()
                .contentType(ContentType.JSON)
                .body(cuerpo)
                .post(as(actor).resolve(recurso))
                .then().log().all();
    }

    public static PostRequest conDatos(String recurso, Map<String, Object> cuerpo) {
        return instrumented(PostRequest.class, recurso, cuerpo);

    }
}

