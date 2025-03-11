package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseBody implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return "";
    }
}
