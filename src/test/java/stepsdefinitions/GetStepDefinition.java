package stepsdefinitions;

import interactions.PostRequest;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.GetQuestion;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static questions.GetQuestion.getQuestion;
import static stepsdefinitions.PostStepDefinition.enviaUnaSolicitudPOSTParaConsumirElRecursoConElNombreYElEstado;
import static stepsdefinitions.PostStepDefinition.unUsuarioObtieneLaBaseurlDeLaApi;
import static tasks.ConsumeServiceGet.hacerConsumoGet;

public class GetStepDefinition extends EstablishService{
    @Dado("se tiene creada una mascota")
    public void seTieneCreadaUnaMascota() {
        unUsuarioObtieneLaBaseurlDeLaApi();
        enviaUnaSolicitudPOSTParaConsumirElRecursoConElNombreYElEstado("pet", "romeo", "available");
    }

    @Cuando("configura la peticion a consumir con el recurso {string} y el id almacenado")
    public void configuraLaPeticionAConsumirConElRecursoYElIdAlmacenado(String recurso) {
        String id = SerenityRest.lastResponse().jsonPath().getString("id");
        String recursoFinal = recurso + "/" + id;
        actor.attemptsTo(
                hacerConsumoGet().conService(recursoFinal)
        );
    }

    @Entonces("valida el nombre de la mascota")
    public void validaElNombreDeLaMascota() {
        actor.should(
                seeThat(GetQuestion.getQuestion(), equalTo("romeo"))
        );
    }
}
