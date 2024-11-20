package co.com.udea.pagosb.modulopagosb.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterValue implements Interaction {

    private final Target target;
    private final String value;

    public EnterValue(Target target, String value) {
        this.target = target;
        this.value = value;
    }

    public static EnterValue into(Target target, String value) {
        return instrumented(EnterValue.class, target, value);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(value).into(target));
    }
}
