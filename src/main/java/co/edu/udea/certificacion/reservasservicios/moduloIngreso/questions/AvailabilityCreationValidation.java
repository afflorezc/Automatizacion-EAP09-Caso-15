package co.edu.udea.certificacion.reservasservicios.moduloIngreso.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.edu.udea.certificacion.reservasservicios.moduloIngreso.userinterfaces.ServiceRegistrationObjects.*;

public class AvailabilityCreationValidation implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(MESSAGE_AVAILABILITY).getText();
    }

    public static AvailabilityCreationValidation successful() {
        return new AvailabilityCreationValidation();
    }
}