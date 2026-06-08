package co.edu.udea.certificacion.reservasservicios.moduloIngreso.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.edu.udea.certificacion.reservasservicios.moduloIngreso.userinterfaces.BookingObjects.*;

public class LogOutValidation implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(LOGIN_WELCOME_TITLE).getText();
    }

    public static LogOutValidation successful() {
        return new LogOutValidation();
    }
}
