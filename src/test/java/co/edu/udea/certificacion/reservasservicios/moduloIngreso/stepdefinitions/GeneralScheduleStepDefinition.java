package co.edu.udea.certificacion.reservasservicios.moduloIngreso.stepdefinitions;

import co.edu.udea.certificacion.reservasservicios.moduloIngreso.questions.GeneralScheduleValidation;
import co.edu.udea.certificacion.reservasservicios.moduloIngreso.tasks.SaveGeneralScheduleEnterThe;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class GeneralScheduleStepDefinition {

    private Actor user() {
        return OnStage.theActorInTheSpotlight();
    }

    @Given("that I am on the schedule page")
    public void thatIAmOnTheSchedulePage() {
        // El dashboard ya está abierto gracias al @requiresLoginProvider del Hook
    }

    @When("I save the general schedule")
    public void iSaveTheGeneralSchedule() {
        user().attemptsTo(SaveGeneralScheduleEnterThe.information());
    }

    @Then("I can see a message indicating that the schedule was successfully saved")
    public void iCanSeeAMessageIndicatingThatTheScheduleWasSuccessfullySaved() {
        GivenWhenThen.then(user()).should(
            seeThat(GeneralScheduleValidation.successful(),
                containsString("actualizado correctamente"))
        );
    }
}