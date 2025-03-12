package tasks;

import interactions.DeleteRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeServiceDelete implements Task {

    private String recurso;
    private String id;

    public ConsumeServiceDelete conService(String recurso, String id) {
        this.recurso = recurso;
        this.id = id;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                DeleteRequest.recurso(recurso,id)
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()
                        )
        );
    }

    public static ConsumeServiceDelete hacerConsumoDelete() {
        return instrumented(ConsumeServiceDelete.class);
    }
}
