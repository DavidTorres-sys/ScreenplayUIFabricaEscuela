package co.com.udea.pagosb.modulopagosb.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo implements Task {

    private final String url;

    public NavigateTo(String url) {
        this.url = url;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }

    public static NavigateTo to(String url) {
        return Tasks.instrumented(NavigateTo.class, url);
    }
}
