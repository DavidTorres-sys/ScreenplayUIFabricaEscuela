package co.com.udea.pagosb.modulopagosb.interactions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class ClickElement implements Interaction {

    private final Target target;

    public ClickElement(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(target)
        );
    }

    public static ClickElement click(Target target) {
        return Tasks.instrumented(ClickElement.class, target);
    }
}
