package co.edu.udea.certificacion.reservasservicios.moduloIngreso.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.edu.udea.certificacion.reservasservicios.moduloIngreso.userinterfaces.GeneralScheduleObjects.*;

public class GeneralScheduleValidation implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(MESSAGE_SCHEDULE).getText();
    }

    public static GeneralScheduleValidation successful() {
        return new GeneralScheduleValidation();
    }
}