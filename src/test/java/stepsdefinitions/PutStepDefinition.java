package stepsdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import questions.PutQuestion;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static stepsdefinitions.EstablishService.actor;
import static tasks.ConsumeServicePut.hacerConsumoPut;

public class PutStepDefinition {

    @Cuando("configura la peticion a consumir el recurso {string} con el nombre {string} actualizado")
    public void configuraLaPeticionAConsumirElRecursoConElNombreActualizado(String recurso, String nombre) {
        Map<String, Object> cuerpo = Map.of(
                "id", 0,
                "category", Map.of("id", 0, "name", "string"),
                "name", nombre,
                "photoUrls", List.of("string"),
                "tags", List.of(Map.of("id", 0, "name", "string")),
                "status", "available"
        );

        actor.attemptsTo(
                hacerConsumoPut().conService(recurso, cuerpo)
        );
    }

    @Entonces("valida el nombre de la mascota en la respuesta")
    public void validaElNombreDeLaMascotaEnLaRespuesta() {
        actor.should(
                seeThat(PutQuestion.putQuestion(), equalTo("firulais"))
        );
    }
}
