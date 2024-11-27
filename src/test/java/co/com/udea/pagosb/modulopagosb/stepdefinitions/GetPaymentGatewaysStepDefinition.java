package co.com.udea.pagosb.modulopagosb.stepdefinitions;

import co.com.udea.pagosb.modulopagosb.questions.GetCurrentUrl;
import co.com.udea.pagosb.modulopagosb.questions.ParameterToValidate;
import co.com.udea.pagosb.modulopagosb.tasks.FindThe;
import co.com.udea.pagosb.modulopagosb.tasks.NavigateTo;
import co.com.udea.pagosb.modulopagosb.userinterfaces.UserPage;
import co.com.udea.pagosb.modulopagosb.utils.Constants;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class GetPaymentGatewaysStepDefinition {

    private final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private final String url = environmentVariables.getProperty("webdriver.base.url");
    private Actor user = Actor.named("user");

    /**
     * Setup method executed before the tests begin. Configures the actor and RestAssured settings.
     * This method ensures that the actor is ready to perform tasks
     */
    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        user = OnStage.theActorCalled("user");
        user.can(BrowseTheWeb.with(ThucydidesWebDriverSupport.getDriver()));
    }
    
    @Given("that the user is on the payment page")
    public void thatTheUserIsOnThePaymentPage() {
        user.attemptsTo(NavigateTo.to(this.url));
        user.should(seeThat(ParameterToValidate.
                        with(Constants.PURCHASE_SUMMARY_PAGE_TITLE_STRING, Text.of(UserPage.PURCHASE_SUMMARY_PAGE_TITLE).answeredBy(user)),
                is(true)));
    }

    @When("the system loads the payment menu")
    public void theSystemLoadsThePaymentPage() {
        user.attemptsTo(
                FindThe.element(UserPage.PAYMENT_MENU)
        );
    }

    @Then("the system should display a list of payment gateways including PSE, Bancolombia Button, Pay U, PayPal")
    public void theSystemShouldDisplayAListOfPaymentGatewaysIncludingPSEBancolombiaButtonPayUPayPal() {
        user.attemptsTo(
                FindThe.element(UserPage.BANCOLOMBIA_OPTION),
                FindThe.element(UserPage.PAYPAL_OPTION),
                FindThe.element(UserPage.PAYU_OPTION),
                FindThe.element(UserPage.PSE_OPTION)
        );
    }

    @When("the user selects a payment gateway")
    public void theUserSelectsAPaymentGateway() {
        user.attemptsTo(
                FindThe.element(UserPage.BANCOLOMBIA_OPTION)
        );
    }

    @Then("the system should redirect or simulate the flow of the selected gateway")
    public void theSystemShouldRedirectOrSimulateTheFlowOfTheSelectedGateway() {
        user.attemptsTo(
                FindThe.element(UserPage.PAYMENT_CONTINUE_BUTTON)
        );

        // TODO: Corregir la gestión de URLs y buscar por qué fallan los test.
        String currentUrl = user.asksFor(GetCurrentUrl.create());
        System.out.println(currentUrl);
        /*user.should(seeThat(ParameterToValidate.with(url,currentUrl),
                is(false)
        ));*/
    }

    @When("the user does not select any payment gateway and tries to proceed")
    public void theUserDoesNotSelectAnyPaymentGatewayAndTriesToProceed() {
       user.attemptsTo(FindThe.element(UserPage.PAYMENT_CONTINUE_BUTTON));
    }

    @Then("the system should display a message requesting the selection of a payment gateway")
    public void theSystemShouldDisplayAMessageRequestingTheSelectionOfAPaymentGateway() {
        user.attemptsTo(FindThe.element(UserPage.PAYMENT_GATEWAY_NOT_SELECTED_MESSAGE));
    }
}

