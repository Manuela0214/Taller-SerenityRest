package stepsdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class PostStepDefinition {
    @Dado("un usuario obtiene la baseurl de la api")
    public void unUsuarioObtieneLaBaseurlDeLaApi() {
        
    }

    @Cuando("envia una solicitud POST para consumir el recurso {string}")
    public void enviaUnaSolicitudPOSTParaConsumirElRecurso(String arg0) {
        
    }

    @Entonces("valida el cuerpo de la peticion con un campo name con el nombre {string}")
    public void validaElCuerpoDeLaPeticionConUnCampoNameConElNombre(String arg0) {
    }
}
