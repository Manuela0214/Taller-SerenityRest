package stepsdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class PostStepDefinition {
    @Dado("un usuario obtiene la baseurl de la api")
    public void unUsuarioObtieneLaBaseurlDeLaApi() {
    }

    @Cuando("envia una solicitud POST para consumir el recurso {string} con el nombre {string} y el estado {string}")
    public void enviaUnaSolicitudPOSTParaConsumirElRecursoConElNombreYElEstado(String arg0, String arg1, String arg2) {
    }

    @Entonces("valida el estado de dicha petición")
    public void validaElEstadoDeDichaPetición() {
    }
}
