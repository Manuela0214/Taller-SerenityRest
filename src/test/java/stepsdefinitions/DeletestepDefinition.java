package stepsdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static questions.DeleteQuestion.deleteQuestion;
import static stepsdefinitions.EstablishService.actor;
import static stepsdefinitions.PostStepDefinition.enviaUnaSolicitudPOSTParaConsumirElRecursoConElNombreYElEstado;
import static stepsdefinitions.PostStepDefinition.unUsuarioObtieneLaBaseurlDeLaApi;
import static tasks.ConsumeServiceDelete.hacerConsumoDelete;

public class DeletestepDefinition {
    @Dado("se tiene creada a una mascota")
    public void seTieneCreadaAUnaMascota() {
        unUsuarioObtieneLaBaseurlDeLaApi();
        enviaUnaSolicitudPOSTParaConsumirElRecursoConElNombreYElEstado("pet", "doggie", "available");
    }

    @Cuando("configura la peticion a consumir con el recurso {string} y el id de la mascota creada")
    public void configuraLaPeticionAConsumirConElRecursoYElIdDeLaMascotaCreada(String recurso) {
        String id = SerenityRest.lastResponse().jsonPath().getString("id");
        String recursoFinal = recurso + "/" + id;
        actor.attemptsTo(
                hacerConsumoDelete().conService(recursoFinal)
        );

    }

    @Entonces("valida el estado de dicha peticion")
    public void validaElEstadoDeDichaPeticion() {
        actor.should(
                seeThat("Código respuesta", deleteQuestion(), equalTo(SC_OK))
        );
    }

}

