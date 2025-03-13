package tasks;

import interactions.DeleteRequest;
import interactions.GetRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeServiceGet implements Task {
    private  String recurso;


    public ConsumeServiceGet conService(String recurso) {
        this.recurso = recurso;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GetRequest.recurso(recurso)
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()
                        )
        );
    }

    public static ConsumeServiceGet hacerConsumoGet() {
        return instrumented(ConsumeServiceGet.class);
    }
}