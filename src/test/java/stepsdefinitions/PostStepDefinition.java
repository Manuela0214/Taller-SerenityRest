package stepsdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.PostQuestion;
import tasks.ConsumeServicePost;
import java.util.List;
import java.util.Map;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static utils.Constants.BASE_URL;

public class PostStepDefinition extends EstablishService{
    @Dado("un usuario obtiene la baseurl de la api")
    public static void unUsuarioObtieneLaBaseurlDeLaApi() {
        OnStage.setTheStage(new OnlineCast());
        establishService(BASE_URL);
    }

    @Cuando("envia una solicitud POST para consumir el recurso {string} con el nombre {string} y el estado {string}")
    public static void enviaUnaSolicitudPOSTParaConsumirElRecursoConElNombreYElEstado(String recurso, String nombre, String estado) {
        Map<String, Object> cuerpo = Map.of(
                "id", 0,
                "category", Map.of("id", 0, "name", "String"),
                "name", nombre,
                "photoUrls", List.of("https://example.com/image.jpg"),
                "tags", List.of(Map.of("id", 0, "name", "String")),
                "status", estado
        );

        actor.attemptsTo(
                ConsumeServicePost.makeConsumePost()
                        .conService(recurso, cuerpo)
        );
    }

    @Entonces("valida el estado de dicha petición")
    public void validaElEstadoDeDichaPetición() {
        actor.should(
                seeThat("El estado de respuesta: ",
                        PostQuestion.postQuestion(),equalTo(SC_OK))
        );
    }
}
