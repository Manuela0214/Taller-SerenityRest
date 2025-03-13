package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class DeleteRequest extends RestInteraction {

    private final String recurso;

    public DeleteRequest(String recurso) {
        this.recurso = recurso;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest()
                .log().all()
                .delete(as(actor).resolve(recurso))
                .then().log().all();
    }

    public static DeleteRequest recurso(String recurso){
        return instrumented(DeleteRequest.class, recurso);
    }
}