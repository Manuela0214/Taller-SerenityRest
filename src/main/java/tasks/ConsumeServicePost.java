package tasks;

import interactions.PostRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import java.util.Map;

public class ConsumeServicePost implements Task {
    
    private String resource;
    private Map<String, Object> body;

    public ConsumeServicePost conService(String resource, Map<String, Object> body) {
        this.resource = resource;
        this.body = body;
        return this;
    }

    @Override
    @Step("{0} crea una mascota")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PostRequest.resource(resource, body)
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .relaxedHTTPSValidation()
                        )
        );
    }

    public static ConsumeServicePost makeConsumePost() {
        return instrumented(ConsumeServicePost.class);
    }
}
