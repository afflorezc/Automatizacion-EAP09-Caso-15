package co.edu.udea.certificacion.reservasservicios.moduloIngreso.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.edu.udea.certificacion.reservasservicios.moduloIngreso.userinterfaces.BookingObjects.*;

public class BookingSuccessValidation implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(SUCCESS_MESSAGE).getText();
    }

    public static BookingSuccessValidation successful() {
        return new BookingSuccessValidation();
    }
}