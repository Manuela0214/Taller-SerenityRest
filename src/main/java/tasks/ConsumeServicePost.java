package tasks;
import interactions.PostRequest;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import java.util.Map;

public class ConsumeServicePost implements Task {
    private String recurso;
    private Map<String, Object> cuerpo;

    public ConsumeServicePost conRecursoYCuerpo(String recurso, Map<String, Object> cuerpo) {
        this.recurso = recurso;
        this.cuerpo = cuerpo;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PostRequest.conDatos(recurso, cuerpo)
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .relaxedHTTPSValidation()
                        )
        );
    }

    public static ConsumeServicePost hacerConsumoPost() {
        return instrumented(ConsumeServicePost.class);
    }
}
