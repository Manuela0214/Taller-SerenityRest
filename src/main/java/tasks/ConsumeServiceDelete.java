package tasks;

import interactions.DeleteRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeServiceDelete implements Task {

    private String resource;

    public ConsumeServiceDelete conService(String resource) {
        this.resource = resource;
        return this;
    }

    @Override
    @Step("{0} elimina una mascota")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                DeleteRequest.resource(resource)
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()
                        )
        );
    }

    public static ConsumeServiceDelete makeConsumeDelete() {
        return instrumented(ConsumeServiceDelete.class);
    }
}