package co.edu.udea.certificacion.reservasservicios.moduloIngreso.interactions;

import co.edu.udea.certificacion.reservasservicios.moduloIngreso.utils.Wait;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;

import static co.edu.udea.certificacion.reservasservicios.moduloIngreso.userinterfaces.BookingObjects.*;

@RequiredArgsConstructor
public class SelectBookingDate implements Interaction {

    private final String date;

    @Override
    public <T extends Actor> void performAs(T actor) {
        java.time.LocalDate localDate = java.time.LocalDate.parse(date);
        String formattedDate = localDate.format(
            java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")
        );
        actor.attemptsTo(
            Click.on(INPUT_DATE),
            SendKeys.of(formattedDate).into(INPUT_DATE)
        );
        Wait.waitSomeMills(5000);
    }

    public static SelectBookingDate withDate(String date) {
        return Tasks.instrumented(SelectBookingDate.class, date);
    }
}