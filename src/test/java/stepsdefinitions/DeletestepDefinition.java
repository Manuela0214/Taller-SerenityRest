package stepsdefinitions;

import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static questions.DeleteQuestion.deleteQuestion;
import static stepsdefinitions.EstablishService.actor;

public class DeletestepDefinition {
    @Entonces("valida el estado de dicha peticion")
    public void validaElEstadoDeDichaPeticion() {
        actor.should(
                seeThat("Código respuesta", deleteQuestion(), equalTo(SC_OK))
        );
    }
}
