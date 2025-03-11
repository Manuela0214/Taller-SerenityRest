package stepsdefinitions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static utils.Constants.ACTOR;

public class EstablishService {

    protected static final Actor actor = new Actor(ACTOR);

    protected void establishService(String urlBase){
        actor.can(CallAnApi.at(urlBase));
    }
}
