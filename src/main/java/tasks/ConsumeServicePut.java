package tasks;

import interactions.PutRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import java.util.Map;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeServicePut implements Task {

    private String resource;
    private Map<String, Object> body;

    public ConsumeServicePut conService(String resource, Map<String, Object> body) {
        this.resource = resource;
        this.body = body;
        return this;
    }

    @Override
    @Step("{0} actualiza la informacion de una mascota")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PutRequest.resource(resource,body)
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()
                        )
        );
    }

    public static ConsumeServicePut makeConsumePut(){
        return instrumented(ConsumeServicePut.class);
    }
}
