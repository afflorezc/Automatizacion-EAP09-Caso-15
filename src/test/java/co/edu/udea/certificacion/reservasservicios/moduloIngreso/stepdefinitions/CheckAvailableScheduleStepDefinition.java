package co.edu.udea.certificacion.reservasservicios.moduloIngreso.stepdefinitions;

import co.edu.udea.certificacion.reservasservicios.moduloIngreso.questions.AvailableSlotsValidation;
import co.edu.udea.certificacion.reservasservicios.moduloIngreso.questions.NoSlotsValidation;
import co.edu.udea.certificacion.reservasservicios.moduloIngreso.tasks.ConsultAvailabilityEnterThe;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class CheckAvailableScheduleStepDefinition {

    private Actor user() {
        return OnStage.theActorInTheSpotlight();
    }

    @Given("that I am on the offers page")
    public void thatIAmOnTheOffersPage() {
        // El dashboard ya está abierto gracias al @requiresLoginCustomer del Hook
    }

    @When("I select a valid offer and a valid date")
    public void iSelectAValidOfferAndAValidDate() {
        java.time.LocalDate nextDate = java.time.LocalDate.now().plusDays(2);
        while (nextDate.getDayOfWeek() == java.time.DayOfWeek.SATURDAY ||
            nextDate.getDayOfWeek() == java.time.DayOfWeek.SUNDAY) {
            nextDate = nextDate.plusDays(1);
        }
        String date = nextDate.toString();
        user().attemptsTo(ConsultAvailabilityEnterThe.forDate(date));
    }

    @Then("I can see the available slots for the selected date")
    public void iCanSeeTheAvailableSlotsForTheSelectedDate() {
        GivenWhenThen.then(user()).should(
            seeThat(AvailableSlotsValidation.successful(), containsString("cupos"))
        );
    }

    @When("I select a valid offer and a date with no slots")
    public void iSelectAValidOfferAndADateWithNoSlots() {
        user().attemptsTo(ConsultAvailabilityEnterThe.forDate("2020-06-15"));
    }

    @Then("I can see a message indicating that there are no slots available")
    public void iCanSeeAMessageIndicatingThatThereAreNoSlotsAvailable() {
        GivenWhenThen.then(user()).should(
            seeThat(NoSlotsValidation.successful(),
                containsString("No hay cupos definidos para esta fecha"))
        );
    }
}