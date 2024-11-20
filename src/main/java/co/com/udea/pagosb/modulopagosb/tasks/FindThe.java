package co.com.udea.pagosb.modulopagosb.tasks;

import co.com.udea.pagosb.modulopagosb.interactions.ClickElement;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class FindThe implements Task {

    private final Target target;

    public FindThe(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickElement.click(target)
        );
    }

    public static FindThe element(Target target) {
        return Tasks.instrumented(FindThe.class, target);
    }
}
