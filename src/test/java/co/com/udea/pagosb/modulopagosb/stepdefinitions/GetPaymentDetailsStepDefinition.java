package co.com.udea.pagosb.modulopagosb.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class GetPaymentDetailsStepDefinition {

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

    @Given("that the user is on the purchase summary page")
    public void thatTheUserIsOnThePurchaseSummaryPage() {
        throw new io.cucumber.java.PendingException();
    }

    @When("the user displays the purchase details tab")
    public void theUserDisplaysThePurchaseDetailsTab() {

    }

    @Then("the system should display the detailed breakdown of the purchase, including taxes, fees and additional charges")
    public void theSystemShouldDisplayTheDetailedBreakdownOfThePurchaseIncludingTaxesFeesAndAdditionalCharges() {

    }

    @Given("that the system has displayed the breakdown of the purchase costs")
    public void thatTheSystemHasDisplayedTheBreakdownOfThePurchaseCosts() {

    }

    @When("the system adds up the value of each item on the invoice")
    public void theSystemAddsUpTheValueOfEachItemOnTheInvoice() {

    }

    @Then("the system should calculate the total amount of the purchase")
    public void theSystemShouldCalculateTheTotalAmountOfThePurchase() {
    }
}
