package co.edu.udea.certificacion.reservasservicios.moduloIngreso.stepdefinitions;

import co.edu.udea.certificacion.reservasservicios.moduloIngreso.questions.BookingSuccessValidation;
import co.edu.udea.certificacion.reservasservicios.moduloIngreso.questions.NoSlotsValidation;
import co.edu.udea.certificacion.reservasservicios.moduloIngreso.tasks.CreateBookingEnterThe;
import co.edu.udea.certificacion.reservasservicios.moduloIngreso.interactions.OpenBookingModal;
import co.edu.udea.certificacion.reservasservicios.moduloIngreso.utils.Wait;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class CreateBookingStepDefinition {

    private Actor user() {
        return OnStage.theActorInTheSpotlight();
    }

    @When("I select an active offer and an available slot")
    public void iSelectAnActiveOfferAndAnAvailableSlot() {
        java.time.LocalDate nextDate = java.time.LocalDate.now().plusDays(2);
        while (nextDate.getDayOfWeek() == java.time.DayOfWeek.SATURDAY ||
            nextDate.getDayOfWeek() == java.time.DayOfWeek.SUNDAY) {
            nextDate = nextDate.plusDays(1);
        }
        String date = nextDate.toString();
        user().attemptsTo(CreateBookingEnterThe.forDate(date));
    }

    @Then("I can see a message indicating that the booking was successfully created")
    public void iCanSeeAMessageIndicatingThatTheBookingWasSuccessfullyCreated() {
        GivenWhenThen.then(user()).should(
            seeThat(BookingSuccessValidation.successful(),
                containsString("Reserva creada con éxito"))
        );
    }

    @When("I open the booking modal without selecting a slot")
    public void iOpenTheBookingModalWithoutSelectingASlot() {
        user().attemptsTo(OpenBookingModal.forFirstOffer());
        Wait.waitSomeMills(5000);
    }
}