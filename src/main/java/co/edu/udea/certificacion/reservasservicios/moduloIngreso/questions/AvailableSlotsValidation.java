package co.edu.udea.certificacion.reservasservicios.moduloIngreso.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.edu.udea.certificacion.reservasservicios.moduloIngreso.userinterfaces.BookingObjects.*;

public class AvailableSlotsValidation implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(FIRST_SLOT_AVAILABLE).getText();
    }

    public static AvailableSlotsValidation successful() {
        return new AvailableSlotsValidation();
    }
}