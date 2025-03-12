package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PutQuestion implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().jsonPath().getString("name");
    }

    public static PutQuestion putQuestion() {
        return new PutQuestion();
    }
}
