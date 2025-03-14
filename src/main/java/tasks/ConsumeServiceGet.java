package tasks;

import interactions.GetRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeServiceGet implements Task {
    
    private String resource;

    public ConsumeServiceGet conService(String resource) {
        this.resource = resource;
        return this;
    }

    @Override
    @Step("{0} obtiene la informacion de una mascota")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GetRequest.resource(resource)
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()
                        )
        );
    }

    public static ConsumeServiceGet makeConsumeGet() {
        return instrumented(ConsumeServiceGet.class);
    }
}