package co.edu.udea.certificacion.reservasservicios.moduloIngreso.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.edu.udea.certificacion.reservasservicios.moduloIngreso.userinterfaces.BookingObjects.*;

public class ClickLogout implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BUTTON_LOGOUT));
    }

    public static ClickLogout button() {
        return Tasks.instrumented(ClickLogout.class);
    }
}