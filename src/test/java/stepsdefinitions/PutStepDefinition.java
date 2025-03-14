package stepsdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import questions.PutQuestion;
import java.util.List;
import java.util.Map;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static stepsdefinitions.PostStepDefinition.*;
import static tasks.ConsumeServicePut.makeConsumePut;

public class PutStepDefinition extends EstablishService{

    @Dado("se tiene una mascota creada con el recurso {string} nombre {string} y estado {string}")
    public void seTieneUnaMascotaCreadaConElRecursoNombreYEstado(String recurso, String nombre, String estado) {
        unUsuarioObtieneLaBaseurlDeLaApi();
        enviaUnaSolicitudPOSTParaConsumirElRecursoConElNombreYElEstado(recurso, nombre, estado);
    }

    @Cuando("configura la peticion a consumir el recurso {string} con el nombre {string} actualizado")
    public void configuraLaPeticionAConsumirElRecursoConElNombreActualizado(String recurso, String nuevo_nombre) {
        Map<String, Object> cuerpo = Map.of(
                "id", 0,
                "category", Map.of("id", 0, "name", "string"),
                "name", nuevo_nombre,
                "photoUrls", List.of("string"),
                "tags", List.of(Map.of("id", 0, "name", "string")),
                "status", "available"
        );

        actor.attemptsTo(
                makeConsumePut().conService(recurso, cuerpo)
        );
    }

    @Entonces("valida el nombre de la mascota en la respuesta")
    public void validaElNombreDeLaMascotaEnLaRespuesta() {
        actor.should(
                seeThat(PutQuestion.putQuestion(), equalTo("Firulais"))
        );
    }
}
