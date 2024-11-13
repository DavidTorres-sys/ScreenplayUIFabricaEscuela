package co.com.udea.pagosb.modulopagosb.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class GetPaymentGatewaysStepDefinition {

    private final Actor actor = Actor.named("user");

    /**
     * Setup method executed before the tests begin. Configures the actor and RestAssured settings.
     * This method ensures that the actor is ready to perform tasks
     */
    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
    }
    
    @Given("that the user is on the payment page")
    public void thatTheUserIsOnThePaymentPage() {
        throw new io.cucumber.java.PendingException();
    }


    @When("the system loads the payment page")
    public void theSystemLoadsThePaymentPage() {
        
    }

    @Then("the system should display a list of payment gateways including PSE, Bancolombia Button, Pay U, PayPal, Stripe, Wompi")
    public void theSystemShouldDisplayAListOfPaymentGatewaysIncludingPSEBancolombiaButtonPayUPayPalStripeWompi() {
        
    }

    @When("the user selects a payment gateway")
    public void theUserSelectsAPaymentGateway() {
        
    }

    @Then("the system should redirect or simulate the flow of the selected gateway")
    public void theSystemShouldRedirectOrSimulateTheFlowOfTheSelectedGateway() {
        
    }

    @When("the user does not select any payment gateway and tries to proceed")
    public void theUserDoesNotSelectAnyPaymentGatewayAndTriesToProceed() {
        
    }

    @Then("the system should display a message requesting the selection of a payment gateway")
    public void theSystemShouldDisplayAMessageRequestingTheSelectionOfAPaymentGateway() {
    }
}
