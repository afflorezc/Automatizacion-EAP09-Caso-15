package co.edu.udea.certificacion.reservasservicios.moduloIngreso.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import co.edu.udea.certificacion.reservasservicios.moduloIngreso.utils.SharedUserData;
import static co.edu.udea.certificacion.reservasservicios.moduloIngreso.userinterfaces.BookingObjects.*;

public class OpenBookingModal implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String serviceName = SharedUserData.getRegisteredService().getName();
        actor.attemptsTo(
            Click.on(BUTTON_BUSCAR_SERVICIOS),
            Click.on(BUTTON_RESERVAR_BY_NAME(serviceName))
        );
    }

    public static OpenBookingModal forFirstOffer() {
        return Tasks.instrumented(OpenBookingModal.class);
    }
}