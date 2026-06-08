package co.edu.udea.certificacion.reservasservicios.moduloIngreso.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BookingObjects {

    private BookingObjects() {}

    // Sidebar nav
    public static final Target BUTTON_BUSCAR_SERVICIOS = Target.the("Buscar Servicios button")
            .locatedBy("//*[@id=\"root\"]/div/aside/nav/button[2]/span");

    // Offer cards
    public static final Target FIRST_BUTTON_RESERVAR = Target.the("First reserve button")
            .locatedBy("(//button[contains(@class,'btn-reserve')])[1]");

    // Modal booking
    public static final Target INPUT_DATE = Target.the("Booking date input")
            .located(By.cssSelector("input.modal-date-picker"));

    public static final Target FIRST_SLOT_AVAILABLE = Target.the("First available slot")
        .located(By.cssSelector("button.slot-button:not([disabled])"));

    public static final Target NO_SLOTS_MESSAGE = Target.the("No slots message")
            .located(By.cssSelector(".no-slots-message span"));

    public static final Target LOADING_SPINNER = Target.the("Loading spinner")
            .located(By.cssSelector(".loading-spinner"));

    // Feedback
    public static final Target SUCCESS_MESSAGE = Target.the("Success message")
            .located(By.cssSelector(".alert-message.success span"));

    // Logout
    public static final Target BUTTON_LOGOUT = Target.the("Logout button")
            .located(By.cssSelector("button.logout-button"));

    // Login page after logout
    public static final Target LOGIN_WELCOME_TITLE = Target.the("Login welcome title")
            .located(By.cssSelector(".welcome-title"));

    public static Target BUTTON_RESERVAR_BY_NAME(String serviceName) {
    return Target.the("Reserve button for " + serviceName)
            .locatedBy("//h3[text()='" + serviceName + "']/ancestor::div[contains(@class,'offer-card')]//button[contains(@class,'btn-reserve')]");
}
}