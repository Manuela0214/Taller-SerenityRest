package tasks;

import interactions.DeleteRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeServiceDelete implements Task {

    private String recurso;

    public ConsumeServiceDelete conService(String recurso) {
        this.recurso = recurso;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                DeleteRequest.recurso(recurso)
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