package stepsdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static questions.GetQuestion.getQuestion;
import static stepsdefinitions.PostStepDefinition.enviaUnaSolicitudPOSTParaConsumirElRecursoConElNombreYElEstado;
import static stepsdefinitions.PostStepDefinition.unUsuarioObtieneLaBaseurlDeLaApi;
import static tasks.ConsumeServiceGet.makeConsumeGet;

public class GetStepDefinition extends EstablishService{

    @Dado("se tiene creada una mascota con el recurso {string} nombre {string} y estado {string}")
    public void seTieneCreadaUnaMascotaConElRecursoNombreYEstado(String recurso, String nombre, String estado) {
        unUsuarioObtieneLaBaseurlDeLaApi();
        enviaUnaSolicitudPOSTParaConsumirElRecursoConElNombreYElEstado(recurso, nombre, estado);
    }

    @Cuando("configura la peticion a consumir con el recurso {string} y el id almacenado")
    public void configuraLaPeticionAConsumirConElRecursoYElIdAlmacenado(String recurso) {
        String id = SerenityRest.lastResponse().jsonPath().getString("id");
        String finalResource = recurso + "/" + id;
        actor.attemptsTo(
                makeConsumeGet().conService(finalResource)
        );
    }

    @Entonces("valida el nombre de la mascota")
    public void validaElNombreDeLaMascota() {
        actor.should(
                seeThat(getQuestion(), equalTo("Romeo"))
        );
    }
}
