package co.edu.udea.certificacion.reservasservicios.moduloIngreso.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class GeneralScheduleObjects {

    private GeneralScheduleObjects() {}

    public static final Target BUTTON_HORARIOS_ATENCION = Target.the("Horarios Atencion button")
            .locatedBy("//button[.//span[text()='Horarios Atención']]");

    public static final Target FIRST_BUTTON_GUARDAR_HORARIO = Target.the("Save schedule button")
            .located(By.cssSelector("button.btn-save-row"));

    public static final Target MESSAGE_SCHEDULE = Target.the("Schedule success message")
            .located(By.cssSelector(".alert-message.success span"));
}