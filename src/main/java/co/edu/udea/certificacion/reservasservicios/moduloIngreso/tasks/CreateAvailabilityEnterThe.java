package co.edu.udea.certificacion.reservasservicios.moduloIngreso.tasks;

import co.edu.udea.certificacion.reservasservicios.moduloIngreso.interactions.CreateAvailabilityEnter;
import co.edu.udea.certificacion.reservasservicios.moduloIngreso.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class CreateAvailabilityEnterThe implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        Wait.waitSomeMills(3000);
        actor.attemptsTo(CreateAvailabilityEnter.information());
        Wait.waitSomeMills(3000);
    }

    public static CreateAvailabilityEnterThe information() {
        return Tasks.instrumented(CreateAvailabilityEnterThe.class);
    }
}