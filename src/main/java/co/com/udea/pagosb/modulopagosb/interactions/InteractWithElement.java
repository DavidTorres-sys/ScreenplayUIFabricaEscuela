package co.com.udea.pagosb.modulopagosb.interactions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class InteractWithElement implements Interaction {

    private final Target target;

    public InteractWithElement(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(target)
        );
    }

    public static InteractWithElement click(Target target) {
        return Tasks.instrumented(InteractWithElement.class, target);
    }
}
