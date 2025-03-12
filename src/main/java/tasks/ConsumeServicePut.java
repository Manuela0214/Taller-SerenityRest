package tasks;

import interactions.PutRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeServicePut implements Task {

    private String recurso;
    private Map<String, Object> cuerpo;

    public ConsumeServicePut conService(String recurso, Map<String, Object> cuerpo) {
        this.recurso = recurso;
        this.cuerpo = cuerpo;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PutRequest.recurso(recurso,cuerpo)
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()
                        )
        );
    }

    public static ConsumeServicePut hacerConsumoPut(){
        return instrumented(ConsumeServicePut.class);
    }
}
