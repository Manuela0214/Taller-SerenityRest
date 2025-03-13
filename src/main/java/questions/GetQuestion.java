package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetQuestion implements Question <String>{

    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().jsonPath().getString("name");
    }
    public static GetQuestion getQuestion(){
        return new GetQuestion();
    }
}